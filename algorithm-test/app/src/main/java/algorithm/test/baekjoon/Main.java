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
    
    int[] arr = new int[9];
    
    for (int i = 0; i < 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    
    int index = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++){
      if (max < arr[i]) {
        max = arr[i];
        index = i+1;
      }
    }
    bw.write(max + "\n");
    bw.write(index + "\n");
    
    
    bw.close();
    br.close();
  }
}