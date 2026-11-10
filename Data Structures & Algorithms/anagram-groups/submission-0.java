class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedByAnagram = new HashMap();

        for (String s : strs) {
            char[] keyChars = s.toCharArray();
            Arrays.sort(keyChars);
            String key = new String(keyChars);

            if (groupedByAnagram.containsKey(key)) {
                groupedByAnagram.get(key).add(s);
            } else {
                List<String> l = new LinkedList();
                l.add(s);
                groupedByAnagram.put(key, l);
            }
        }   
        return new ArrayList(groupedByAnagram.values());
    }
}
