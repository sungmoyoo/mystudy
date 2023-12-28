package bitcamp.util;

import java.util.EmptyStackException;

public class Stack<E> extends LinkedList<E> {

  public E push(E item) {
    this.add(item);
    return item;
  }

  public E pop() throws EmptyStackException {
    return this.remove(size() - 1);
  }

  public E peek() throws EmptyStackException {
    return this.get(size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }
}
