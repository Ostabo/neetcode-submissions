class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if (
                    (top == '(' && cur != ')') ||
                    (top == '[' && cur != ']') ||
                    (top == '{' && cur != '}')
                    ) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
