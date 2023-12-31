# 클래스 용도
  - 1) 메서드 분류(메서드를 묶을 때):  
  서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용
  - 2) 사용자 정의 데이터 타입 만들 때:  
  새로운 구조의 메모리를 설계할 때 사용

# 클래스: 메서드 분류

## 1. 메서드 분류 전
클래스 x, 메서드를 호출하여 작업을 수행한 후, 리턴결과를 로컬 변수에 저장하는 형태

## 2. 메서드 분류 후(static method)
- 메서드 앞에 static이 붙은 메서드, 객체 생성 없이 호출 가능하다. 
- 메서드를 클래스로 묶어 따로 분류, 결과를 담을 변수를 선언하고 로컬변수에 저장하는 형태이다.
- High cohesion, 밀접한 관계에 있는 기능을 묶는 것
- 따로 만든 클래스에서 메서드 작성 시 static을 붙인다.
```
public class Calculator{
  static int plus(int a, int b) {
    return a+b;
  }
}
```

## 3. 클래스 변수(static필드)
- 변수를 사용하는 곳으로 옮긴다.
- 정보를 처리하는 곳에서 정보를 가지고 있도록 하는 것. information expert에 가까움.
- 변수를 옮김으로서 다른 클래스에서 해당 변수를 사용하기 위해서 static으로 지정한다.
- static 변수로 저장된 메모리는 JVM이 종료될 때까지 유지된다. 
- 클래스 변수는 클래스 변수를 사용하기 위해 메모리에 적재될 때 생성한다. 이를 클래스 로딩이라고 한다. HDD -> RAM(method area)
- 클래스 변수는 클래스당 한번만 생성된다.

## 4. 클래스 변수의 한계
- 클래스 변수(Static field)는 클래스 로딩이 일어날 때 클래스당 한번만 생성되므로 동시에 여러 개의 변수를 저장할 수 없다.

## 5. 인스턴스 변수
- 클래스 변수와 달리 인스턴스 변수는 여러 개 저장 가능
- 하나의 클래스로 재사용과 동시처리가 가능하다.
- new 명령을 사용하여 heap메모리에 인스턴스 생성
- 파라미터에 인스턴스를 주소를 받아야 한다.
```
메서드 작성
static void plus(Calculator instance, int value) {
  instance.result += value;
}

메서드 호출 
Calculator.plus(c1, 2);
```

### *CPU, HDD, RAM 관계
- CPU는 HDD에서 메모리를 바로 읽어오지 않는다.
- HDD에서 RAM으로 데이터를 적재(읽어서 배치) 후 RAM에서 CPU가 로딩한다.
- HDD에서 바로 CPU로 읽으면 10만배 느리다.
- RAM에서 HDD처럼 사용하는 영역도 있는데 이를 램디스크라고 한다.

## 6. 인스턴스 메서드 활용
1. 이전 방식  
- 인스턴스 주소를 파라미터로 전달
```
Calculator.plus(c1,2);
```

2. 개선(간결한 방식)
- 인스턴스 주소를 앞에서 전달
- 레퍼런스의 타입을 보면 어떤 클래스의 메서드인지 알 수 있다.
- 메서드 내에서 인스턴스 변수를 사용할 수 있다. 
- static이 붙지 않는다. 
- 인스턴스 메서드는 호출할 때 반드시 인스턴스 주소를 주어야 한다.
```
c1.plus(2);
```
#### *this
: 메서드를 호출할 때 앞에서 전달한 인스턴스는 this라는 이름의 내장 변수에 자동 저장된다. 즉 앞에 놓인 인스턴스 주소를 일일이 적지 않고 this로 자동 보관시키는 것
```
int result

static void plus(int value) {
  this.result += value
   |
  메서드 호출 시 앞에 붙인 인스턴스 주소를 자동으로 보관
}
```
### *클래스 메서드(static method) vs 인스턴스 메서드(non-static method)
클래스.메서드();
- 작업결과를 개별로 관리하지 않을 때 사용
- 파라미터 값만으로 작업을 수행할 때

레퍼런스.메서드();
- 작업결과를 개별적으로 관리하는 경우
- 파라미터를 사용해서 작업을 수행한 후 그 결과를 내부적으로 보관할 때

## 7. 클래스를 역할에 따라 패키지로 분류
- 유지보수하기 쉽도록 클래스를 역할에 따라 분류하는 리팩토링 기법
- 패키지에 직접 소속된 클래스를 패키지 멤버 클래스라고 한다.
```
- 다른 패키지에 소속된 클래스 사용법
패키지명.클래스명
또는
import 패키지명.클래스명;
import 패키지명;
```

## Step 총정리
```
1. 클래스 문법 적용 전
2. 클래스로 매서드 분류: 스태틱 메서드
  - 클래스 분리
3. 스태틱 변수(클래스 변수)
  - 작업을 수행하는 클래스가 변수 생성(스태틱 변수)
4. 인스턴스 변수 
  - 한번만 만들어지는 스태틱 변수는 여러개 못만든다.
  - new로 생성 heap 메모리에 보관, 레퍼런스에 담아서 사용
5. 인스턴스 메서드: this
  - 파라미터
```

### OOP(Object-Oriented-Programming)
SOLID 원칙
- SRP(Single Responsibility Principle):  

- OCP(Open-Closed Principle):  

- LSP(Liskov Substitution Principle):  

- ISP(Interface Segregation Principle):  

- DIP(Dependnecy Inversion Principle:  
)
```
SOLID 원칙 -> GRASP 설계 기법 -> GoF Design Patterns 실용설계기법
```

# 클래스: 데이터 타입 정의

## 1. 낱개 변수 사용(클래스 사용 전)
  - 변수 선언 후, 사용 시 값이 계속 달라진다.
  - 중복이 많이 발생한다.

## 2. 사용자 정의 데이터 타입 만들기
  - 특정 유형의 데이터를 담을 전용 메모리(변수)를 설계한다.
  - 묶음으로 다룰 수 있도록 클래스로 분리
  - new 명령을 사용하여 클래스에 기술된 대로 Heap 메모리에 변수를 생성한다.
  - 변수들이 생성된 메모리의 주소를 레퍼런스에 저장한다.
  - Heap 영역에 생성된 인스턴스의 변수는 레퍼런스를 통해 접근한다. 
 ```
 Score s1 = new Score();
 s1.name = "홍길동"
 ```  
