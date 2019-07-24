import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            int[] p = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int H = Integer.parseInt(bf.readLine());

            int sum = 0, res;
            for (int i : p) {
                sum += i;
            }

            res = sum / H + 1;
            int count = Integer.MAX_VALUE;

            while (count > H) {
                int tmp = 0;
                for (int i : p) {
                    if (res >= i) {
                        ++tmp;
                    } else {
                        tmp += i / res + 1;
                    }
                }

                if (tmp > H) {
                    ++res;
                }
                count = tmp;
            }

            System.out.println(res);
        }

        bf.close();
    }
}