package algorithm.test.baekjoon2869;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int V = sc.nextInt();
    int C;

    // 달팽이가 낮에 올라가고 밤에 미끄러지지만 
    // 정상에 도착한 마지막 날 밤에는 미끄러지지 않는다는 조건을 고려해야함.

    // (V-A) 마지막 날, 정상에 도달하기 위해 남은 높이 (낮에 먼저 정상에 오르면 밤에 미끄러지지 않기 때문에 -A해준 것) 
    // (A-B) 하루에 올라갈 수 있는 높이와 미끄러지는 높이, 즉 하루에 올라갈 수 있는 높이

    // 만약 남은 높이(V-A)가 하루에 올라갈 수 있는 높이(A-B)로 나누어 떨어진다면
    // 그 값 자체가 도착에 걸리는 일수(결과)이다. 
    // 단 도착하는 마지막 날도 결과에 포함하기 때문에 기본적으로 +1을 해주어야 함.
    // 나누어 떨어지지 않으면 하루를 더 가야하기 때문에 또 +1하여 +2가 됨.

    if ((V-A) % (A-B) == 0) {
      C = (V-A)/(A-B)+1;
    } else {
      C = (V-A)/(A-B)+2;
    }

    System.out.println(C);
  }
}
