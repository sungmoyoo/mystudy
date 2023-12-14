// Singleton 패턴
// => 객체를 한 개만 생성할 수 있게 만드는 설계 기법
package com.eomcs.oop.ex04.singleton;

public class Test1 {

  public static void main(String[] args) {
    // Singleton을 적용하지 않은 클래스의 인스턴스 만들기
    Car c1 = new Car();
    Car c2 = new Car();
    Car c3 = new Car();
    // 이렇게 인스턴스 생성에 제한이 없다.
    System.out.println(c1 == c2);
    System.out.println(c1 == c3);
    System.out.println(c2 == c3);

  }
}