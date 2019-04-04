import java.util.*;

public class Driver{
  public static void main(String[] args) {
    int[] ary = new int[] {22391,12391,322,45,517,1523,-112,68,-21,321,13,46,87,23,86,36,132,-24,56};
    System.out.println(Arrays.toString(ary));
    Radix.radixsort(ary);
    System.out.println(Arrays.toString(ary));
  }
}
