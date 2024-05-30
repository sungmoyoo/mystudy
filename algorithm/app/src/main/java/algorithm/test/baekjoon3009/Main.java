package algorithm.test.baekjoon3009;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Integer> xCount = new HashMap<>();
    Map<Integer, Integer> yCount = new HashMap<>();

    for (int i = 0; i < 3; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      // 좌표축에 평행하는 직사각형을 만들기 위해서는
      // 입력받은 xy 각각 두개의 값 중 중복되지 않은 입력값이 마지막 점이 되야 한다.
      // HashMap을 사용해 key에 따라 개수를 세고 그 값이 2가 아닌 경우 출력하도록 함.
      xCount.put(x, xCount.getOrDefault(x, 0)+1);
      yCount.put(y, yCount.getOrDefault(y, 0)+1);
    }

    for (Entry<Integer, Integer> entrySet : xCount.entrySet()) {
      if (entrySet.getValue() != 2) {
        System.out.print(entrySet.getKey() + " ");
      }
    }
    for (Entry<Integer, Integer> entrySet : yCount.entrySet()) {
      if (entrySet.getValue() != 2) {
        System.out.print(entrySet.getKey());
      }
    }

    sc.close();
  }
}
