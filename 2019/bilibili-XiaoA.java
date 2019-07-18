import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] id;
    private static int[] height;

    private static int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    private static void union(int l, int r) {
        int i = find(l);
        int j = find(r);
        if (i != j) {
            if (height[i] < height[j]) {
                id[i] = j;
                height[j] += height[i];
            } else {
                id[j] = i;
                height[i] += height[j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(new
        // FileInputStream("input.txt")));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (bf.ready()) {
            int n = Integer.parseInt(bf.readLine());
            int ai = Integer.parseInt(bf.readLine());
            int m = Integer.parseInt(bf.readLine());

            id = new int[n];
            height = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                height[i] = 1;
            }

            int aiIn = 0, res = 0;
            for (int i = 0; i < m; i++) {
                int[] pair = Arrays.stream(bf.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
                if (pair[0] == ai || pair[1] == ai) {
                    ++aiIn;
                }
                union(pair[0], pair[1]);
            }

            for (int i = 0; i < n; i++) {
                if (find(ai) == find(i)) {
                    ++res;
                }
            }

            System.out.println(res - aiIn - 1);
        }

        bf.close();
    }
}
