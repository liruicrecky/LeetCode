class Solution {
    public int calculate(String s) {
        ArrayDeque<Integer> operands = new ArrayDeque<>();
        int len = s.length(), num = 0;
        char op = '+';

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                continue;
            }

            cal(operands, op, num);
            num = 0;
            op = c;
        }

        cal(operands, op, num);
        num = 0;

        while (!operands.isEmpty()) {
            num += operands.pop();
        }

        return num;
    }

    private void cal(ArrayDeque<Integer> s, char operator, int operand) {
        switch (operator) {
        case '+':
            s.push(operand);
            break;
        case '-':
            s.push(-operand);
            break;
        case '*':
            s.push(s.pop() * operand);
            break;
        case '/':
            s.push(s.pop() / operand);
            break;
        default:
            break;
        }
    }
}