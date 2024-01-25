# 상수 
```
final PI = 3.14
```

### Java vs Javascript 
static type binding vs dynamic type binding

```
int a;

a = 100; (O)
a = '가'; (O)
a = 3.14f; (X)
a = 3.14; (X)
a = true; (X)
=> 자바는 static type binding, 선언 시 변수의 타입이 고정된다. 

var a;
a = 100;   (O)  number타입
a = "aaa"; (O)  string타입
a = true;  (O)  boolean타입
=>Javascript는 dynamic type binding, 값을 할당할 때 변수 타입이 결정된다.
```

# 4. 연산자
## 4.1 산술연산자(+,-,*,/,%)
1. 우선순위
- ()
- *,/,%
- +,-
- =

2. 기본 연산 단위
- 연산은 int가 기본
```
byte b;
b = 5;
원래는 안된다. 단 리터럴 값인 경우 메모리에 넣을 수 있다면 허용'
```
```
byte x = 5, y = 6, z;
z = x + y; (X)
z = 5 + 6; (X)
연산 시 암시적 형변환에 의해 x+y의 값이 int메모리에 저장되었으므로 byte 형태인 z에 할당 할 수 없다.
```
- 산술연산 결과
```
byte-byte = int
byte-short = int
short-short = int
int-int = int
int-long = long
long-float = float
float-double = double
```

- 암시적 형변환
```
서로 다른 데이터 타입과의 연산 시 보다 더 큰 메모리를
가진 타입으로 형변환이 이루어지고 보다 더 정밀한 타입
으로 형변환이 이루어진다. 즉 자동으로 타입을 같게 하는 것

암시적 형변환의 규칙
byte=short -> int -> long -> float -> double
```

- 범위 초과
```
int x = Integer.MAX_VALUE;
int y = Integer.Max_VALUE;
int z = x + y;
=> -2 

연산결과가 해당 데이터타입의 범위를 초과하면 의도한 결과가
나오지 않을 수 있다.

연산과정에서 발생한 문제이므로 연산결과를 더 큰 메모리에 담아도 소용없다. 
long z = x + y; 
=> -2

따라서 형변환하여 계산하거나 처음부터 메모리에 맞는 데이터 타입을 선언한다.
int z = (long)x + (long)y
=> 4294967294

long a = Integer.MAX_VALUE;
long b = Integer.MAX_VALUE;
long c = a + b;
=> 4294967294
```

## 4.2 관계연산자(>,<,>=,<=), 등위연산자(==,!=)
관계연산자 + 등위연산자 = 비교연산자
비교의 결과는 항상 true 또는 false이다. 즉 boolean 값이다. 

### 부동소수점 비교
- IEEE 754 명세에 따라 2진수로 바꿔 메모리에 저장할 때 정규화 과정에서 정수로 딱 떨어지지 않고 극한의 소수점이 발생할 수도 있기 때문에 유의해야 한다. 
- 실무에서는 개발자가 직접 극소수의 값을 무시하도록 처리한다. 
```
double d1 = 987.6543;
double d2 = 1.111111;

double x = 234.765411;
double y = 754.0;

double EPSILON = 0.00001;
System.out.println(MATH.abs((d1+d2)-(x+y)<EPSILON))
```

## 4.3 논리연산자(&&,||,!,^)
논리 연산자는 두 개의 논리 값을 연산하여 true 혹은 false을 결과로 얻는 연산자  
boolean이 아닌 데이터 타입에 대해서는 사용할 수 없다.  
정수 값에 논리연산자를 사용하면 비트연산자로 작동한다.  
- AND 연산자(&&)  
: 두 개의 논리 값이 모두 true일 때 결과가 true

- OR 연산자(||)  
: 두 개의 논리 값 중 한개라도 true이면 결과가 true

- NOT(!) 연산자  
: true는 false로 false는 true로 반전시킨다.

- exclusive-OR(^;XOR) 연산자
: 배타적 비교 연산자, 두 개의 논리값이 서로 다를 떄 true

### (&& vs &), (|| vs |)
- && 혹은 || 연산에서 왼쪽 논리값에 의해 결과가 확정된 경우 JVM은 효율을 위해 오른쪽 논리값 연산을 실행하지 않는다.
- & 혹은 | 연산에서는 왼쪽의 결과에 상관없이 모든 문장을 실행한다. 

## 4.4 비트연산자(&,|,^,~)
비트단위로 논리연산을 할 때 사용하는 연산자  
특정 값을 차단하거나 강화하는데 유용하다.  
주로 이미지 및 영상처리에 사용된다. ex)마스킹, 오버레이
- &(AND)  
: 대응되는 비트가 모두 1이면 1을 반환

- |(OR)  
: 대응되는 비트 중 하나라도 1이면 1을 반환

- ^(XOR)  
: 대응되는 비트가 서로 다르면 1을 반환

- ~(NOT)
: 비트가 1이면 0을, 0이면 1로 반전

### 비트 연산 활용 예시
- 특정 색상 제거
```
      R        G        B
  11001010 11100100 00111001 (예제 색상)
^ 11001010 11100100 00111001 (제거하려는 색상)
----------------------------
  00000000 00000000 00000000 (출력 결과)
```

### 비트연산자 &을 이용하여 % 연산 구현
- 2^n으로 나눈 나머지를 구함으로써 구현가능
```
54 & 1
  00110110
& 00000001
----------
  00000000 => 0 

단 2^n으로 나눌때만 가능
```

