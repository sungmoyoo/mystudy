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
      
      String input;

      while ((input = br.readLine()) != null && !input.isEmpty()){
        StringTokenizer st = new StringTokenizer(input);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        bw.write(A + B + "\n");
      }
      
      br.close();
      bw.flush();
      bw.close();
    }
}