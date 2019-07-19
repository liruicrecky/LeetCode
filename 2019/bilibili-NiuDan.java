import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            long n = Integer.valueOf(bf.readLine());
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                if ((n & 1) == 0) {
                    n = (n - 2) >> 1;
                    sb.insert(0, 3);
                } else {
                    n = (n - 1) >> 1;
                    sb.insert(0, 2);
                }
            }
            System.out.println(sb.toString());
        }

        bf.close();
    }
}