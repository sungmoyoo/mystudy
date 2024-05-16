package algorithm.test.baekjoon1978;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = 0;

    // 소수 판별법
    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      int n = sc.nextInt();

      boolean t = true;

      for (int j = 2; j < (int) Math.sqrt(n)+1; j++) {
        if (n % j == 0) {
          t = false;
        }
      }

      if (t && n != 1) {
        count++;
      }
    }

    System.out.println(count);
    sc.close();
  }
}
