package algorithm.test.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int R = Integer.parseInt(st.nextToken());
      String S = st.nextToken();
      
      for (int j = 0; j < R-1; j++) {
        S.concat(S);
      }
      char[] arr = S.toCharArray();
      Arrays.sort(arr);
      
      for (char value : arr) {
        bw.write(value);
      }
      
    }
    
    bw.close();
    br.close();
  }
}