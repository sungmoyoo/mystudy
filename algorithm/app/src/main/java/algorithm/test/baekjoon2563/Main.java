package algorithm.test.baekjoon2563;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] area = new int[100][100];

    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      int row = sc.nextInt();
      int col = sc.nextInt();

      for (int w = col; w < col+10; w++) {
        for (int l = row; l < row+10; l++) {
          area[w][l] = 1;
        }
      }
    }
    int countArea = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (area[i][j] == 1) {
          countArea++;
        }
      }
    }
    System.out.println(countArea);

    sc.close();
  }
}