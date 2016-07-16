/**
 * 判断字符串是否回文，只考虑其中的英文字符，无视大小写
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuffer buffer = new StringBuffer(s.length());
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) buffer.append(c);
        }
        s = buffer.toString();
        return s.equals(buffer.reverse().toString());
    }
}