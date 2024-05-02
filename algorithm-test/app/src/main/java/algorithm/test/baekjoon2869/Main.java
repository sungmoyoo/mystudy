package algorithm.test.baekjoon2869;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int V = sc.nextInt();


    int C = (V-B)/(A-B);


    System.out.println(C);
  }
}
