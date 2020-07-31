package my;

import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;

  private class Node<T> {

    T data;

    Node<T> next;

    Node<T> prev;

    public Node(T data, Node<T> next, Node<T> prev) {

      this.data = data;
      this.next = next;
      this.prev = prev;
    }
  }

    public boolean isEmpty() {
      return size == 0;
    }

    public Node<T> addFirst(T data) {

      if (isEmpty()) {
        head = tail = new Node(data, null, null);
      } else {
        head.prev = new Node(data, head, null);
        head = head.prev;
      }

      size++;

      return head;
    }

  public Node<T> addLast(T data) {

    if (isEmpty()) {
      head = tail = new Node(data, null, null);
    } else {
      tail.next = new Node(data, null, tail);
      tail = tail.next;
    }

    size++;

    return tail;
  }

  public void clear() {

    Node<T> trav = head;

    while (trav != null) {
      final Node<T> next = trav.next;

      trav.next = trav.prev = null;
      trav.data = null;
      trav = next;
    }

    head = tail = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public T peekFirst() {

    if (isEmpty()) {
      throw new RuntimeException("Element not Found");
    }

    return head.data;
  }

  public T peekLast() {

    if (isEmpty()) {
      throw new RuntimeException("Element not Found");
    }

    return tail.data;
  }

  public T removeFirst() {

    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = head.data;

    head = head.next;
    --size;

    if (isEmpty()) {
      tail = null;
    }
    else {
      head.prev = null;
    }

    return data;
  }

  public T removeLast() {

    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    T data = tail.data;

    tail = tail.prev;
    --size;

    if (isEmpty()) {
      head = null;
    }
    else {
      tail.next = null;
    }

    return data;
  }

  public T remove(Node<T> node) {

    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    if (node.prev == null) {
      return removeFirst();
    }

    if (node.next == null) {
      return removeLast();
    }

    node.next.prev = node.prev;
    node.prev.next = node.next;

    final T data = node.data;

    node.data = null;
    node.prev = node.next = null;

    --size;
    return data;
  }


  public boolean remove(T obj) {

    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    if (obj == null) {

      for (Node<T> trav = head; trav != null; trav = trav.next) {
        if (trav.data == null) {
          remove(trav);
          return true;
        }
      }

    } else {
      for (Node<T> trav = head; trav != null; trav = trav.next) {
        if (trav.data.equals(obj)) {
          remove(trav);
          return true;
        }
      }
    }
    return false;
  }

  public int indexOf(T obj) {

    if (isEmpty()) {
      throw new RuntimeException("Empty List");
    }

    int index = 0;

    if (obj == null) {

      for (Node<T> trav = head; trav != null; trav = trav.next, index++) {

        if (trav.data == null) {
          return index;
        }
      }
    }
    else {

      for (Node<T> trav = head; trav != null; trav = trav.next, index++) {

        if (trav.data.equals(obj)) {
          return index;
        }
      }
    }
    return -1;
  }


  @Override
  public Iterator<T> iterator() {
    return null;
  }

}
