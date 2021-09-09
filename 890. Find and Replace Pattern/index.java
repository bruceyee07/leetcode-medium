/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 * self
 */
class Solution {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> res = new ArrayList<>();
    for (String word : words) {
      if (checkPattern(word, pattern)) res.add(word); 
    }
    return res;
  }

  public boolean checkPattern(String word, String pattern) {
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      if (map.get(pattern.charAt(i)) == null) {
        if (Collections.frequency(map.values(), word.charAt(i)) > 0) {
           return false;
        } else {
          map.put(pattern.charAt(i), word.charAt(i));
        }
      } else if (map.get(pattern.charAt(i)) != word.charAt(i)) {
        return false;
      } else {
        continue;
      }
    }
    return true;
  }
}