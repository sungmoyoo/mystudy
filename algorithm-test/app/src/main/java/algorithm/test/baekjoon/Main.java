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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    int[] basket = new int[N]; 
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      basket[i] = i+1;
    }
    
    
    for (int n = 0; n < M; n++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      
      for (int a = i-1, b = j-1; a <= b ; a++, b--) {
        int temp = basket[a];
        basket[a] = basket[b];
        basket[b] = temp;
      }
    }
    for (int value : basket) {
      bw.write(value + " ");
    }
    
    bw.close();
    br.close();
  }
}