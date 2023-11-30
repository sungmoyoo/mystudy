# 1일차 단어
- application:  
    응용 프로그램
  
- rendering:  
    이미지/장면을 화면에 출현/표현하는 것
  
- software, program:  
    프로그램은 명령어들의 모음, 소프트웨어는 프로그램 뿐만 아니라 CD, 설명서 등 패키지 전체를 뜻하지만 일반적으로는 같은 의미로 사용된다. 
  
- DNS(Domain Name System):  
    사람이 읽을 수 있는 도메인 이름을 기계가 읽을 수 있는 IP주소로 변환하는 시스템
  
- IP(Internet Protocol):  
    송신 호스트와 수신 호스트가 패킷 교환 네트워크(Packet Switching Network)에서 정보를 주고받는 데 사용하는 정보 위주의 규약(주소)
  
- react:  
    Front End framework, 사용자 인터페이스를 구축하기 위한 JavaScript 라이브러리, "컴포넌트"라고 불리는 코드 파편을 이용하여 복잡한 UI 구성
    
- DOM:  
    문서 객체 모델, HTML문서를 계층적 구조와 정보로 표현하는 자료구조
  
- url(Uniform Resource Locator):  
    웹에 게시된 리소스를 검색하기 위해 브라우저에서 사용하는 메커니즘, 웹에서 주어진 고유 리소스 주소, 즉 네트워크 상에서 자원이 어디 있는지 알려주기 위한 규약
  
- servlet:  
    서버쪽에서 실행되며 클라이언트의 요청을 동적으로 처리할 수 있게끔 도와주는 자바 클래스
  
- servlet container(Tomcat, Jeus):  
    서블릿 여러개를 관리해주는 컨테이너, 
  
- spring framework  
    자바 객체를 담고 직접 관리하는 컨테이너, 서블릿 컨테이너에 실행결과값을 전달한다.
  
- IoC(Inversion of Control):  
    제어의 역전, 제어의 흐름을 사용자가 컨트롤하지 않고 위임한 특별한 객체에 모든것을 맡기는 구조
  
- spring boot:  
    servlet container와 spring framework를 합친 것
  
- WAS(Web Application Server)  
    웹 애플리케이션과 서버 환경을 만들어 동작시키는 기능을 제공하는 소프트웨어 프레임워크
  
- Apache HTTP server:  
    아파치 재단에서 관리하는 오픈 소스, 크로스 플랫폼 HTTP 웹 서버 소프트웨어
  
- nginX?  
    트래픽이 많은 웹사이트의 서버(WAS)를 도와주는 비동기 이벤트 기반구조의 경량화 웹 서버 프로그램
  
- standalone  
    설치만으로 단독적으로 실행 가능한 프로그램
  
- client/server  
    설치(로컬) 또는 웹브라우저를 통해 client와 server를 통신하여 실행하는 프로그램


# 2일차 단어
- uml(Unified Modeling Language):  
    개발 시스템을 이해하기 쉬운 형태로 표현하여 효율적으로 의사소통할 수 있게 해주는 표준화된 모델링 언어, 개발 시 시스템과 산출물을 명세화 시각화 문서화 할 때 사용한다.

- stereotype:  
    ???

- instruction set:  
    명령어 집합, 마이크로프로세서가 인식해서 기능을 이해하고 실행할 수 있는 기계어 명령

- compile:  
    소스코드를 바이너리 코드로 변환하는 과정. 프로그래밍 언어로 작성된 소스코드를 컴퓨터가 이해할 수 있는 기계어 혹은 중간 언어로 변환하는 과정이다.

- source code:  
    프로그래밍 언어로 작성된 코드

- bytecode:  
    기계어와 흡사한 구조로된 중간형태의 명령, p-code라고도 불림(진짜 기계어가 아님)

- bytecode interpreter(engine, player, viewer, virtual machine):  
    특정 형식으로 된 명령이나 데이터 입력받아서 해석해서 실행하는 것 == JVM(Java Virtual Machine)

- JRE(Java Runtime Environment):  
    JVM + 실행관련파일

- JDK(Java Development kit):  
    JRE + Java Compiler + debugger + profiler ..

- Java SE(Standard Edition):  
    개인용 웹 개발

- Java EE(Enterprise Edition):  
    기업용 서버 App 제작에 필요한 도구

- Java ME(Micro Edition):  
    임베디드 App 제작에 필요한 도구

- Command Line Interface <-> Graphic User Interface  

- 환경변수:  
    운영체제가 어떤 프로세스를 실행시킬때 실행시키는데 필요한 파일이 있는 경로를 찾는데 이용되는 변수
```
java.exe - 자바 실행파일
javac.exe - 자바 컴파일러
jdb.exe - 자바 디버거
```

