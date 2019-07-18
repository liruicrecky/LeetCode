import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String line = bf.readLine();
            int index = 0;
            while (line.charAt(index) != ' ') {
                ++index;
            }
            int k = Integer.valueOf(line.substring(0, index));
            System.out.println(appearFirstK(k, line.substring(index + 1, line.length())));
        }

        bf.close();
    }

    private static String appearFirstK(int k, String s) {
        char[] arr = s.toCharArray();
        int[] hash = new int[200];
        for (char c : arr) {
            hash[c]++;
        }
        for (char c : arr) {
            if (hash[c] == 1 && k == 1) {
                return "[" + c + "]";
            } else if (hash[c] == 1) {
                --k;
            }
        }

        return "Myon~";
    }

}