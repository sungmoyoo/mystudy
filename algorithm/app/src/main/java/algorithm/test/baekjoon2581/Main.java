package algorithm.test.baekjoon2581;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();
    int N = sc.nextInt();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    // 에라토스테네스의 체
    // 소수는 1과 자기 자신 이외에는 다른 약수를 가지지 않는 숫자이므로, 
    // 소수의 배수를 제거하면 소수만 남는다.

    // 0부터 N을 index로 가지는 boolean 배열을 만든다. true일 경우 소수임을 판별하는 역
    boolean[] isPrime = new boolean[N+1];

    // 소수 구분 없이 모두 true로 설정. 이후에 소수의 배수를 차례로 제거하기 위함
    Arrays.fill(isPrime, true);

    // 0과 1은 소수가 아니므로 제외
    isPrime[0] = isPrime[1] = false;

    // 2부터 시작하여 자신의 배수가 되는 수를 지워나가면 된다. 
    for (int i = 2; i <= N; i++) {

      // 기존에 false로 지워진 수는 제외
      if (isPrime[i]) {

        // i*i보다 작은 배수는 이미 지워진 상태이다.
        for (int j = i*i; j<=N; j += i) {
          isPrime[j] = false;
        }
      }
    }

    for (int i = M; i <= N; i++) {
      if (isPrime[i]) {
        list.add(i);
        sum += i;
      }
    }
    if (list.size() == 0) {
      System.out.println(-1);
    } else {
      System.out.println(sum);
      System.out.println(list.get(0));
    }    
    sc.close();
  }
}
