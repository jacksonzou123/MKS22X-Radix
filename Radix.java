public class Radix{
  public static void radixsort(int[] data) {
    int runs = 0;
    for (int i = 0; i < data.length; i++) {
      if (runs < (int)Math.log10(Math.abs(data[i]))) {
        runs = (int)Math.log10(Math.abs(data[i]));
      }
    }
    @SuppressWarnings("unchecked")
    LinkedList<Integer>[] buckets = new LinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new LinkedList<Integer>();
    }
    for (int i = 0; i < data.length; i++) {
        int digit = data[i] % 10;
        buckets[digit+9].add(data[i]);
    }
    for (int i = 1; i < buckets.length; i++) {

    }

    for (int i = 0; i < buckets.length; i++) {
      System.out.println(buckets[i].toString());
    }
  }
}
