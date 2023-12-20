package com.eomcs.basic.ex01;

interface A1 {
    void methodA();
}

// 인터페이스 B
interface B1 {
    void methodB();
}

// 인터페이스 C는 A와 B를 구현
class C1 implements A1, B1 {
    @Override
    public void methodA() {
        System.out.println("Method A in C");
    }

    @Override
    public void methodB() {
        System.out.println("Method B in C");
    }

    // C 클래스에서 추가적으로 정의한 메서드
    public void methodC() {
        System.out.println("Method C in C");
    }
}

// Example 클래스는 C 클래스를 상속
class Example1 extends C1 {
    // C 클래스에서 상속받은 methodA와 methodB를 구현하지 않아도 됨

    // C 클래스에서 상속받은 methodC를 구현하지 않아도 됨

    // Example 클래스에서 추가적으로 정의한 메서드
    public void methodD() {
        System.out.println("Method D in Example");
    }

    public void methodE() {
        System.out.println("Method E in Example");
    }
}

public class MultipleImplementInheritance2 {
    public static void main(String[] args) {
        Example1 example = new Example1();
        example.methodA(); // 출력: Method A in C
        example.methodB(); // 출력: Method B in C
        example.methodC(); // 출력: Method C in C
        example.methodD(); // 출력: Method D in Example
        example.methodE(); // 출력: Method E in Example
    }
}