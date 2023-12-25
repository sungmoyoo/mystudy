package algorithm.test.baekjoon.level03.exam06;

// 필요한 클래스 import
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// import java.io.*;
// import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    // 입출력을 위한 객체 생성
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(br.readLine());
    
    for (long i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine()); // StringTokenizer의 nextToken을 사용하여 token 단위로 문자열 인식  
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      bw.write(A+B + "\n"); // println처럼 줄바꿈하지 않는다.
    }
    
   
    br.close();
    
    bw.flush(); // 버퍼가 다 차지 않았더라도 파일을 작성하고 버퍼를 비운다.
    bw.close(); // 스트림을 닫는다. 버퍼에 남은 데이터를 flush한 다음 스트림을 닫는다.
  }
}