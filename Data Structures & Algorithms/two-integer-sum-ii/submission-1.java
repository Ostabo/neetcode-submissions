class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (i >= 1 && numbers[i] <= numbers[i-1]) continue;
            for (int j = i + 1; j < numbers.length; j++) {
                if (j >= i + 2 && numbers[j] <= numbers[j-1]) continue;
                if (numbers[i] + numbers[j] == target) {
                    int[] res = {i+1, j+1};
                    return res;
                }
            }
        }
        throw new IllegalStateException("Not possible");
    }
}
