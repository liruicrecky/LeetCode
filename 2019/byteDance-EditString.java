import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            int n = Integer.valueOf(bf.readLine());
            for (int i = 0; i < n; i++) {
                String str = bf.readLine();
                System.out.println(edit(str));
            }
        }

        bf.close();
    }

    private static String edit(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            int len = sb.length();
            if (len < 2) {
                sb.append(c);
                continue;
            }

            if (len >= 2) {
                if (sb.charAt(len - 1) == c && sb.charAt(len - 2) == c) {
                    continue;
                }
            }

            if (len >= 3) {
                if (sb.charAt(len - 1) == c && sb.charAt(len - 2) == sb.charAt(len - 3)) {
                    continue;
                }
            }

            sb.append(c);
        }
        
        return sb.toString();
    }
}