package algorithm.test.baekjoon.level03.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String plusLong = "";
    
    for (int i = 0; i < N; i += 4) {
      plusLong = plusLong + "long ";
    }
    System.out.printf("%sint", plusLong);
  }
}