class Solution {
    Map<String, Boolean> cache = new HashMap();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s)) return cache.get(s);
        if (s.isEmpty()) return true;
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()), wordDict)) {
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}
