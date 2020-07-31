package my;

public class MyDynamicArrayList<T> {

  private T[] list;

  private int size = 0;

  private int initialCapacity;

  public MyDynamicArrayList(int initialCapacity) {
    this.initialCapacity = initialCapacity;
    list = (T[])new Object[initialCapacity];
  }

  public int size()  {
    return list.length;
  }

  public void add(T data) {

    if (size == initialCapacity) {
      resize();
    }

    list[size] = data;
    size++;
  }

  public void resize() {
    T[] newList = (T[])new Object[initialCapacity * 2];

    for (int index = 0; index < size; index++) {
      newList[index] = list[index];
    }

    list = newList;
    size = initialCapacity * 2;
  }

  public void set(int index, T d) {
    if (index > size) {
      throw new RuntimeException();
    }
    list[index] = d;
  }

  public T get(int index) {
    if (index > size) {
      throw new RuntimeException();
    }
    return list[index];
  }

  public void insert(int index, T data) {

    if (size == initialCapacity) {
      resize();
    }

    for (int i = size; i > index; i--) {
      list[i] = list[i-1];
    }

    list[index] = data;
    size++;

  }
}
