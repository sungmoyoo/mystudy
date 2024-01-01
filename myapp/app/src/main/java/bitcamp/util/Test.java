package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    Queue<String> s = new Queue<>();
    s.add("aaa");
    s.add("bbb");
    s.add("ccc");

    System.out.println(s.peek());
    while (s.peek() != null) {
      System.out.println(s.poll());
    }
  }
}
