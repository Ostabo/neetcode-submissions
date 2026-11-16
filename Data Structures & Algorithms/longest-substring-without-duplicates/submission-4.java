class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> seen = new HashSet();
            int l = 0;
            while (i + l < chars.length && !seen.contains(chars[i + l])) {
                seen.add(chars[i + l]);
                l++;
                if (max < l) max = l;
            }
        }
        return max;
    }
 }
