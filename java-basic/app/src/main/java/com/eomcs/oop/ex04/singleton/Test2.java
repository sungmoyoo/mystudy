// Singleton 패턴
// => 객체를 한 개만 생성할 수 있게 만드는 설계 기법
package com.eomcs.oop.ex04.singleton;

public class Test2 {

  public static void main(String[] args) {
    // Car2 클래스의 생성자를 접근할 수 없기 때문에 호출할 수 없다.
    //Car2 x = new Car2(); // 컴파일 오류!

    Car1 x1 = Car1.getInstance();
    Car1 x2 = Car1.getInstance();
    Car1 x3 = Car1.getInstance();
    
    System.out.println(x1 == x2);
    System.out.println(x1 == x3);
    System.out.println(x2 == x3);
  }

}





