package bitcamp.util;

public class Test {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add(0, "x"); //x a b c
    list.add(1, "y"); //x y a b c
    list.add(3, "z"); //x y a z b c

    list.remove(0);

    Object[] s = list.toArray();
    for (Object o : s) {
      System.out.println(o);
    }
  }
}
