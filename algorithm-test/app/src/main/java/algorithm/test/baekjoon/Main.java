package algorithm.test.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(br.readLine());
      
      int cnt = 0;
      while(st.hasMoreTokens()) {
        if(Integer.parseInt(st.nextToken()) == v) {
          cnt++;
        }
      }
      System.out.println(cnt);
      
      
      
//      Scanner sc = new Scanner(System.in);
//      
//      int N = sc.nextInt();
//      
//      int[] arr = new int[N];
//      
//      for (int i = 0; i < N; i++) {
//        arr[i] = sc.nextInt();
//      }
//      
//      int v = sc.nextInt();
//      
//      int cnt = 0;
//      for (int value : arr) {
//        if(value == v) {
//          cnt++;
//        }
//      }
//      System.out.println(cnt);
//      sc.close();
    }
}