public class Solution {
    public int calculate(String s) {
        int num = 0;

        Stack<Integer> operand = new Stack<>(); // 操作数
        Stack<Character> operator = new Stack<>(); // 操作符

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case '*':
                case '/':
                case '+':
                case '-':
                    // 先压入操作数
                    operand.push(num);
                    num = 0;

                    doOperation(operand, operator, c);
                    break;
                case ' ': // 跳过空格
                    break;
                default: // 数字
                    num = num * 10 + (c - '0');
                    break;
            }
        }
        operand.push(num);
        doOperation(operand, operator, '+');
        return operand.pop();
    }

    private void doOperation(Stack<Integer> operand, Stack<Character> operator, char newOp) {
        if (!operator.empty() && operator.peek() == '/') { // 立即计算栈顶除法
            int b = operand.pop();
            int a = operand.pop();
            operand.push(a / b);
            operator.pop();
        }
        if (newOp == '*') { // 乘法直接压栈
            operator.push(newOp);
            return;
        }
        // + or - 清算左侧表达式; / 清算左侧乘法
        for (; newOp == '/' ? (!operator.empty() && operator.peek() == '*') : !operator.empty(); ) {
            int b = operand.pop();
            int a = operand.pop();
            char op = operator.pop();
            switch (op) {
                case '+':
                    operand.push(a + b);
                    break;
                case '-':
                    operand.push(a - b);
                    break;
                case '*':
                    operand.push(a * b);
                    break;
                case '/':
                    operand.push(a / b);
                    break;
                default:
                    break;
            }
        }
        operator.push(newOp); // 压栈新操作符
    }
}
