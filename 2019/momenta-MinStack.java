import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> s = new ArrayDeque<>();
        int min = 0;
        while (bf.ready()) {
            int Q = Integer.valueOf(bf.readLine());
            for (int i = 0; i < Q; i++) {
                String[] line = bf.readLine().split(" ");
                int op = Integer.valueOf(line[0]);
                switch (op) {
                case 0:
                    System.out.println(min);
                    break;
                case 1:
                    int v = Integer.valueOf(line[1]);
                    if (s.isEmpty()) {
                        min = v;
                    } else if (v <= min) {
                        s.push(min);
                        min = v;
                    }

                    s.push(v);
                    break;
                case 2:
                    int t = s.pop();
                    if (t == min) {
                        min = s.pop();
                    }
                    System.out.println(t);
                    break;
                default:
                    break;
                }
            }
        }

        bf.close();
    }

    public static void main1(String[] args) throws IOException {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(new
        // FileInputStream("input.txt")));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> s = new ArrayDeque<>();
        ArrayDeque<Integer> min = new ArrayDeque<>();
        while (bf.ready()) {
            int Q = Integer.valueOf(bf.readLine());
            for (int i = 0; i < Q; i++) {
                String[] line = bf.readLine().split(" ");
                int op = Integer.valueOf(line[0]);
                switch (op) {
                case 0:
                    System.out.println(min.peek());
                    break;
                case 1:
                    int v = Integer.valueOf(line[1]);
                    s.push(v);
                    if (min.isEmpty()) {
                        min.push(v);
                    } else {
                        min.push(Math.min(v, min.peek()));
                    }
                    break;
                case 2:
                    System.out.println(s.peek());
                    s.pop();
                    min.pop();
                    break;
                default:
                    break;
                }
            }
        }

        bf.close();
    }
}