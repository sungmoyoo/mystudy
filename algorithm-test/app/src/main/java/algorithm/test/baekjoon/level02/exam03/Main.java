package algorithm.test.baekjoon.level02.exam03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    int inputYear = keyScan.nextInt();

//    if (inputYear % 4 == 0) {
//      if (inputYear % 100 != 0 || inputYear % 400 == 0) {
//        System.out.println(1);
//        }
//      else {
//        System.out.println(0);
//      }
//    }
//    else {
//      System.out.println(0);
//    }
    System.out.println(inputYear % 4 == 0 && inputYear % 100 != 0 || inputYear % 400 == 0 ? 1 : 0);
    
    keyScan.close();
  }
}