/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * https://leetcode.com/problems/path-sum-iii/
 * https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method @kekezi
 */
class Solution {
  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    return findPathSum(root, 0, targetSum, map);
  }

  private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
    if (curr == null) {
      return 0;
    }
    // update the prefix sum by adding the current val
    sum += curr.val;
    // get the number of valid path, ended by the current node
    int numPathToCurr = map.getOrDefault(sum-target, 0); 
    // update the map with the current sum, so the map is good to be passed to the next recursion
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    // add the 3 parts discussed in 8. together
    int res = numPathToCurr + findPathSum(curr.left, sum, target, map) + findPathSum(curr.right, sum, target, map);
    // restore the map, as the recursion goes from the bottom to the top
    map.put(sum, map.get(sum) - 1);
    return res;
  }
}

// It's not very hard if we understand the elementary idea:
// Given we have a route:
// ·················sum(a,b)···········sum(b,c)
// a-------------b--------------c

// we know that, sum(a,c) = sum(a,b) + sum(b,c)
// if target == sum(b,c), then sum(a,c) = sum(a,b) + target

// Now, we could infer that,
// if exists a point b, that conforming sum(a,b) = sum(a,c) - target,
// the, b-c is the path we want to find.



// 1. The prefix stores the sum from the root to the current node in the recursion

// 2. The map stores <prefix sum, frequency> pairs before getting to the current node. We can imagine a path from the root to the current node. 
// The sum from any node in the middle of the path to the current node = the difference between the sum from the root to the current node and
// the prefix sum of the node in the middle.

// 3. We are looking for some consecutive nodes that sum up to the given target value, which means the difference discussed in 2. should equal to
// the target value. In addition, we need to know how many differences are equal to the target value.

// 4. Here comes the map. The map stores the frequency of all possible sum in the path to the current node. If the difference between the 
// current sum and the target value exists in the map, there must exist a node in the middle of the path, such that from this node to the 
// current node, the sum is equal to the target value.

// 5. Note that there might be multiple nodes in the middle that satisfy what is discussed in 4. The frequency in the map is used to help 
// with this.

// 6. Therefore, in each recursion, the map stores all information we need to calculate the number of ranges that sum up to target. Note that 
// each range starts from a middle node, ended by the current node.

// 7. To get the total number of path count, we add up the number of valid paths ended by EACH node in the tree.

// 8. Each recursion returns the total count of valid paths in the subtree rooted at the current node. And this sum can be divided into three parts:
//   - the total number of valid paths in the subtree rooted at the current node's left child
//   - the total number of valid paths in the subtree rooted at the current node's right child
//   - the number of valid paths ended by the current node