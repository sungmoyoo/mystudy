package algorithm.test.baekjoon2292;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int n = 0;
    int sum = 1;

    while (true) {
      sum += (6*n);
      n++;
      if (N <= sum) {
        break;
      }
    }

    System.out.println(n);
  }
}
