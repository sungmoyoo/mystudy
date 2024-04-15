package algorithm.test.baekjoon2566;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] arr = new int[9][9];

    int maxValue = Integer.MIN_VALUE;
    int row = -1;
    int column = -1;

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = sc.nextInt();
        if (arr[i][j] > maxValue) {
          row = i+1;
          column = j+1;
          maxValue = arr[i][j];
        }
      }
    }
    System.out.println(maxValue);
    System.out.printf("%d %d", row, column);
  }
}