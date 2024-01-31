package algorithm.test.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 전공평점 = (학점*과목평점)의 합 / 학점 총합
    double total = 0; // 학점*과목평점 합
    double gradeTotal = 0; // 학점 총합
    double average = 0; // 전공평점, 추후에 NaN 값 처리를 위해 미리 변수 선언


    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      // 과목은 연산에 필요없으니 호출하여 버린다.
      st.nextToken();

      // 학점을 부동소수점으로 저장
      double grade = Double.parseDouble(st.nextToken());

      // 문자열로 이루어진 과목평점을 그대로 조건문에 사용하기 위해 switch~case 사용
      // 각 과목평점에 따라 학점*과목평점 합을 계산해 total 값에 더한다. + 학점 총합도 계산
      switch (st.nextToken()) {
        case "A+" :
          total += grade * 4.5;
          gradeTotal += grade;
          break;
        case "A0" :
          total += grade * 4.0;
          gradeTotal += grade;
          break;
        case "B+" :
          total += grade * 3.5;
          gradeTotal += grade;
          break;
        case "B0" :
          total += grade * 3.0;
          gradeTotal += grade;
          break;
        case "C+" :
          total += grade * 2.5;
          gradeTotal += grade;
          break;
        case "C0" :
          total += grade * 2.0;
          gradeTotal += grade;
          break;
        case "D+" :
          total += grade * 1.5;
          gradeTotal += grade;
          break;
        case "D0" :
          total += grade * 1.0;
          gradeTotal += grade;
          break;
        case "P" :
          break;
        case "F" :
          gradeTotal += grade;
          break;
      }
    }

    // 모든 과목이 P 또는 F인 경우 average 값은 그대로 0 유지
    if (total != 0) {
      average = total/gradeTotal;
    } 

    bw.write(String.format("%.6f", average) + "\n");

    bw.close();
    br.close();
  }
}
