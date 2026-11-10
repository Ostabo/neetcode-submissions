class Solution {
    public List<Integer> partitionLabels(String s) {
        Stack<Integer> sizes = new Stack();
        Map<Character, Integer> seen = new HashMap();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character cur = chars[i];
            if (!seen.containsKey(cur)) {
                seen.put(cur, i);
                sizes.push(1);
                continue;
            }
            int seenInd = seen.get(cur);
            int sum = 1;
            for (int e = i - 1; e >= seenInd; e -= sizes.pop()) {
                sum += sizes.peek();
            }
            sizes.push(sum);
        }

        return new LinkedList(sizes);
    }
}
