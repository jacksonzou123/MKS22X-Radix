import java.util.*;

public class Driver{
  public static void main(String[] args) {
    int[] ary = new int[] {12391,56,2,5,7,1523,8,1,1,3,6,87,23,6,36,132,4,6};
    Radix.radixsort(ary);
    System.out.println(Arrays.toString(ary));
  }
}
