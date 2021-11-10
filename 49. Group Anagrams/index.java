/**
 * https://leetcode.com/problems/group-anagrams/
 * self
 */
class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> m = new HashMap<>();
    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String key = String.valueOf(c);
      if (m.containsKey(key)) {
        List<String> list = m.get(key);
        list.add(s);
        List<String> newList = new ArrayList<>();
        newList.addAll(list);
        m.put(key, newList);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        m.put(key, list);
      }
    }
    List<List<String>> ans = new ArrayList<>();
    for (List<String> list : m.values()) {
      ans.add(list);
    }
    return ans;
  }
}