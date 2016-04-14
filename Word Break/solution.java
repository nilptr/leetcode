public class Solution {
    // 递归
    // 时间 O(2 ^ n)
    // 空间 O(n)
    // public boolean wordBreak(String s, Set<String> wordDict) {
    //     int len = s.length();
    //     if (wordDict.contains(s)) return true;
        
    //     for (int i = 1; i < len; ++i) 
    //         if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict))
    //             return true;
        
    //     return false;
    // }

    // 超时数据
    // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    // ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

    // dp
    // 时间 O(n ^ 2)
    // 空间 O(n)
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        if (len == 0) return false;
        if (wordDict.contains(s)) return true;
        
        boolean[] dpMap = new boolean[len + 1];
        
        for (int i = 0; i <= len; ++i) {
            if (wordDict.contains(s.substring(0, i))) {
                dpMap[i] = true;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dpMap[i] = dpMap[j] && wordDict.contains(s.substring(j, i)))
                    break;
                }
            }
        }
        
        return dpMap[len];
    }
}