/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 * https://leetcode.com/problems/sort-integers-by-the-power-value/discuss/613036/Java-PQ @Kid_Piano
 */
class Solution {
  public int getKth(int lo, int hi, int k) {
    int[][] arr = new int[hi - lo + 1][2];
    for (int i = lo; i <= hi; i++) {
      arr[i - lo] = new int[]{i, getPower(i)};
    }
    Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
    return arr[k - 1][0];
  }

  public int getPower(int n) {
    if (n == 1) return 0;
    Map<Integer, Integer> m = new HashMap<>();
    if (m.get(n) != null) return m.get(n);
    if ((n & 1) == 0) {
      m.put(n, getPower(n / 2) + 1);
    } else {
      m.put(n, getPower(3 * n + 1) + 1);
    }
    return m.get(n);
  }
}

Why does this built in sort work? What if there are multiple numbers with the same power value?
Well, in Java, Arrays.sort will use mergesort when sorting objects, which is a stable sort. This means the original numbers will 
maintain their relative position to each other if they have the same power before and after the sorting.