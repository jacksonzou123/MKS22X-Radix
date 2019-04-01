import java.util.*;

public class Deque<E>{
  private E[] data;
  public int size, start, end;

  @SuppressWarnings("unchecked")
  public Deque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }

  public Deque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = 0;
    end = 0;
    size = 0;
  }

  public int size(){
    return size;
  }

  private void resize(){
    if (size == data.length) {
      int index = 0;
      boolean done = false;
      E[] current = (E[])new Object[size*2];
      while (start < data.length && !done) {
        if (start == end) {
          done = true;
        }
        current[index] = data[start];
        start++;
        index++;
      }
      if (!done) {
        start = 0;
        while (start <= end) {
          current[index] = data[start];
          index++;
          start++;
        }
      }
      data = current;
      start = 0;
      end = size - 1;
    }
  }

  public String toString(){
    if (size == 0) {
      return "{}";
    }
    String f = "{";
    int index = start;
    boolean done = false;
    while (index < data.length && !done) {
      if (index == end) {
        done = true;
      }
      if (data[index] != null) {
        f += data[index] + " ";
      }
      index++;
    }
    if (!done) {
      index = 0;
      while (index <= end) {
        f += data[index] + " ";
        index++;
      }
    }
    return f.substring(0,f.length()-1) + "}";
  }

  public String index() {
    return "Start: " + start + " End: " + end + " Size: " + size;
  }

  public String array() {
    return Arrays.toString(data);
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    resize();
    if (start == 0) {
      start = data.length - 1;
    }
    else {
      if (size != 0) {
        start--;
      }
    }
    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    resize();
    if (end == data.length - 1) {
      end = 0;
    }
    else {
      if (size != 0) {
        end++;
      }
    }
    data[end] = element;
    size++;
  }

  public E removeFirst(){
    E element = data[start];
    data[start] = null;
    if (start == data.length) {
      start = 0;
    }
    else {
      start++;
    }
    size--;
    return element;
  }

  public E removeLast(){
    E element = data[end];
    data[end] = null;
    if (end == 0) {
      end = data.length-1;
    }
    else {
      end--;
    }
    size--;
    return element;
  }

  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }
