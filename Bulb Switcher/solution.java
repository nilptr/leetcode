// 非完全平方数的因数成对出现 拨动次数为偶数次 false -> false
// 完全平方数存在平方根 拨动次数为偶数次 + 1 奇数次 false -> true
public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt((double) n);
    }
}
