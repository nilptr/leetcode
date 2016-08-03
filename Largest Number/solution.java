public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) list.add(Integer.toString(num));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        String ret =  String.join("", list);
        int i;
        for (i = 0; i < ret.length() - 1; ++i) {
            if (ret.charAt(i) != '0') {
                break;
            }
        }
        return ret.substring(i);
    }
}