- LTS(Long Term Support):  
    일반적인 경우보다 장기간에 걸쳐 지원하도록 특별히 고안된 소프트웨어의 버전

- Process:  
    실행하는 프로그램

- schduling:  
    프로세스 관리  

- Kernel:  
    os의 핵심기능, ex)CPU/RAM 관리, Process 관리/스케줄링

- shell:  
    Kernal의 기능을 사용할 수 있도록 연결 역할을 함 CLI 
```
window => 명령프롬프트, powershell
linux, unix => ex)sh, bash, tsh, csh, zsh
```

- usr:  
    unix resource 파일 저장하는 폴더

- IDE(Integrate Development Environment):

- REPL:  
    Read -> Evaluation(실행) -> Print -> Loop <br> = JSHELL, 간단히 자바 명령을 실행, 테스트 하는 용도

- Repo. (Repository):  
    소스파일 저장소

- Software Configuration Management(SCM):  
    형상관리시스템, 소스변화관리, 버전관리

# 3일차
- QC(Quality Control), QA(Quality Assurance), QM(Quality Management):  
    품질관리, 품질보증, 품질경영 = QC와 QA의 종합적인 의미.

- cursor:  
    컴퓨팅에서 커서(cursor)는 컴퓨터 모니터 등의 디스플레이 장치 위에서 입력을 기다리거나 위치를 가리키는 물체, 곧 포인터를 지칭한다.

- 플레인 텍스트 파일(Askii File):  
    아스키코드로 글자를 나타내는 파일, 다양한 텍스트 편집기로 편집할 수 있는 파일

- markup:  
    콘텐트를 제어하는 명령, 메타데이터, 태그라고도 함

- binary file(이진파일):  
    0과 1이라는 2진수 데이터로만으로 이루어진 파일, 전용 편집기를 사용해야만 편집할 수 있는 파일 ex).jpg, .mp4, .xlsx

- token(git):  
    변경된 데이터를 commit하고 push하는데 사용되는 토큰, 사용자이름/비번 안쳐도 됨

# 4일차
- shell:  
    사용자가 입력한 명령어를 해석해서 운영체제가 이해할 수 있는 기계어로 변환하여 지시해주는 명령 프롬프트라고 이해

- bash(Bourn-Again shell):  
    ourne 쉘의 기능을 계승하고 추가적인 기능을 추가한 쉘, 리눅스/mac os의 기본 쉘이었다.

- zsh:  
    본 쉘의 확장 버전으로 많은 기능과 플러그인 테마를 지원하는 현재 리눅스/mac os의 기본 쉘

- ant(apache.org):  
    자바 기반의 빌드 도구, 빌드 파일 이름은 build.xml

- Maven:  
    apache ant의 대안, 의존라이브러리 기능을 포함, pom.xml

- Gradle:  
    groovy를 기반으로 한 빌드 자동화 도구, 보다 정밀한 빌드과정 제어 가능

- Glob 패턴  
    와일드카드 문자들을 사용해서 일정한 패턴을 가진 파일 이름들의 지정하기 위한 패턴.

# 5일차
- DSL(Domain-Specific Language):  
    특정 영역에 코드를 작성할 때 사용할 언어

# 6일차
- 클래스 블록:  
    컴파일의 기본단위는 클래스 블록이다. 블록은 파일 안 {}을 의미

- API(Application Programming Interface):
    데이터를 주고받기 위한 방법과 그 규격을 뜻한다.

- API 문서:  
    API의 사용법과 규격을 제공하는 문서

- 애노테이션:  
    자바에서의 애노테이션은 코드 사이에 주석처럼 쓰이며 특별한 의미, 기능을 수행하도록 하는 기술이다.


# 7일차
- RAM(Random Access Memory):  
    프로그램이 실행되는 동안 필요한 정보를 저장하는 컴퓨터 메모리, 전기신호를 통해 데이터를 저장한다.

- HDD(Hard Disk Drive):  
    컴퓨터 데이터를 저장하는 비휘발성 보조기억장치, 자석방향에 따라 데이터 입출력이 가능하다.

- SSD(Solid State Drive):  
    HDD와 달리 반도체 소자를 활용한 보조기억장치

- Sign-Magnitude(부호-크기 절대값):  
    맨 왼쪽 비트를 부호로 취급하여 음수여부를 결정하고 나머지 비트는 절대값으로 저장하는 방식

- 보수(complement):  
    보충해주는 수

- 부동소수점:  
컴퓨터상에서 실수를 표현할 때 소수점의 위치를 고정하지 않고 그 위치를 나타내는 수를 따로 적음

- 가수부, 지수부:  
부동소수점에서 유효숫자를 나타내는 부분을 가수부, 소수점의 위치를 풀이하는 지수부로 나뉜다.

