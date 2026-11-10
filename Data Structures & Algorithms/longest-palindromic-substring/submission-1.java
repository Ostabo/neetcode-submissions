class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String cur = s.substring(i, j + 1);
                if (cur.length() > longest.length() && isPalindrome(cur)) {
                    longest = cur;
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        char[] cs = s.toCharArray();
        Stack<Character> st = new Stack();
        boolean skipMiddle = cs.length % 2 == 1;
        for (int i = 0; i < cs.length; i++) {
            if (skipMiddle && i == (cs.length / 2)) continue;
            if (i < cs.length / 2) {
                st.push(cs[i]);
            } else {
                if (st.pop() != cs[i]) return false;
            }
        }
        return true;        
    }
}
