package algorithm.test.baekjoon1085;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();
    int w = sc.nextInt();
    int h = sc.nextInt();

    if (w-x > h-y) {
      if (h-y < y && h-y < x) {
        System.out.println(h-y);
      } else {
        if (x > y) {
          System.out.println(y);
        } else {
          System.out.println(x);
        }
      }
    } else if (w-x < h-y) {
      if (w-x < x && w-x < y) {
        System.out.println(w-x);
      } else {
        if (x > y) {
          System.out.println(y);
        } else {
          System.out.println(x);
        }
      }
    } else if (w-x == h-y) {
      if (x > y) {
        System.out.println(y);
      } else {
        System.out.println(x);
      }
    }
  }
}