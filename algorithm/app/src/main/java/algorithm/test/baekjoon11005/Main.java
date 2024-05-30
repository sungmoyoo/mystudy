package algorithm.test.baekjoon11005;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int B = sc.nextInt();

    StringBuilder result = new StringBuilder();

    while (N > 0) {
      char digit;
      if (N % B  >= 10 && N % B <= B) {
        digit = (char) (N % B + 'A' - 10);
      } else {
        digit = (char) (N % B + '0');
      }
      result.append(digit); 
      N /= B;
    }
    System.out.println(result.reverse());

    sc.close();
  }
}
