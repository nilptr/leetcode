public class Solution {
    public int calculate(String s) {
        int curInt = 0; // 暂存数字值
        int sign = 1;   // 记录计算类型 + / -
        Stack<Integer> operands = new Stack<>();
        operands.push(0); // 初始化栈
        for (char c : s.toCharArray()) {
            switch (c) {
                case '+':
                    operands.push(operands.pop() + sign * curInt);
                    curInt = 0;
                    sign = 1;
                    break;
                case '-':
                    operands.push(operands.pop() + sign * curInt);
                    curInt = 0;
                    sign = -1;
                    break;
                case '(':
                    // 将运算符压栈
                    operands.push(sign);
                    // 重新初始化
                    operands.push(0);
                    sign = 1;
                    break;
                case ')':
                    int val = operands.pop() + curInt * sign;
                    operands.push(val * operands.pop() + operands.pop());
                    curInt = 0;
                    sign = 1;
                    break;
                case ' ':
                    break;
                default:
                    curInt = curInt * 10 + (c - '0');
                    break;
            }
        }
        return operands.pop() + curInt * sign;
    }
}