- 유효자릿수:  
소수점을 제외한 후 계산한 자릿수

- 단정도(single-precision):  
    부동소수점을 32비트로 표현하는 방법, float

- 배정도(double-precision):  
    부동소수점을 64비트로 표현하는 방법 32비트에 대비해 두 배 가량 정밀하게 표현할 수 있다, double


# 8일차
- 리터럴(literal):  
    소스 코드의 고정된 값을 나타내는 표기법, 변수에 넣는 변하지 않는 데이터

- Exponetial 기호:
    e기호를 사용하여 소수점의 위치를 조절할 수 있다. ex) 31.4-E1 = 3.14

- UTF-16 LE(Little-Endian), BE(Big-Endian;UCS2):
    16비트로 표현하는 유니코드의 앞 8비트와 뒤 8비트의 순서를 거꾸로 되어 있는 것이 LE 윈도우에서 사용한다. 이론적으로 처리 속도가 더 빨라진다. BE는 앞뒤 바이트 순서가 원래대로 있는 것. 자바와 맥에서 사용한다. 

- Raster폰트(bitmap):  
    특정한 크기나 형태의 문자 세트로, 각 문자가 비트맵(도트패턴)으로 되어 있는 것.

- Vector폰트(truetype:)  
    벡터 그래픽스 형태로 표현된 글꼴

# 9일차
- Reference:  
인스턴스의 주소를 저장하는 변수를 의미한다. 간접적으로 정보를 담고 주소를 참조하여 실제 값을 저장하므로 참조형 변수라고도 한다.

- 변수 호이스팅:  
Javascript 호이스팅은 인터프리터가 코드를 실행하기 전에 함수, 변수, 클래스 또는 임포트의 선언문을 해당 범위의 맨 위로 이동시키는 과정

- r-value, l-value:  
할당연산자 왼쪽 = l-value  
할당연산자 오른쪽 = r-value

- 문장(statement):  
프로그램 내에서 하나의 동작을 기술하는 것. 블록 안에 모여서 메서드와 클래스를 구성. 변수 선언, 조건문, 반복문 등이 해당

- 표현식(expression):  
값을 리턴하는 statement, 어떠한 값을 내포하고 있으면 expression으로 볼 수 있다. 리터럴, 산술식, 리턴값, 변수가 이에 해당

# 10일차
- rust  
    c의 대체자. 모질라 리서치에서 개발한 다중 패러다임, 범용 프로그래밍 언어.

- static type binding(정적 바인딩;Java)  
    변수 선언 시 타입이 고정된다.

- dynamic type binding(동적 바인딩; Javascript)  
    값을 할당할 때 변수의 타입이 결정된다.  

- Method Overriding:  
    부모와 자식 Class 모두 동일한 Method가 존재, 오직 실행 시점에 타입이 결정되어 해당 타입의 Method가 실행됨

- explicit type conversion(명시적 형변환):  
    명시적으로 타입을 지정하는 것. 지정한 타입으로 형 변환되는 것.

- implicit type conversion(암시적 형변환):
    더 큰 크기의 타입에 변수를 넣는 경우, 혹은 서로 다른 크기의 타입 간 연산 시 작은 크기의 타입이 큰 크기의 타입으로 자동 형 변환되는 것.

- masking(마스킹):  
    AND(&) 비트 연산자를 사용하여 특정 값을 차단.  

- overlay(오버레이):  
    OR(|) 비트 연산자를 사용하여 특정 값 덮어 씌움.(강화)

# 11일차
- parameter(매개변수): 
    argument 값을 담는 로컬 변수

- argument(인수, 인자)
    메서드를 호출할 때 전달하는 값(실제 메모리에 할당되는 데이터)

- generic:
    - 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있도록 하는 방식  
    - 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것. 타입을 미리 지정하지 않고 컴파일 때 해당 타입으로 캐스팅하여 매개변수화된 유형을 삭제하는 방식

- Raw type
    제네릭 타입에서 Type Parameter를 전혀 사용하지 않을 때 로 타입이라고 한다. 

- enum(열거 타입):  
    요소, 멤버라 불리는 명명된 값의 집합을 이루는 자료형, 변수명만 사용할 것을 목적으로 만들 상수 데이터 집합, 값이 존재하지 않는다.

- label(라벨)
    다중반복문에 이름을 부여하는 방법  
    첫 반복문 앞에 '(이름):'을 붙여 사용

- Scanner:  
    입력과 관련된 클래스, util 패키지 경로에서 호출하여 사용

