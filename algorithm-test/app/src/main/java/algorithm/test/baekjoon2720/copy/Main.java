package algorithm.test.baekjoon2720.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] coins = {25, 10 ,5, 1};
    List<Integer> result = new ArrayList<>();

    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int C = sc.nextInt();

      for (int coin : coins) {
        result.add(C / coin);
        C = C % coin;
      }
    }

    for (int i = 0; i < result.size(); i++) {
      if (i % 4 == 0 && i != 0) {
        System.out.println();
      }
      System.out.print(result.get(i) + " ");
    }
    sc.close();
  }
}