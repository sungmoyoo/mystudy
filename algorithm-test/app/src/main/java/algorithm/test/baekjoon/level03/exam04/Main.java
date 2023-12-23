package algorithm.test.baekjoon.level03.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int X = sc.nextInt();
    int N = sc.nextInt();
    int result = 0;
    
    for (int i = 0; i < N; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      result += (a*b);
    }
    System.out.println(result == X ? "Yes" : "No" );
    sc.close();
  }
}
