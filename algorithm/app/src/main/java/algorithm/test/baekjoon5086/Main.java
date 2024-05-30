package algorithm.test.baekjoon5086;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<String> resultList = new ArrayList<>();

    while (true) {

      int first = sc.nextInt();
      int second = sc.nextInt();

      if (first == 0 || second == 0) {
        break;
      }

      if (first % second == 0) {
        resultList.add("multiple");

      } else if (second % first == 0) {
        resultList.add("factor");

      } else {
        resultList.add("neither");
      }
    }

    for (String result : resultList) {
      System.out.println(result);
    }

    sc.close();
  }
}
