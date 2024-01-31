package algorithm.test.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int count = 0;

    for (int n = 0; n < N; n++) {
      String word = br.readLine();
      boolean isGroup = true;

      // 맨끝 바로 전 인덱스까지만 이동하여 i+1 비교
      for (int i = 0; i < word.length() - 1; i++) {
        // 현재 문자와 다음 문자가 다르면, 현재 문자 이후에 다시 나타나는지 확인
        if (word.charAt(i) != word.charAt(i + 1)) {
          // i+1은 이미 위 조건식에서 다르니 i+2부터 비
          for (int j = i + 2; j < word.length(); j++) {
            // 같은 문자가 나오면 그룹단어가 아님을 표
            if (word.charAt(i) == word.charAt(j)) {
              isGroup = false;
              break;
            }
          }
        }

        // 그룹단어가 아니면 반복문을 종료하고 나간다.
        if (!isGroup) {
          break;
        }
      }

      // 반복문이 종료되도 그룹단어이면 count 증
      if (isGroup) {
        count++;
      }

      // n만큼 반복후 종료
    }

    bw.write(count + "\n");

    bw.close();
    br.close();
  }
}
