package algorithm.test.baekjoon9506;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int n = sc.nextInt();

      if (n == -1) {
        break;
      }

      int sum = 0;
      List<Integer> list = new ArrayList<>();

      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          sum += i;
          list.add(i);
        }
      }

      if (n == sum) {
        StringBuilder result = new StringBuilder(n + " = 1");
        for (int i = 1; i <= list.size()-1; i++) {
          result.append(" + ");
          result.append(list.get(i));
        }
        System.out.println(result);

      } else {
        System.out.printf("%d is NOT perfect.\n", n);
      }
    }
    sc.close();
  }
}
