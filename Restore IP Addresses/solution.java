public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddressHelper(s, 4);
    }
    
    private List<String> restoreIpAddressHelper(String s, int sections) {
        List<String> ret = new ArrayList<>();
        if (s.length() > sections * 3 || s.length() < sections) return ret;
        if (sections == 1 && hasNoPrefixZero(s) && Integer.parseInt(s) < 256) {
            ret.add(s);
            return ret;
        }

        // 防止越界
        for (int i = 0; i < 3 && i < s.length(); ++i) {
            String prefix = s.substring(0, i + 1);
            if (hasNoPrefixZero(prefix) && Integer.parseInt(prefix) < 256) {
                List<String> parts = restoreIpAddressHelper(s.substring(i + 1), sections - 1);
                for (String str: parts) {
                    ret.add(prefix + "." + str);
                }
            } else {
                break;
            }
        }

        return ret;
    }

    // 每段不能有前导0
    private boolean hasNoPrefixZero(String s) {
        return s.length() <= 1 || s.charAt(0) != '0';
    }
}
