/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * self
 */
class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
      if (a.getValue() == b.getValue()) return a.getKey().compareTo(b.getKey());
      return b.getValue() - a.getValue();
    });
    for (Map.Entry entry : map.entrySet()) {
      pq.add(entry);
    }
    List<String> res = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      Map.Entry entry = pq.poll();
      res.add((String)entry.getKey());
    }
    return res;
  }
}