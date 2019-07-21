import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            int T = Integer.valueOf(bf.readLine());
            for (int i = 0; i < T; i++) {
                int n = Integer.valueOf(bf.readLine());
                String[] line = bf.readLine().split(" ");
                int[] arr = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[j] = Integer.valueOf(line[j]);
                }

                overlapped(arr);
            }
        }

        bf.close();
    }

    private static void overlapped(int[] arr) {
        if (arr.length < 3) {
            System.out.println("y");
        }

        boolean[] canContian = new boolean[arr.length + 1];
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> m = new HashMap<>(arr.length);
        for (int i = 0; i <= arr.length; i++) {
            canContian[i] = true;
        }
        for (int i = 0; i < copy.length; i++) {
            m.put(copy[i], i);
        }

        for (int i = 0; i < arr.length - 2; i++) {
            if (!canContian[m.get(arr[i + 2])]) {
                System.out.println("y");
                return;
            }

            int max = Math.max(arr[i], arr[i + 1]);
            int min = Math.min(arr[i], arr[i + 1]);

            if (arr[i + 2] >= min && arr[i + 2] <= max) {
                int tmp = m.get(max);
                if (tmp <= arr.length && canContian[tmp]) {
                    while (tmp <= arr.length) {
                        canContian[tmp++] = false;
                    }
                }

                tmp = m.get(min);
                if (tmp >= 0 && canContian[tmp]) {
                    while (tmp >= 0) {
                        canContian[tmp--] = false;
                    }
                }

            } else {
                for (int k = m.get(min); k < m.get(max); k++) {
                    canContian[k] = false;
                }

            }
        }

        System.out.println("n");
    }

}