class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        for (String token : tokens) {
            if (token.equals("+")) {
                s.push(s.pop() + s.pop());
            } else if (token.equals("-")) {
                int p1 = s.pop();
                int p2 = s.pop();
                s.push(p2 - p1);
            } else if (token.equals("*")) {
                s.push(s.pop() * s.pop());
            } else if (token.equals("/")) {
                int p1 = s.pop();
                int p2 = s.pop();
                s.push(p2 / p1);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
