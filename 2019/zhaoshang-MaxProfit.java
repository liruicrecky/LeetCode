import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int res = 0, min = Integer.MAX_VALUE;
        while (bf.ready()) {
            int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int p : arr) {
                res = Math.max(res, p - min);
                min = Math.min(min, p);
            }
            System.out.println(res);
        }

        bf.close();
    }
}