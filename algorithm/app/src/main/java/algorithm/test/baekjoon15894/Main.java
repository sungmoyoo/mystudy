package algorithm.test.baekjoon15894;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextInt();

    // top = n;
    // side = n*2;
    // bottom = n;
    long result = n*4;
    System.out.println(result);

    sc.close();
  }
}
