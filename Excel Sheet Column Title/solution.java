public class Solution {
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        while (n != 0) {
            ret.append(alphabet.charAt((n - 1) % 26));
            n = (n - 1) / 26;
        }
        return ret.reverse().toString();
    }
}
