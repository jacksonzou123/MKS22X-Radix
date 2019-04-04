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

  public void extend(LinkedList<E> other) {
    end.setNext(other.start);
    size += other.size();
    end = other.end;
    other.start = null;
    other.end = null;
    other.size = 0;
  }

  public E removeFront() {
    E f = start.getData();
    if (size == 1) {
      clear();
    }
    else {
      Node current = start.next();
      start = current;
    }
    return f;
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
