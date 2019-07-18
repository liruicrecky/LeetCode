import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String[] line = bf.readLine().split(" ");
            int rows = Integer.valueOf(line[0]), cols = Integer.valueOf(line[1]);
            if (rows == -1 && cols == -1) {
                break;
            }
            int[][] matrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                line = bf.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            printMatrix(matrix, rows, cols);
        }

        bf.close();
    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        int times = 0, index = 0;
        int[] arr = new int[rows * cols];

        while (times * 2 < rows && times * 2 < cols) {
            int endX = cols - times - 1;
            int endY = rows - times - 1;

            // Up
            for (int i = times; i <= endX; i++) {
                arr[index++] = matrix[times][i];
            }

            // Right
            if (times < endY) {
                for (int i = times + 1; i <= endY; i++) {
                    arr[index++] = matrix[i][endX];
                }
            }

            // Bottom
            if (times < endX && times < endY) {
                for (int i = endX - 1; i >= times; i--) {
                    arr[index++] = matrix[endY][i];
                }
            }

            // Left
            if (times < endX && times < endY - 1) {
                for (int i = endY - 1; i >= times + 1; i--) {
                    arr[index++] = matrix[i][times];
                }
            }

            ++times;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ",");
            }
        }

        System.out.println(sb.toString());
    }

}