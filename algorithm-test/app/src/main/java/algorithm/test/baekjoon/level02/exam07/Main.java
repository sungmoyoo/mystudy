package algorithm.test.baekjoon.level02.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int dice1 = sc.nextInt();
    int dice2 = sc.nextInt();
    int dice3 = sc.nextInt();
    int maxNumber;
   
    if (dice1 == dice2 && dice2 == dice3) {
      System.out.println(10000 + dice1 * 1000);
    } else if(dice1 == dice2 || dice2 == dice3) {
      System.out.println(1000 + dice2 * 100);
    } else if(dice1 == dice3) {
      System.out.println(1000 + dice1 * 100);
    } else {
      maxNumber = Math.max(dice1, dice2);
      maxNumber = Math.max(dice3, maxNumber);
      System.out.println(100 * maxNumber);
    }
  }
}