- 응용(홀짝 여부 판단)
```
57 & 0x1 == 0 ? "짝수" : "홀수"

54 & 1
  00110110
& 00000001
----------
  00000000 

=> 맨 오른쪽 비트가 0인 경우 짝수, 1인 경우 홀수로 출력
```

## 4.5 비트 이동 연산자(<<,>>,>>>)
비트를 이동시키는 연산자.
1. << (왼쪽 이동)
- 왼쪽으로 비트를 이동시킨다.
- 오른쪽 빈자리는 0으로 채운다.(양수)
- 왼쪽 경계를 넘어간 비트는 자른다.
- 곱하기보다 실행이 빠르다.
- 부호비트에 상관없이 무조건 이동하므로 음수가 양수로 바뀔 수 있다.  
  
<br>

- 비트이동마다 2^이동비트를 한 것과 같은 결과이다.
```
value << n = value * 2^n
```

<br>

- 이동 비트가 데이터 범위를 초과하는 경우 해당 데이터 범위를 나눈 나머지 값을 비트 이동으로 간주한다.
```
(int)
value << n (n>31)
n = n%32

(long)
value << n(n>63)
n = n%64
```

2. >> (오른쪽 이동)
- 왼쪽 빈자리를 원래 숫자와 같은 부호 값으로 채운다. 양수는 0 음수는 1
- 오른쪽 경계를 넘어간 비트는 자른다.
- <<와는 반대로 2**n으로 나눈 것과 같은 결과이다.

3. >>>
- 빈자리를 음수 양수 상관없이 무조건 0으로 채운다.
- 음수의 경우 양수로 바뀐다. 

### 비트 이동 연산자 활용
- 실무에서는 비트 이동 연산자를 활용하여 여러 개의 true/false를 저장하기도 한다.
- 비트 연산자를 사용하면 메모리를 절약할 수 있기 때문
```
비트 연산자 사용 전 8개의 데이터를 저장하기 위해서는 32바이트가 소요된다.
boolean c, cpp, java, js, python, php, html, css;
c = true;
cpp = false;
java = true;
js = false;
python = true;
php = false;
html = true;
css = false;
```

- 배열을 활용하면 8바이트를 사용
```
boolean[] lang = new boolean[8];
lang[0] = true;
lang[1] = false;
lang[2] = true;
lang[3] = false;
lang[4] = true;
lang[5] = false;
lang[6] = true;
lang[7] = false;
```

- 비트 연산자를 활용하면 4바이트로 32개 데이터 저장 가능
```
int lang2 = 0;
00000000 00000000 00000000 00000000

32비트에서 뒤에 8비트를 사용하여 8개의 true/false 값을 저장할 수 있다.
8 비트에서 각 언어에 값을 저장할 비트를 다음과 같다고 가정하자.
00000000
||||||||- css
|||||||- html
||||||- php
|||||- python
||||- javascript
|||- java
||- c++
|- c

이렇게 준비된 32비트 메모리에서 특정 비트의 값을 1로 설정하고 싶다면
다음과 같이 특정 비트의 값이 1인 수를 OR(|) 연산
lang2 = lang2 | 0x80; // c = true
00000000 00000000 00000000 00000000 00000000
00000000 00000000 00000000 00000000 10000000
--------------------------------------------------
00000000 00000000 00000000 00000000 10000000

lang2 |= 0x00; // c++ = false

lang2 |= 0x20; // java = true
00000000 00000000 00000000 00000000 10000000
00000000 00000000 00000000 00000000 00100000
------------------------------------------------------
00000000 00000000 00000000 00000000 10100000

lang2 |= 0x00; // js = false

lang2 |= 0x08; // python = true
00000000 00000000 00000000 00000000 10100000
00000000 00000000 00000000 00000000 00001000
-------------------------------------------------------
00000000 00000000 00000000 00000000 10101000

lang2 |= 0x00; // php = false

lang2 |= 0x02; // html = true
00000000 00000000 00000000 00000000 10101000
00000000 00000000 00000000 00000000 00000010
------------------------------------------------------
00000000 00000000 00000000 00000000 10101010

System.out.println(Integer.toBinaryString(lang2));
=> 10101010
```

- 데이터 꺼내서 활용(&)
```
언어 변수 정의

final int CSS           = 0x01; // 0000 0001
final int HTML          = 0x02; // 0000 0010
final int PHP           = 0x04; // 0000 0100
final int PYTHON        = 0x08; // 0000 1000
final int JAVASCRIPT    = 0x10; // 0001 0000
final int JAVA          = 0x20; // 0010 0000
final int CPP           = 0x40; // 0100 0000
final int C             = 0x80; // 1000 0000

int lang = C | JAVA | PYTHON | HTML; // 10101010

&연산자를 통해 필요 비트만 거른 후 비교연산자를 통해 true/false여부 출력

System.out.printf("CSS        : %b\n", (lang & CSS) == CSS);
System.out.printf("HTML       : %b\n", (lang & HTML) == HTML);
System.out.printf("PHP        : %b\n", (lang & PHP) == PHP);
System.out.printf("Python     : %b\n", (lang & PYTHON) == PYTHON);
System.out.printf("JavaScript : %b\n", (lang & JAVASCRIPT) == JAVASCRIPT);
System.out.printf("Java       : %b\n", (lang & JAVA) == JAVA);
System.out.printf("C++        : %b\n", (lang & CPP) == CPP);
System.out.printf("C          : %b\n", (lang & C) == C);

```
