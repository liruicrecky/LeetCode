import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            int[] sum = new int[n >> 1];
            Arrays.sort(arr);
            for (int i = 0; i < n >> 1; i++) {
                sum[i] = arr[i] + arr[n - i - 1];
            }
            Arrays.sort(sum);
            System.out.println(sum[(n >> 1) - 1] - sum[0]);
        }

        bf.close();
    }
}