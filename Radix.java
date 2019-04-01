public class Radix{
  public static void radixsort(int[] data) {
    int runs = 0;
    for (int i = 0; i < data.length; i++) {
      if (max < (int)Math.log10(data[i])) {
        max = (int)Math.log10(data[i]);
      }
    }
    runs++;
    while (runs > 0) {
      int buckets = new int[20];
    }
  }
}
