public class Solution {
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public int titleToNumber(String s) {
        int ret = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            int idx = alphabet.indexOf(s.charAt(i));
            ret += ((idx + 1) * pow(26, len - i - 1));
        }
        return ret;
    }

    private int pow(int a, int b) {
        int ret = 1;
        for (int i = 0; i < b; ++i)
            ret *= a;
        return ret;
    }
}
