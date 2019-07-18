import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            int n = Integer.parseInt(bf.readLine());
            int[][] maze = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = bf.readLine().split(",");
                for (int j = 0; j < n; j++) {
                    maze[i][j] = Integer.parseInt(line[j]);
                }
            }

            System.out.println(minReduceSpeed(maze, n));
        }

        bf.close();
    }

    private static int minReduceSpeed(int[][] maze, int n) {
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + maze[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[0] += maze[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = maze[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }

        return dp[n - 1];
    }

}