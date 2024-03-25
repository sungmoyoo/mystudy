# Mybatis & SQL

## Record 와 자바객체
Mybatis의 <ResultMap/> 태그에서 지정하는 ID는 Join하여 발생한 중복값을 구분하는데 사용된다.

예를 들면 Board 테이블에서 파일을 3개 가진 게시글이 있다고 가정해보자
<img src="../../img/mybatisID.png">

위와 같이 파일이 3개임에 따라 같은 ID(게시글번호)를 가진 컬럼이 3개가 중복해서 등장한다. 

Mybatis는 <ResultMap>에서 지정한 ID가 같으면 중복된 값을 하나로 보고 하나의 객체만 생성하고 값을 저장한다. 회원의 경우도 마찬가지로 Board에 속한 객체로서 <Association/>태그의 별도의 ID를 가지고 Member 객체 하나에만 값이 저장된다. 

파일은 Collection 객체로서 Board에 저장된다. 

## Mybatis가 생성한 DAO 객체에서 SQL을 찾는 방식
Mybatis-Spring 연동 라이브러리에 들어있는 클래스는 @MapperScan 애노테이션에 지정한 경로로 찾아가서 dao 인터페이스를 찾아 자동생성한다.

만약 특정 메서드를 실행하라고 DAO 구현체에 호출이 들어오면 Mybatis는 FQName(Fully-Qualified Name)을 가진 SQL문을 찾아 실행한다. 

따라서 자동생성된 객체를 사용한다면 Mapper의 namespace 태그에도 인터페이스 이름을 전부 작성해야 한다. 


## 파라미터 처리
Mybatis에서는 파라미터를 하나밖에 받을 수 없어 여러 개의 파라미터를 넘겨야 할 경우 맵 객체에 담아 파라미터로 넘긴다. 

DAO 인터페이스에서 여러 파라미터를 넘길 때 @Param 애노테이션을 붙여 이름과 value를 지정하면 맵 객체에서 값을 찾아 쿼리에 넣어준다.


## 서비스 컴포넌트
기존의 방식은 Controller가 업무 흐름 제어, 요청/응답 데이터 처리, UI 흐름 제어 모두 담당하고 있다.

Controller가 여러 책임을 가지고 있기 때문에 결합도가 높고 유지보수가 힘들어진다.

Controller에서 업무 흐름을 제어(비즈니스 로직)를 처리하는 부분을 분리하여 Service로 만들어두면


## Controller-Service-DAO-Table
Controller, Service, Dao, Table은 요청에 따라 서로 상호작용하는 구조이다.

Controller는 여러 Service를 호출할 수 있고, Service도 여러 DAO를 호출할 수 있다. DAO도 마찬가지이다.

단 테이블에 대한 Ownership은 하나의 DAO만 가질 수 있으며 대신 다른 DAO는 View 권한을 가진다. 또 같은 계층끼리는 호출하지 않는 것을 우선으로 한다.

위의 내용은 일관성 측면에서 검증된 내용이므로 프로그램 설계/구현 시 준수하도록 하자


## Lombok
도메인 클래스를 쉽게 만들어주는 라이브러리

@Getter, @Setter, @ToString 애노테이션을 붙여 자동생성할 수 있다.

## 구동 원리
롬복을 사용하기 위해서는 컴파일 시 사용할 라이브러리와 롬복 애노테이션을 처리할 라이브러리를 빌드스크립트에 등록해야 한다.

롬복은 컴파일을 기준으로 getter/setter, toString을 생성한다. 라이브러리를 로딩하고 getter/setter, toString을 사용하려고 하면 컴파일러가 에러를 띄운다. 

왜냐? 컴파일 
