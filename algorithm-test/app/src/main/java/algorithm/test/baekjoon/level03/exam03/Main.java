package algorithm.test.baekjoon.level03.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt(); 

    System.out.println((n * (n + 1)) / 2);
 } 
}
//    int result = 0;
//    for (int i = 0; i < n+1; i++) {
//      result += i;
//    }
//    System.out.print(result);
//    
//    sc.close();
