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
            String[] line = bf.readLine().split(",");
            String[] sArr = line[0].split(" ");
            int[] arr = new int[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                arr[i] = Integer.valueOf(sArr[i]);
            }
            int target = Integer.valueOf(line[1]);
            sumOf3(arr, target);
        }

        bf.close();
    }

    private static void sumOf3(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int sum = target - arr[i];
            int s = i + 1, e = arr.length - 1;
            while (s < e) {
                if (arr[s] + arr[e] == sum) {
                    System.out.println("True");
                    return;
                } else if (arr[s] + arr[e] > sum) {
                    --e;
                } else {
                    ++s;
                }
            }
        }

        System.out.println("False");
    }

}