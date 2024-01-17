package algorithm.test.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    
      char[] arr = S.toCharArray();
      
      StringBuilder strBuilder = new StringBuilder();
      
      for (char value : arr) {
        for (int j = 0; j < R; j++) {
          strBuilder.append(value);
        }
      }
      
      bw.write(strBuilder.toString());
      bw.write("\n");
    }
    
    bw.close();
    br.close();
  }
}