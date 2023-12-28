package bitcamp.util;

import java.util.Arrays;

public class LinkedList<E> extends AbstractList<E> {

  private Node<E> first;
  private Node<E> last;

  public void add(E value) {
    Node<E> node = new Node<>();
    node.value = value;

    if (first == null) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }
    size++;

  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node<E> node = first;
    for (int i = 0; i < size; i++) {
      arr[i] = node.value;
      node = node.next;
    }
    return arr;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효하지 않은 인덱스입니다.");
    }
    int cursor = 0;
    Node<E> node = first;
    while (cursor++ < index) {
      node = node.next;
    }
    return node.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효하지 않은 인덱스입니다.");
    }
    int cursor = 0;
    Node<E> node = first;
    while (cursor++ < index) {
      node = node.next;
    }
    E old = node.value;
    node.value = value;

    return old;
  }

  public void add(int index, E value) {
    // first가 null일 때
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
      // index가 중간일 때(나머지)
      Node<E> currNode = first;
      int cursor = 0;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }
    size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효하지 않은 인덱스입니다.");
    }
    Node<E> deleted = null;

    // 값이 1개일 때
    if (size == 1) {
      deleted = first;
      first = last = null;

    } else if (index == 0) {
      deleted = first;
      first = first.next;

    } else {
      Node<E> currNode = first;
      int cursor = 0;
      while (++cursor < index) {
        currNode = currNode.next;
      }

      deleted = currNode.next;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode;
      }
    }
    size--;
    E old = deleted.value;
    deleted.value = null;
    deleted.next = null;
    return old;
  }


  public boolean remove(E value) {
    Node<E> Node = first;
    Node<E> prevNode = null;
    while (Node != null) {
      if (Node.value.equals(value)) {
        break;
      }
      prevNode = Node;
      Node = Node.next;
    }
    if (Node == null) {
      return false;
    }

    if (Node == first) {
      first = first.next;
      if (first == null) {
        last = null;
      }

    } else {
      prevNode.next = Node.next;
    }

    size--;
    return true;
  }

  private static class Node<T> {

    T value;
    Node<T> next;
  }

  public E[] toArray(final E[] arr) {
    E[] values = arr;
    if (values.length < size) {
      values = Arrays.copyOf(arr, size);
    }

    int i = 0;
    Node<E> node = first;
    while (node != null) {
      values[i++] = node.value;
      node = node.next;
    }

    return values;
  }
}




