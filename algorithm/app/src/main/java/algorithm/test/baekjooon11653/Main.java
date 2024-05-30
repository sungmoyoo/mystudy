package algorithm.test.baekjooon11653;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    List<Integer> list = new ArrayList<>();

    int i = 2;

    while (N != 1) {
      if (N % i != 0) {
        i++;
      } else {
        N /= i;
        list.add(i);
      }
    }
    for (int n : list) {
      System.out.println(n);
    }

    sc.close();
  }
}
