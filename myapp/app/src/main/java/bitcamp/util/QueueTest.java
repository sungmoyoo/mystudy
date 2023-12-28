package bitcamp.util;

public class QueueTest {

  public static void main(String[] args) {
    Queue<String> q = new Queue<>();
    q.offer("aaa");
    q.offer("bbb");
    q.offer("ccc");

    while (q.peek() != null) {
      System.out.println(q.poll());
    }
  }
}
