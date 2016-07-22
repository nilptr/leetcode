public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> usage = new TreeSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (b != map.get(a)) {
                    return false;
                }
            } else if (usage.contains(b)) {
                return false;
            } else {
                map.put(a, b);
                usage.add(b);
            }
        }
        return true;
    }
}