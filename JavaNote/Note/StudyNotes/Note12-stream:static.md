# 키보드 입력 다루기

# 1. 입출력 스트림 개념
*System.in = 표준입력장치의 정보가 저장된 메모리의 주소를 보관하고 있는 레퍼런스
```
                                    (메모리)
주소 ------------------------------> 표준입력장치 정보
                                
1. 표준입력장치(keyboard 입력)
$wc

aaa bbb -----> wc프로그램
         전달   |
              표준입력장치

---------------------------------------------

2. 표준입력장치(다른프로그램의 출력)
$cat Hello.c | wc

Hello.c -----> cat프로그램 -----> wc프로그램
         읽기           |  출력   |
                  표준출력장치     표준입력장치
```

## 1.1 표준입력스트림과 표준출력스트림
모든 프로그램은 표준입력스트림과 표준출력스트림이 존재한다.  
+표준오류시스템도 있다.
```
System.in -> 표준입력스트림
= 프로그램 외부에서 데이터가 들어올 수 있는 기본 입구  
이 표준입력스트림에 어떤 것이 연결된 것이 연결되있는지에 따라 들어오는 데이터가 달라진다.

System.out -> 표준출력스트림  
= 프로그램 실행결과를 외부로 내보낼 수 있는 기본 출구  
터미널, 다른 프로그램의 표준입력스트림, 파일 등 연결이 가능하다.

System.err -> 표준오류스트림(Out방향)
= 프로그램 실행 중 오류가 발생했을 때 오류정보를 내보낼 때 사용하는 특별한 출구
```

## 1.2 소켓(Socket)
외부 네트워크로 데이터를 주고 받기 위해 별도의 입/출구를 뚫는 것

## 1.3 File I/O 스트림
외부 파일로 데이터를 읽고 쓰기 위해 입/출구를 뚫는 것

# 2. 표준입력장치에서 데이터 읽기
```
            수행할 수 있는 명령
System.in - read
          - read(byte[]) -> 한줄 단위로 입력된 문자열을 읽는 작업을
            ...             수행시키는 명령이 없다.
    |
    v
new Scanner()   - nextLine()
= 표준입력스트림을   - nextInt()  
좀더 정교하게 제어   - next()
하려면추가 데이터와   ...
메서드 필요
```

# 3. 메서드 실행(호출)
```
--------------
| Scanner정보 |
| (200번지)   |
--------------

Scanner keyIn = new Scanner(System.in);
       (200번지)

keyIn.nextLine(); - 레퍼런스에 적혀있는 주소로 찾아가서 그 메모리에
   |                저장된 정보를 이용하여 작업 수행한다.
(200번지)
(레퍼런스)
```

```
--------------
| Scanner정보 |
| (200번지)   |
--------------

Scanner keyIn = new Scanner(System.in);
       (200번지)

keyIn.nextLine(); 
  |
=Scanner 정보 -> 일반인의 용어
=Scanner 객체 -> keyIn 변수에 Scanner 정보가 들어있는 것은 아니지만
                정보가 들어있는 변수로 간주하여 표현한다. 
                왜? 표현의 간결성, 의사소통을 단순하게, 이해를 쉽게

=> "keyIn 객체에 대해 nextline()을 호출"
```

## 2.1 메서드(method) = 함수(function)
```
리턴값의타입 기능이름(값을 받을 변수 선언){명령문...}

ex) int plus(int a, int b){
  int result;
  result = a+b;
  return result;
}
```

### nextInt(), nextLine(),...
- nextInt()는 한 개의 토큰을 읽은 후에 줄 바꿈 코드는 읽기 전 상태로 내비둔다.
- 따라서 다음에 nextLine()을 호출하면 의도치 않게 빈 문자열을 가진 한 줄을 읽는 상황이 된다.

- 해결방법?  
남아 있는 엔터 코드를 읽어서 제거 
```
System.out.print("나이? ");
keyScanner.nextint()

keyScanner.nextLine() <- 빈 문자열 제거

System.out.print("이름? ");
keyScanner.nextLine()
``` 


# 로컬변수와 클래스 변수(static)
```
class App{
  static int a; <- class(변수;필드) = static field

  void m(){
    int b       <- 로컬 변수(local variable
  }             <- 메서드 안에 선언된 변수
}               <- 메서드 실행될 때 생성되고 실행이 끝나면 제거

```