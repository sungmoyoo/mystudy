package algorithm.test.baekjoon.level03.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    StringBuffer star = new StringBuffer("");
    for (int i = 0; i < N; i++) {
      star.append("*");
      System.out.println(star);
    }
    
    sc.close();
  }
}