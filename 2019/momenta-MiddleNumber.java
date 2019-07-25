import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String[] line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]), x = Integer.parseInt(line[1]);
            line = bf.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.valueOf(line[i]);
            }
            calAdd(arr, n, x);
        }

        bf.close();
    }

    private static void calAddOther(int[] arr, int x) {
        int left = 0, right = 0, equal = 0;
        int res = 0;

        for (int n : arr) {
            if (n > x) {
                ++right;
            } else if (n < x) {
                ++left;
            } else {
                ++equal;
            }
        }

        if (left > right) {
            res = Math.max(left - right - e + 1, 0);
        } else if (right > left) {
            res = Math.max(right - left - e, 0);
        } else {
            res = equal >= 1 ? 0 : 1;
        }

        System.out.println(res);
    }

    private static void calAdd(int[] arr, int n, int x) {
        Arrays.sort(arr);

        boolean xInArr = false;
        int half = (n - 1) >> 1;
        if (arr[half] == x) {
            System.out.println(0);
            return;
        }

        int s = half - 1, e = half + 1;
        while (s >= 0 && arr[s] != x) {
            --s;
        }
        while (e < n && arr[e] != x) {
            ++e;
        }

        int index = 0;
        if (s != -1 || e != n) {
            xInArr = true;
            if (s != -1) {
                index = s;
            } else {
                index = e;
            }
        }

        int left = 0, right = 0;
        if (xInArr) {
            left = index;
            right = n - index - 1;
            System.out.println(left > right ? left - right : right - left - 1);
            return;

        }

        if (x > arr[n - 1] || x < arr[0]) {
            System.out.println(n + 1);
            return;
        }

        for (index = 0; index < n - 1; index++) {
            if (arr[index] < x && arr[index + 1] > x) {
                break;
            }
        }

        left = index + 1;
        right = n - index - 1;
        System.out.println(left >= right ? left - right + 1 : right - left);
    }
}