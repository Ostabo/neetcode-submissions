class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> seen = new HashMap();
        int l = 0;
        int r = 1;
        int longest = 1;
        if (chars.length <= 0) {
            return 0;
        }
        seen.put(chars[l], l);
        while (r < chars.length) {
            char rChar = chars[r];
            if (seen.containsKey(rChar)) {
                l = Math.max(l, seen.get(rChar) + 1);
            } 
            seen.put(chars[r], r);
            r++;
            longest = Math.max(longest, r - l);
        }
        return longest;
    }
 }
