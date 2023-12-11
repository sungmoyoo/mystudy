package algorithm.test.baekjoon.level01.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    int A, B, C;
    A = keyIn.nextInt();
    B = keyIn.nextInt();
    C = keyIn.nextInt();

    System.out.println((A + B) % C);
    System.out.println(((A % C) + (B % C)) % C);
    System.out.println((A * B) % C);
    System.out.println(((A % C) * (B % C)) % C);

    keyIn.close();
  }
}
