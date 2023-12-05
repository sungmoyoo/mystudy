package com.eomcs.oop.ex02.step18.vo;

// ## 사용자 정의 데이터 타입 만들기
// - 특정 유형의 데이터를 담을 전용 메모리(변수)를 설계한다.
// - 학생 데이터를 묶음으로 다룰 수 있도록 변수 그룹을 정의한다.
public class Score {
  // 인스턴스 변수(instance variable; instance field)
  // - new 명령으로 생성되는 변수이다.
  // - 데이터를 개별적으로 다루고 싶을 때 인스턴스 변수로 선언한다.
  //
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;

  }
}
