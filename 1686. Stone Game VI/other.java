/**
 * https://leetcode.com/problems/stone-game-vi/
 * https://leetcode.com/problems/stone-game-vi/discuss/969574/JavaC%2B%2BPython-Sort-by-Value-Sum
 */
class Solution {
  public int stoneGameVI(int[] A, int[] B) {
    int n = A.length;
    int[][] sums = new int[n][];
    for (int i = 0; i < n; i++) {
      sums[i] = new int[] {A[i] + B[i], A[i], B[i]};
    }
    Arrays.sort(sums, (a, b) -> Integer.compare(b[0], a[0]));
    int a = 0;
    int b = 0;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        a += sums[i][1];
      } else {
        b += sums[i][2];
      }
    }
    return Integer.compare(a, b);
  }
}

// Intuition
// Sort stones by their sum value for Alice and Bob.
// If a stone is super valued for Alice, Alice wants to take it.
// If a stone is super valued for Bob, Alice also wants to take it.
// Because she doesn't want Bob to take it.


// Explanation
// Here is more convinced explanation.
// Assume a stone valued [a,b] for Alice and Bod.
// Alice takes it, worth a for Alice,
// Bob takes it, worth b for Bob,
// we can also consider that it worth -b for Alice.
// The difference will be a+b.
// That's the reason why we need to sort based on a+b.
// And Alice and Bob will take one most valued stone each turn.