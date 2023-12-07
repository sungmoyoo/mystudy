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
    return keyIn.nextLine();
  }
  
  public int inputInt(String title, Object... args) {
    return Integer.parseInt(input(title, args));
  }
  
  public float inputFloat(String title, Object... args) {
    return Float.parseFloat(input(title, args));
  }
  
  public boolean inputBoolean(String title, Object... args) {
    return Boolean.parseBoolean(input(title, args));
  }
  
  public void close() {
    keyIn.close();
  }
}
