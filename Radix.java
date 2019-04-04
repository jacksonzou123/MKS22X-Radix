public class Radix{
  public static void radixsort(int[] data) {
    //find the max number of digits of a number
    int runs = 0;
    for (int i = 0; i < data.length; i++) {
      if (runs < (int)Math.log10(Math.abs(data[i]))) {
        runs = (int)Math.log10(Math.abs(data[i]));
      }
    }
    @SuppressWarnings("unchecked")
    //create and initialize each bucket
    LinkedList<Integer>[] buckets = new LinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new LinkedList<Integer>();
    }
    //works on the ones digit
    for (int i = 0; i < data.length; i++) {
        int digit = data[i] % 10;
        buckets[digit+9].add(data[i]);
    }
    for (int i = 0; i < 19; i++) {
      if (buckets[i].size() != 0) {
        buckets[19].extend(buckets[i]);
      }
    }
    int place = 1;
    while (place <= runs) {
      while (buckets[19].size() > 0) {
        int num = buckets[19].removeFront();
        int digit = (num / exp(10,place)) % 10;
        buckets[digit+9].add(num);
      }
      for (int i = 0; i < 19; i++) {
        if (buckets[i].size() != 0) {
          buckets[19].extend(buckets[i]);
        }
      }
      place++;
    }
    for (int i = 0; i < data.length; i++) {
      data[i] = buckets[19].removeFront();
    }

  }

  public static int exp(int base, int expo) {
    int f = 1;
    while (expo > 0) {
      f *= base;
      expo--;
    }
    return f;
  }
}
