package com.eomcs.oop.ex02.step15;

// 데이터 타입 정의
// 0) 낱개 변수 사용
// 1) 성적 데이터를 저장할 메모리를 새로 정의:
// - '사용자 정의 데이터 타입(user-defined data type)'이라 부른다.
// - 여러개로 이루어진 한 묶음으로 다루면 관리하기가 쉽다.
// 2) 리팩토링: 메서드 추출(extract method)
// 3) 리팩토링: 메서드 추출(extract method) 한 개의 메서드는 한 개의 기능을 수행해야 한다.

public class App {
  public static void main(String[] args) {

    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    Score.compute(s1);

    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    Score.compute(s2);

    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    Score.compute(s3);

    printScore(s1);
    printScore(s2);
    printScore(s3);
  }

  // printScore() 출력 기능만 담당하도록 변경한다.
  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }


}

