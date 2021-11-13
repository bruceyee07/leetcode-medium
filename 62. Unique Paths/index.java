/**
 * https://leetcode.com/problems/unique-paths/
 * https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
 */
class Solution {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) dp[i][j] = 1;
        if (j == 0) dp[i][j] = 1;
        if (i != 0 && j != 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
}