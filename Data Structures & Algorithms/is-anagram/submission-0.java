class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        if (cs.length != ct.length) return false;

        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for (int i = 0; i < cs.length; i++) {
            count.put(cs[i], count.getOrDefault(cs[i], 0) + 1);
            count.put(ct[i], count.getOrDefault(ct[i], 0) - 1);
        }

        for (Map.Entry<Character, Integer> e : count.entrySet()) {
            if (e.getValue() != 0) return false;
        }
        return true;
    }
}
