package algorithm.test.baekjoon.level03.exam10;

//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
  public static void main(String[] args) throws IOException{
//    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    
//    int N = sc.nextInt();
    StringBuffer s = new StringBuffer("");
    
    for (int i = 0; i < N; i++) {
      if (i > 0) {
        bw.write("\n");
//        s.append("\n");
      }
      for (int j = 0; j < N; j++) {
        if (i+j > N-2) {
          bw.write("*");
//          s.append("*");
        } else {
          bw.write(" ");
//          s.append(" ");
        }
      }
    }
    bw.flush();
    bw.close();
    br.close();
//    System.out.println(s);
  }
}