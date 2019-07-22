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
            postOrder(exp);
        }

        bf.close();
    }

    private static void postOrder(String exp) {
        char[] arr = exp.toCharArray();
        ArrayDeque<Character> expStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                if (expStack.isEmpty()) {
                    expStack.push(c);
                } else {
                    while (!expStack.isEmpty() && priority(c, expStack.peek()) <= 0) {
                        sb.append(expStack.pop());
                    }

                    expStack.push(c);
                }
            }
        }

        while (!expStack.isEmpty()) {
            sb.append(expStack.pop());
        }

        System.out.println(sb.toString());
    }

    private static int priority(char op1, char op2) {
        switch (op1) {
        case '+':
        case '-':
            return (op2 == '+' || op2 == '-') ? 0 : -1;
        case '*':
        case '/':
            return (op2 == '*' || op2 == '/') ? 0 : 1;

        default:
            return 1;
        }
    }

}