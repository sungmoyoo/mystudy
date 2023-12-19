package algorithm.test.baekjoon.level02.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int hour = sc.nextInt();
    int min = sc.nextInt();
    int cookTime = sc.nextInt();
    
    int cookHour = cookTime / 60;
    int cookMin = cookTime % 60;
    
    hour += cookHour;
    min += cookMin;
    
    if (min > 59) {
      ++hour;
      min -= 60;
    }
    
    if (hour > 23) {
      hour -= 24;
    }
    System.out.printf("%d %d", hour, min);
  }
}