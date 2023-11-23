# Java 문법2

# 1. 데이터 저장 방법(정수, 부동소수점)
1. 종이
- 10진수 100
- 8진수  0144
- 16진수 0x64
- 2진수  0b1100100

2. 컴퓨터 -> RAM 또는 HDD, CD-ROM, SSD 등
- RAM 
전기를 저장하는 칸을 비트라고 함  
컴퓨터에는 데이터(숫자,문자,색상,소리 ..)를 직접 저장할 수 없기 때문에 전기신호로 변환하여 저장한다.

- HDD
원판이 자성을 띰, SN극이냐 NS극 두 가지 상태가 존재
RAM과는 달리 자석방향에 따라 저장(마그네틱 신호)

##  1.1 데이터와 2진수
=> 숫자를 on/off로 표기해야 하는데 더 간결한 표기법이 있었으니
=> 바로 2진수
=> 숫자,문자,색상,소리 등 데이터를 2진수를 활용해서 RAM, HDD에 저장할 수 있다.

## 1.2 숫자(정수) -> 2진수로 변환하는 규칙
com.eomcs/lang/ex03/Exam0240
1) Sign-magnitude(부호 크기 절댓값)
맨 왼쪽 1비트를 부호비트로 사용, 나머지 비트는 절댓값으로 저장
  - 장점 
    - 이해하기 쉽다
  - 단점
    - +0과 -0이라는 값이 존재
    - 양수와 음수를 더했을 때 옳지 않은 값이 나온다.
  즉, 인간의 연산방식과 다르게 동작한다. 또 엉뚱한 결과를 

2) 1의 보수(보충해주는 수)
모든 비트를 반대값으로 바꾼다. 정확히는 1이되기 위한 양수의 값의 보수를 구하면 음수가 나온다. 
  - 단점
    - 오버플로우(초과)한 값을 맨 뒤에 더해야 음수 양수 계산에 옳은 값이 나옴

3) 2의 보수
1의 보수 계산의 단점을 극복하기 위해 음수로 만들때 미리 1을 더해두는 방식, 자바에서 사용  
모든 비트를 반대 값으로 만든 다음 1을 더한다.  
or  
오른쪽에서부터 1을 찾고, 찾은 1의 왼쪽편에 있는 모든 비트를 반대값으로 바꾼다.
  - 장점
    - 양수와 음수의 덧셈이 가능하다.
    - 음수 0이 없다. 0에 대한 표현이 한가지, 따라서 음수는 한자리 더 저장 가능

4) 바이어스(Excess-K; K-초과)
K를 바이어스 값(보태주는 수)이라 부르며, 표현하려는 값에 더할 때 사용된다. 
표현하려는 값 + 초과 값(K) = 결과
```
초과값(K) = 2^(비트 - 1)
```
어떤 값을 구하려 할때 항상 K를 더해서 나온 값을 결과로 사용
IEEE에서는 
```
초과값(K) = 2^(비트 - 1) -1
```
  - 장점
    작은값에서 큰 값으로 정렬된다

### 비트크기와 저장할 수 있는 값의 범위
- 8bit  
  -0000 0000 ~ 1111 1111 (-128 ~ +127) 2의 보수  
- 16bit  
  -32768 ~ 32727  
- 32bit  
  약 -21억 ~ +21억  
- 64bit  
  약 -922경 ~ +922경  
  

1. 메모리 기본단위  
-> 8bit(1byte)
2. 메모리 크기 분류
- 8bit(1byte)   byte     
- 16bit(2byte)  short    <- 자바에서 정수를 저장하는 메모리 크기에 대한 호칭
- 32bit(4byte)  int
- 64bit(8byte)  long

## 1.3 부동소수점(소수점이 둥둥 떠다니다.) = floating point
com.eomcs/lang/ex03/Exam0340

### 2진수와 16진수
2진수 4bit --> 16진수 1자리로 간결하게 표현할 수 있다.  
간결한 표기, 변환용이가 장점
=> 따라서 2진수를 간결하게 표현하는 방법으로 16진수를 많이 사용한다. 

## 1.4 부동소수점을 저장하는 메모리 크기(IEEE-754 명세)
com.eomcs/lang/ex03/Exam0340 4.4 메모리 담기
- 32비트(4byte) 메모리에 담기 <- float(단정도)  
[1:부호비트][8:지수부][23:가수부]  
=> 부동소수점을 얼마나 정밀하게 저장할 수 있느냐는 메모리 크기에 달려있다.  

- 64비트(8byte) 메모리에 담기 <- double(배정도)  
[1:부호비트][11:지수부][52:가수부]  
=> 2배 이상 더 정밀한 값을 보장할 수 있다.

### 유효자릿수
- 소수점을 뺀 숫자의 개수
실수는 정수처럼 메모리를 저장할 때 정해진 범위가 없어 애매하다.  
따라서 유효자릿수에 따라 7자리까지는 float, 15자리까지는 double을 사용