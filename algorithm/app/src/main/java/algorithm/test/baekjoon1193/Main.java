package algorithm.test.baekjoon1193;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int sum = 0;
    int plus = 1;
    int count = 1;
    int n = sc.nextInt();
    int son;
    int mom;
    while (true) {
      if (sum+plus+1 > n) {
        break;
      }

      sum = sum + plus++;
      count++;

    }
    if (count % 2 == 0) {
      son = (n - sum);
      mom = count+1 - (n - sum);
    } else {
      son = count+1 - (n - sum);
      mom = (n - sum);
    }

    System.out.println(son + "/" + mom);

    sc.close();
  }
}
