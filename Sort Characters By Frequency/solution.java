public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        Map<Integer, List<Character>> revMap = new HashMap<>();
        for (char ch : map.keySet()) {
            int count = map.get(ch);
            if (revMap.containsKey(count)) {
                revMap.get(count).add(ch);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(ch);
                revMap.put(count, list);
            }
        }
        Integer[] keyArray = revMap.keySet().toArray(new Integer[0]);
        Arrays.sort(keyArray);
        List<Integer> keys = new ArrayList<>(keyArray.length);
        Collections.addAll(keys, keyArray);
        Collections.reverse(keys);
        StringBuilder builder = new StringBuilder(s.length());
        for (int count : keys) {
            List<Character> list = revMap.get(count);
            for (char ch : list) {
                for (int i = 0; i < count; ++i) {
                    builder.append(ch);
                }
            }
        }
        return builder.toString();
    }
}
