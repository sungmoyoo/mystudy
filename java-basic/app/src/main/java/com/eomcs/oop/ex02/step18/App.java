package com.eomcs.oop.ex02.step18;

import com.eomcs.oop.ex02.step18.vo.Score;

public class App {
  public static void main(String[] args) {

    Score s1 = new Score("홍길동", 100, 90, 85);
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80, 70, 65);

    // 일반적인 초기화 메서드
    // s1.init("홍길동", 100, 90, 85);
    // s2.init("임꺽정", 90, 80, 75);
    // s3.init("유관순", 80, 70, 65);

    // s3.compute();
    // s1.compute();
    // s2.compute();
    s2.kor = 100;
    s2.compute();

    printScore(s1);
    printScore(s2);
    printScore(s3);
  }


  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }


}

