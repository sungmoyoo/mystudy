package bitcamp.util;

public class Queue<E> extends LinkedList<E> {

  public boolean offer(E item) {
    this.add(item);
    return true;
  }

  public E poll() {
    if (size() == 0) {
      return null;
    } else {
      return this.remove(0);
    }
  }

  public E peek() {
    if (size() == 0) {
      return null;
    } else {
      return this.get(0);
    }
  }
}
