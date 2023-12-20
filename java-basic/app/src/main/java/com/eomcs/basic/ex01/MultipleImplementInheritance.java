package com.eomcs.basic.ex01;
// 다중상속과 다중 구현은 동시에 할 순 없다.
// 다만 구현 -> 상속, 상속 -> 구현은 가능하다.
//인터페이스 A
interface A {
 void methodA();
}

//인터페이스 B
interface B {
 void methodB();
}

//인터페이스 C는 A와 B를 구현
interface C extends A, B {
 void methodC();
}

//인터페이스 D는 A와 B를 구현
interface D extends A, B {
 void methodD();
}

//구현 예시
class Example implements C, D {
 @Override
 public void methodA() {
     System.out.println("Method A");
 }

 @Override
 public void methodB() {
     System.out.println("Method B");
 }

 @Override
 public void methodC() {
     System.out.println("Method C");
 }

 @Override
 public void methodD() {
     System.out.println("Method D");
 }

 public void methodE() {
     System.out.println("Method E");
 }
}

public class MultipleImplementInheritance {
 public static void main(String[] args) {
     Example example = new Example();
     example.methodA(); // 출력: Method A
     example.methodB(); // 출력: Method B
     example.methodC(); // 출력: Method C
     example.methodD(); // 출력: Method D
     example.methodE(); // 출력: Method E
 }
}


