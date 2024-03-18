package algorithm.test.baekjoon;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 직사각형의 크기 입력
    int n = sc.nextInt();
    int m = sc.nextInt();

    // 직사각형 배열 생성
    int[][] arr = new int[n][m];

    // 숫자 초기값
    int num = 1;

    // 행 우선 순회
    for (int i = 0; i < n; i++) {
      // 홀수 행: 왼쪽에서 오른쪽으로
      if (i % 2 == 0) {
        for (int j = 0; j < m; j++) {
          arr[i][j] = num++;
        }
      }
      // 짝수 행: 오른쪽에서 왼쪽으로
      else {
        for (int j = m - 1; j >= 0; j--) {
          arr[i][j] = num++;
        }
      }
    }

    // 배열 출력
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}