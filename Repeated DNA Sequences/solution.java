public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; ++i) {
            String seq = s.substring(i, i + 10);
            int count = map.getOrDefault(seq, 0);
            if (count == 0) {
                map.put(seq, 1);
            } else if (count == 1) {
                ret.add(seq);
                map.put(seq, 2);
            }
        }
        return ret;
    }
}
