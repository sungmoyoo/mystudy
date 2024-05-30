package algorithm.test.baekjoon2903;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int totalPoint = 4;
    int line = 3;
    int addPoint = 1;

    for (int i = 0; i < n; i++) {
      totalPoint = line*line;
      addPoint *= 2;
      line = line + (addPoint);
    }

    System.out.println(totalPoint);

    sc.close();
  }
}



