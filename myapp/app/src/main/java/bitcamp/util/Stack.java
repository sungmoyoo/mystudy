package bitcamp.util;

public class Stack<E> extends LinkedList<E> {

  public E push(E item) {
    this.add(item);
    return item;
  }

  public E pop() {
    return this.remove(this.size() - 1);
  }

  public E peek() {
    return this.get(this.size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }
}
