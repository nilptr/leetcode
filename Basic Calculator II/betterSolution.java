
// 来自讨论区 思路非常清晰
public class Solution {
    public int calculate(String s) {
        int num = 0;

        Stack<Integer> stack = new Stack<>(); // 操作数

        char op = '+';
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ("+-*/".indexOf(c) > -1 || i == s.length() -1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                num = 0;
                op = c;
            }
        }

        int ret = 0;
        for (int i : stack) {
            ret += i;
        }
        return ret;
    }
}
