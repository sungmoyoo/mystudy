package algorithm.test.baekjoon.level01.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    int a = keyScan.nextInt();
    int b = keyScan.nextInt();

    System.out.println(a * (b % 10));
    System.out.println(a * ((b % 100) / 10));
    System.out.println(a * (b / 100));
    System.out.println(a * b);

    keyScan.close();
  }
}
