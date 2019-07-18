import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String exp = bf.readLine();
            if (exp.equals("END")) {
                break;
            }
            System.out.println(cal(exp.toCharArray()));
        }

        bf.close();
    }

    private static int cal(char[] arr) {
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<Character> opStack = new ArrayDeque<>();

        for (int i = 0; i < arr.length;) {
            if (i < arr.length && Character.isDigit(arr[i])) {
                int sum = 0;
                while (i < arr.length && Character.isDigit(arr[i])) {
                    sum = sum * 10 + (arr[i] - '0');
                    ++i;
                }
                numStack.push(sum);
            } else if (i < arr.length) {
                char c = arr[i];
                if (opStack.isEmpty()) {
                    opStack.push(c);
                } else {
                    while (!opStack.isEmpty() && priorityCompare(c, opStack.peek()) <= 0) {
                        char op = opStack.pop();
                        int n1 = numStack.pop();
                        int n2 = numStack.pop();
                        numStack.push(calc(n2, n1, op));
                    }
                    opStack.push(c);
                }
                ++i;
            }
        }

        while (!opStack.isEmpty()) {
            char op = opStack.pop();
            int n1 = numStack.pop();
            int n2 = numStack.pop();
            numStack.push(calc(n2, n1, op));
        }

        return numStack.getFirst();
    }

    private static int priorityCompare(char op1, char op2) {
        switch (op1) {
        case '+':
        case '-':
            return op2 == '+' || op2 == '-' ? 0 : -1;
        case '*':
        case '/':
            return op2 == '*' || op2 == '/' ? 0 : 1;
        default:
            return 1;
        }
    }

    private static int calc(int n1, int n2, char op) {
        switch (op) {
        case '+':
            return n1 + n2;
        case '-':
            return n1 - n2;
        case '*':
            return n1 * n2;
        case '/':
            return n1 / n2;
        default:
            return 0;
        }
    }
}