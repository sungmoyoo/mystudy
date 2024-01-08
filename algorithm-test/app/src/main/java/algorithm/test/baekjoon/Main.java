package algorithm.test.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// ArrayList contains을 활용한 방식
//    int[] arr = new int[10];
//    ArrayList<Integer> list = new ArrayList<>();
//    for (int i = 0; i < 10; i++) {
//      int n = Integer.parseInt(br.readLine());
//      if (!list.contains(n % 42)) {
//        list.add(n % 42);
//      }
//    }
//    bw.write(list.size() + "\n");
    
    
// HashSet을 활용한 방식
    Set<Integer> set = new HashSet<>();
    
    for (int i = 0; i < 10; i++) {
      int n = Integer.parseInt(br.readLine());
      set.add(n % 42);
    }
    
    bw.write(set.size() + "\n");
    
    bw.close();
    br.close();
  }
}