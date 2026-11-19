class Solution {

    Set<Integer> seen = new HashSet();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (seen.contains(n)) return false;
        seen.add(n);
        String s = String.valueOf(n);
        char[] digits = s.toCharArray();
        int next = 0;
        for (char c : digits) {
            int d = Character.getNumericValue(c);
            next += d * d;
        }
        return isHappy(next);
    }
}
