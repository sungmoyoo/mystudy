package algorithm.test.baekjoon.level03.exam07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(bf.readLine());
    
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      
      bw.write("Case #" + (i+1) + ": " + (A+B) + "\n");
    }
    
    bf.close();
    bw.flush();
    bw.close();
  }
}