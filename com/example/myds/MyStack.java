package com.example.myds;

import java.util.LinkedList;

public class MyStack<T> {

  private LinkedList<T> linkedList = new LinkedList<T>();

  public MyStack(T data) {
    push(data);
  }

  public MyStack<T> push(T data) {
    this.linkedList.addLast(data);
    return this;
  }

  public int size() {
    return this.linkedList.size();
  }

  public T pop() {
    return this.linkedList.removeLast();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void clear() {
    this.linkedList.clear();
  }

}
