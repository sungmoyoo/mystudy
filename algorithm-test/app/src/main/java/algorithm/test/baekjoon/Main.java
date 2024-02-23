import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    LinkedList<Integer> list = new LinkedList<>();
    int sum = 0;
    double avg = 0;


    for (int i = 0; i < 10; i++) {
      int input = Integer.parseInt(st.nextToken());
      if (input >= 250) {

        list.removeLast();
        break;
      } 
      list.add(input);
    }

    for (int value : list) {
      sum += value;    
    }
    avg = sum / list.size();

    System.out.printf("%d %.1f", sum, avg);

  }   
}