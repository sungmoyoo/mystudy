package com.eomcs.lang.ex07;
//# JVM 스택과 메서드 호출
//# 메서드 : 스택 메모리 응용 I
//
public class Exam0440 {

  static int m1(int value) {
    int r1 = m2(value);
    int r2 = m3(value);
    return r1 + r2;
  }

  static int m2(int value) {
    return value + 100;
  }

  static int m3(int value) {
    return value + 200;
  }

  public static void main(String[] args) {
    System.out.println("로컬변수 생성 이후에 실행됨");
    System.out.println("로컬변수 생성 이후에 실행됨");
    System.out.println("로컬변수 생성 이후에 실행됨");
    System.out.println("로컬변수 생성 이후에 실행됨");
    System.out.println("로컬변수 생성 이후에 실행됨");
    //소스코드에 변수의 위치와 상관없이 메서드를 호출하는 시점에 로컬변수 메모리 모두 생성됨
    int r = m1(5);
    System.out.println(r);
  }
}
// JVM Stack 메모리의 사용
// 0) 시작
// 1) main()
// 2) main() => m1()
// 3) main() => m1() => m2()
// 4) main() => m1()
// 5) main() => m1() => m3()
// 6) main() => m1()
// 7) main()
// 8) 종료!