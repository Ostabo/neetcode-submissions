class Solution {
    public int[] plusOne(int[] digits) {
        int o = 1;
        for (int i = digits.length -1; i>=0;i--) {
            digits[i] = o == 1 && digits[i] == 9 ? 0 : digits[i] + o;
            o = o == 1 && digits[i] == 0 ? 1: 0;
        }
        if (o == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
