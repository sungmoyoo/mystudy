package algorithm.test.baekjoon2745;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String N = sc.next();
    int B = sc.nextInt();

    char[] arr = N.toCharArray();

    int result = 0;

    for (int i = 0; i < arr.length; i++) {
      char n = arr[i];
      if (n >= 'A' && n <= 'Z') {
        result += (n - 'A' + 10) * Math.pow(B, arr.length - i - 1);
      } else {
        result += (n - '0') * Math.pow(B, arr.length - i - 1);;
      }
    }
    System.out.println(result);

    sc.close();
  }
}