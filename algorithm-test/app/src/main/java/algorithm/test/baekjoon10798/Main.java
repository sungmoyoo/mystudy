package algorithm.test.baekjoon10798;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[][] arr = new String[5][15];

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 5; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < line.length(); j++) {
        arr[i][j] = String.valueOf(line.charAt(j));
      }
    }

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 5; j++) {
        if (arr[j][i] == null) {
          continue;
        }
        sb.append(arr[j][i]);
      }
    }
    System.out.println(sb);
    sc.close();
  }
}
