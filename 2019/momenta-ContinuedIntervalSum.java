import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String[] line = bf.readLine().split(" ");
            int c = Integer.valueOf(line[0]), x = Integer.valueOf(line[1]);
            line = bf.readLine().split(" ");
            int[] arr = new int[c];
            for (int i = 0; i < c; i++) {
                arr[i] = Integer.valueOf(line[i]);
            }

            System.out.println(allContinuedInterval(arr, x));
        }

        bf.close();
    }

    private static long allContinuedInterval(int[] arr, int target) {
        int len = arr.length;
        if (target == 0) {
            return ((len + 1) * len) >> 1;
        }

        long res = 0, curSum = 0;
        for (int i = 0, j = 0; i < len && j <= len; curSum -= arr[i++]) {
            while (j < len && curSum < target) {
                curSum += arr[j++];
            }

            if (curSum >= target) {
                res += len - j + 1;
            }
        }

        return res;
    }
}