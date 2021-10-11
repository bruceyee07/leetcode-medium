/**
 * https://leetcode.com/problems/stone-game-vi/
 * https://leetcode.com/problems/stone-game-vi/discuss/969574/JavaC%2B%2BPython-Sort-by-Value-Sum
 * https://leetcode.com/problems/stone-game-vi/discuss/969509/Java-oror-20-lines-oror-O(nlogn)-oror-Explained-oror-Greedy
 */
class Solution {
  public int stoneGameVI(int[] aliceValues, int[] bobValues) {
    Queue<int[]> q = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
    for (int i = 0; i < aliceValues.length; i++) {
      q.offer(new int[]{aliceValues[i], bobValues[i]});
    }
    int asum = 0, bsum = 0;
    boolean aturn = true;
    while (!q.isEmpty()) {
      int[] pair = q.poll();
      if (aturn) {
        asum = asum + pair[0];
      } else {
        bsum = bsum + pair[1];
      }
      aturn = !aturn;
    }
    return Integer.compare(asum, bsum);
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