- overriding:  
    - 상속 관계에 있는 부모 클래스에서 이미 정의된 메소드를 자식 클래스에서 같은 시그니쳐를 갖는 메소드로 다시 정의하는 것.  
    - 부모의 private 멤버를 제외한 모든 메소드를 자식클래스에서 사용할 수 있는데 이때 필요동작을 위해 재정의하는 것

# 12일차
- pipeline(|):  
    리눅스에서 pipeline은 명령어 1의 처리결과를 명령어2에 전달하는 것을 의미한다.

- wc 명령어:  
    WordCount 의 약자로, 파일에 들어있는 단어 및 라인의 개수와 파일 크기를 표시해준다.

- cat 명령:  
    파일(들)의 내용을 출력하는 명령어, 여러 파일을 이어서 출력할 수도 있다.
- 스트림(stream):
    프로그램을 드나드는 데이터, 파일 등의 바이트 흐름, 자바에서는 입력/출력스트림으로 구분되어 데이터의 입구/출구의 개념으로 이해하면 된다.

- token:  
    문법적으로 더 이상 나눌 수 없는 언어의 요소, 구문적으로 의미를 갖는 최소의 단위, 즉 기본 '단어'

- 객체:  
    변수에 레퍼런스 정보가 들어있는 것은 아니지만 정보가 들어 있는 변수로 간주하여 객체라고 표현한다.  
    또 클래스를 통해 정의된 변수인 인스턴스를 객체라고도 부른다.

- 메소드:  
    레퍼런스에 적혀있는 주소를 통해 인스턴스를 찾아서 작업을 수행하도록 하는 명령어

- 인스턴스(instance):
    데이터가 메모리에 할당되어 실제 저장된 것

- 클래스 변수(static field):
    메서드 밖에 클래스에 선언된 변수, 앞에 static을 붙여 선언, 클래스 내부의 모든 메서드에서 변수 사용이 가능하다.

- 로컬 변수:
    메서드 내에 선언된 변수, 선언된 메서드 블록 내에서만 사용가능하고 블록 실행 종료 시 제거된다. 

# 13일차
- replace temp with query:  
    임시 변수를 질의 함수 형태로 변환하는 리팩토링 기법

- 메서드(=함수):  
    코드를 관리하기 쉽고 재사용하기 쉽도록 기능 단위로 묶어놓는 문법

- 메서드 시그니쳐:  
    메서드 이름과 파라미터 리스트의 조합

- 메서드 바디:  
    메서드 내 문장

- 가변 파라미터:  
    - [리턴타입] 메서드명(타입... 변수) {...}  
    - 0개 이상의 값을 받을 떄 선언한다.  
    - 메서드 내부에서는 배열처럼 사용한다.

- 배열 파라미터:  
    - [리턴타입] 메서드명(타입[] 변수) {...}  
    - 배열을 직접 담아서 전달, 배열을 넘길 경우 복제가 아닌 그대로 사용
    - 낱개의 값을 전달할 수 없다. 오직 배열주소만 넘겨야 한다.

- call by value: 
    메서드를 호출할 때 값을 넘기는 경우 call by value라고 한다. 이 때 값은 primitive data type, 즉 byte short char int long float double 총 8개만 존재한다.

- call by reference:
    primitive data type을 제외한 나머지는 모두 reference type으로 객체에 인스턴스 주소를 전달하는 경우이다. 인스턴스의 실제 메모리는 heap영역에 저장되며 그 인스턴스가 저장되어 있는 주소를 레퍼런스라고 한다. 

- Stack:  
    호출된 메서드의 로컬 변수를 두는 곳

- Heap:  
    new 명령으로 만든 변수(인스턴스)를 두는 곳

- Method Area:  
    class byte code를 두는 곳
    static(class) 변수 두는 곳

- Thread:  
    프로세스안에서 실질적으로 작업을 실행하는 단위, 하나의 코드실행흐름
    스레드는 각각 Stack 영역은 따로 할당 받고 나머지 영역은 공유한다.따라서 하나의 쓰레드에서 오류가 발생한다면 프로세스의 다른 쓰레드도 모두 강제 종료 된다.

- Frame:  
    - 메서드를 호출하는 시점에 생성된 메모리 영역을 Frame이라고 한다.
    - Stack 영역에 할당, 메서드가 종료되면 파괴된다. 로컬변수를 array형태로 갖는다.

- stack overflow:  
    JVM 스택 메모리가 꽉 차서 더이상 메서드 실행에 필요한 로컬 변수를 만들 수 없는 상태일 때 발생하는 에러, 재귀호출과 같이 Frame과 로컬변수 많이 만드는 상황에서 많이 발생한다.

- 리팩토링(Refactoring):  
    결과의 변경없이 코드의 구조를 재조정함으로써 가독성과 재사용성을 높여 유지보수를 편하게 하는 기법



