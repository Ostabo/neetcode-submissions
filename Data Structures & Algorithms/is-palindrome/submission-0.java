class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase().toCharArray();
        int p1 = 0;
        int p2 = c.length - 1;

        while (p1 <= p2 && p1 < c.length / 2) {
            if (c[p1] != c[p2]) return false;
            p1++;
            p2--;
        }
        return true;
    }
}
