public class LinkedList<E>{
  private int size;
  private Node start;
  private Node end;

  public LinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  public void clear() {
    size = 0;
    start = null;
    end = null;
  }

  public boolean add(E element) {
    if (size()==0){
      start = new Node(element, null, null);
      end = start;
    }
    else {
      Node current = new Node(element,null,end);
      end.setNext(current);
      end = current;
    }
    size++;
    return true;
  }

  public String toString() {
    if (size == 0) {
      return "[]";
    }
    Node current = start;
    String f = "[";
    while (current != end) {
      f += current.getData() + ", ";
      current = current.next();
    }
    f += end.getData() + "]";
    return f;
  }


  public E get(int index) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("get index out of bounds");
    }
    Node current = start;
    while (index != 0) {
      current = current.next();
      index--;
    }
    return current.getData();
  }

  public E set(int index, E element) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("set index out of bounds");
    }
    Node current = start;
    while (index != 0) {
      current = current.next();
      index--;
    }
    E f = current.getData();
    current.setData(element);
    return f;
  }

  public boolean contains(E value) {
    Node current = start;
    while (current != end) {
      if (current.getData() == value) {
        return true;
      }
      current = current.next();
    }
    return end.getData() == value;
  }

  public int indexOf(E value) {
    Node current = start;
    int index = 0;
    while (current != end) {
      if (current.getData().equals(value)) {
        return index;
      }
      index++;
      current = current.next();
    }
    if (end.getData() == value) {
      return index;
    }
    return -1;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("add index out of bounds");
    }
    if (size() == index) {
      add(value);
    }
    else {
      Node next = start;
      while (index != 0) {
        next = next.next();
        index--;
      }
      Node previous = next.prev();
      Node current = new Node(value, next, previous);
      try {
        previous.setNext(current);
      }
      catch(NullPointerException e) {
        start = current;
      }
      next.setPrev(current);
      size++;
    }
  }

  public E remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Remove index out of bounds");
    }
    E f = null;
    if (index == 0) {
      try {
        f = start.getData();
        start = start.next();
        start.setPrev(null);
      }
      catch(NullPointerException e) {
        start = null;
        end = null;
      }
    }
    else if (index == size()-1) {
      f = end.getData();
      end = end.prev();
      end.setNext(null);
    }
    else {
      Node current = start;
      while (index != 0) {
        index--;
        current = current.next();
      }
      f = current.getData();
      current.prev().setNext(current.next());
      current.next().setPrev(current.prev());
    }
    size--;
    return f;
  }

  public boolean remove(E value) {
    Node current = start;
    boolean check = false;
    int index = 0;
    try {
      while (!check) {
        if (current.getData().equals(value)) {
          check = true;
        }
        else {
          current = current.next();
          index++;
        }
      }
      if (check) {
        remove(index);
      }
      return check;
    }
    catch (NullPointerException e) {
      return false;
    }
  }

  public void extend(LinkedList other) {
    end.setNext(other.start);
    size += other.size();
    end = other.end;
    other.start = null;
    other.end = null;
    other.size = 0;
  }

  public class Node{
    private E data;
    private Node next;
    private Node prev;

    public Node(E i, Node n, Node p) {
      setData(i);
      setNext(n);
      setPrev(p);
    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public void setNext(Node other) {
      next = other;
    }

    public void setPrev(Node other) {
      prev = other;
    }

    public E getData() {
      return data;
    }

    public E setData(E i) {
      E f = getData();
      data = i;
      return f;
    }
  }
}
