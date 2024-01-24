package algorithm.test.baekjoon;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = (sc.nextInt()) * 2 - 1;

    // 위의 정삼각형 n줄까지 
    for (int i = 1; i <= n; i+=2) {
      for (int j = 0; j < (n - i) / 2; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < i ; k++) {
        System.out.print("*");
      }
      System.out.println();
    } 


    // 아래 정삼각형 n+1줄 부터, 
    for (int i = n-2; i >= 1; i-=2) {
      for (int j = 0; j < (n-i)/2; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < i; k++) {
        System.out.print("*");
      }
      System.out.println();
    }

    sc.close();
  }
}