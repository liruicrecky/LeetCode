import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long mod = 99997867;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String[] line = bf.readLine().split(" ");
            int n = Integer.valueOf(line[0]), d = Integer.valueOf(line[1]);
            int[] arr = new int[n];
            line = bf.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.valueOf(line[i]);
            }

            System.out.println(cal(arr, d));
        }

        bf.close();
    }

    private static long cal(int[] arr, int d) {
        int len = arr.length;
        long[] deg = new long[len + 1];
        deg[1] = 1;
        for (int i = 2; i < len + 1; i++) {
            deg[i] = (deg[i - 1] + i) % mod;
        }
        long res = 0;
        for (int i = 0, j = 0; i < len; i++) {
            while (j + 1 < len && arr[j + 1] - arr[i] <= d) {
                ++j;
            }

            if (i + 2 > j) {
                continue;
            }
            
            res = (res + deg[j - i - 1]) % mod;
        }

        return res;
    }

}