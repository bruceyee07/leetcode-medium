/**
 * https://leetcode.com/problems/largest-number/
 * https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
 */
class Solution {
  public String largestNumber(int[] nums) {
    StringBuilder sb = new StringBuilder();
    String[] snums = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      snums[i] = String.valueOf(nums[i]);
    }
    Comparator<String> comp = new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        String order1 = str1 + str2;
        String order2 = str2 + str1;
        return order2.compareTo(order1);
      }
    };
    Arrays.sort(snums, comp);
    if (snums[0].equals("0")) {
      return "0";
    }
    for (String s : snums) {
      sb.append(s);
    }
    return sb.toString();
  }
}
