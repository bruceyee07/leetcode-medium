/**
 * https://leetcode.com/problems/super-ugly-number/
 * https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explained @isax
 */
class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    int [] dp = new int[n];
    dp[0] = 1;
    int [] idx = new int[primes.length];
    
    for (int i = 1; i < n; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        if (primes[j] * dp[idx[j]] == dp[i - 1]) {
          idx[j]++;
        }
        dp[i] = Math.min(dp[i], primes[j] * dp[idx[j]]);
      }
    }
    return dp[n-1];
  }
}

suppose we have three prime numbers 2,3,5

the first 20 ugly number are: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30, 32, 36
for prime number 2: 2, 4, 6, 8, 10, 12, 16, 18, 20, 24, 25, 27, 30, 32, 36
for prime number 3: 3, 6, 9, 12, 15, 18, 24, 27, 30, 36
for prime number 5: 5, 10, 15, 20, 25, 30