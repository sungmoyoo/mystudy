package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {
  
  Scanner keyIn;
  
  public Prompt(InputStream in) {
    
    keyIn = new Scanner(in);
  }
  
  public String input(String title, Object... args) {
    System.out.print(String.format(title, args));
    return this.keyIn.nextLine();
  }
  
  public int inputInt(String title, Object... args) {
    String str = this.input(title, args);
    int result = 0;
    try {
      result = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      System.out.printf("%s은 정수로 변환할 수 없는 문자입니다.", str);
    }
    return result;
  }
  
  public float inputFloat(String title, Object... args) {
    String str = this.input(title, args);
    return Float.parseFloat(str);
  }
  
  public boolean inputBoolean(String title, Object... args) {
    String str = this.input(title, args);
    return Boolean.parseBoolean(str);
  }
  
  public void close() {
    this.keyIn.close();
  }
}
