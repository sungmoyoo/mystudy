package algorithm.test.baekjoon.level02.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int hour = sc.nextInt();
    int min =  sc.nextInt();
    
    if (min - 45 < 0 && hour - 1 >= 0) {
      --hour;
      min = 60 + (min - 45);
      System.out.printf("%d %d", hour, min);
    } else if (min - 45 < 0 && hour - 1 < 0) {
      hour = 23;
      min = 60 + (min - 45);
      System.out.printf("%d %d", hour, min);
    } else {
      min = min - 45;
      System.out.printf("%d %d", hour, min);
    }
  }
}