package algorithm.test.baekjoon1193;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int sum = 0;
    int count = 0;

    int X = sc.nextInt();

    while (true) {
      if (X < sum) {
        break;
      }
      sum += count++; 

    }
    System.out.printf("%d/%d",);
  }
}
