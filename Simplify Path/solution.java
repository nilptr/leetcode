public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] ps = path.split("/");
        for (int i = 0; i < ps.length; ++i) {
            if (ps[i].equals(".") || ps[i].equals("")) {
                continue;
            } else if (ps[i].equals("..")) {
                // 注意判断空栈 "/.."
                if (!stack.empty()) stack.pop();
            } else {
                stack.push(ps[i]);
            }
        }
        if (stack.empty()) return "/";
        String ret = "";
        for (String pn : stack) {
            ret += ("/" + pn);
        }
        return ret;
    }
}