package bitcamp.myapp;


public class App {
  
  
  public static void main(String[] args) {
    String RESET = "\033[0m";
    String RED_BOLD = "\033[1;31m";
    String RED_NORMAL = "\033[31m";
    
    String appTitle = "[과제 관리 시스템]";
    String menu1 = "1. 과제",
        menu2 = "2. 게시글",
        menu3 = "3. 도움말",
        menu4 = "4. 종료";
    
    System.out.println(RED_BOLD + appTitle + RESET);
    System.out.println("-------------------");
    System.out.println();
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(RED_NORMAL + menu4 + RESET);
    System.out.println("-------------------");
    
    int[] a = new int[3];
    System.out.println(a[0]);
  }
}
