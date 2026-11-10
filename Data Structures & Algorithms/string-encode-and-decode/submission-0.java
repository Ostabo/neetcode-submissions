class Solution {

    char marker = '|';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(marker);
            sb.append(s.length());
            sb.append(marker);
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new LinkedList();
        char[] chars = str.toCharArray();
        String currentHeader = null;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == marker && currentHeader != null) {
                int wordLength = Integer.parseInt(currentHeader);
                currentHeader = null;
                String resWord = "";
                int tmp = i;
                i++;
                while (i <= tmp + wordLength) {
                    resWord = resWord + chars[i++];
                }
                --i;
                res.add(resWord);
            } else if (chars[i] == marker && currentHeader == null) {
                currentHeader = "" + chars[++i];
            } else if (currentHeader != null) {
                currentHeader = currentHeader + chars[i];
            }
        }
        return res;
    }
}
