package bitcamp.util;

import java.util.Arrays;

public class LinkedList<E> extends AbstractList<E> {

  Node<E> first;
  Node<E> last;

  public void add(E value) {
    Node<E> node = new Node<>();
    node.value = value;

    if (last == null) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }
    size++;
  }

  public Object[] toArray() {
    Node<E> node = first;
    int index = 0;

    Object[] arr = new Object[size];

    while (node != null) {
      arr[index] = node.value;
      node = node.next;
    }
    return arr;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node<E> node = first;
    int cursor = 0;

    while (cursor++ < index) {
      node = node.next;
    }

    return node.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node<E> node = first;
    int cursor = 0;

    while (cursor++ < index) {
      node = node.next;
    }

    E old = node.value;
    node.value = value;

    return old;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }
    Node<E> node = new Node<>();
    node.value = value;

    if (first == null) {
      first = last = node;
    } else if (index == 0) {
      node.next = first;
      first = node;
    } else if (index == (size - 1)) {
      last.next = node;
      last = node;
    } else {
      int cursor = 0;
      Node<E> currNode = first;
      while (cursor++ < index) {
        currNode = currNode.next;
      }
      currNode.next = node;
      node.next = currNode.next.next;
    }
    size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }
    E deleted = null;

    if (size == 1) {
      deleted = first.value;
      first = last = null;

    } else if (index == 0) {
      deleted = first.value;
      first = first.next;

    } else {
      int cursor = 0;
      Node<E> currNode = first;
      while (cursor++ < (index - 1)) {
        currNode = currNode.next;
      }
      deleted = currNode.next.value;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode;
      }
    }

    size--;
    return deleted;
  }

  public boolean remove(E value) {
    Node<E> node = first;
    Node<E> prevNode = null;
    while (node != null) {
      if (node.value.equals(value)) {
        break;
      }
      prevNode = node;
      node = node.next;
    }
    if (node == null) {
      return false;
    }
    if (node == first) {
      first = first.next;
      if (first == null) {
        last = null;
      }
    } else {
      prevNode.next = node.next;
    }
    size--;
    return true;
  }

  public E[] toArray(final E[] arr) {
    E[] values = arr;
    if (values.length < size) {
      values = Arrays.copyOf(arr, size);
    }

    int index = 0;
    Node<E> node = first;
    while (node != null) {
      values[index++] = node.value;
      node = node.next;
    }

    return values;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<>() {

      Node<E> cursor = (Node<E>) LinkedList.this.first;

      @Override
      public boolean hasNext() {
        return cursor != null;
      }

      @Override
      public E next() {
        E value = cursor.value;
        cursor = cursor.next;
        return value;
      }
    };
  }


  private static class Node<E> {

    E value;
    Node<E> next;
  }

}
