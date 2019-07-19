import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String[] version = bf.readLine().split(" ");
            String v1 = version[0], v2 = version[1];
            System.out.println(compare(v1.split("\\."), v2.split("\\."), 0));
        }

        bf.close();
    }

    private static int compare(String[] v1, String[] v2, int index) {
        if (index == v1.length && index == v2.length) {
            return 0;
        }

        if (index == v1.length && index < v2.length) {
            return -1;
        }

        if (index < v1.length && index == v2.length) {
            return 1;
        }

        if (Integer.valueOf(v1[index]) > Integer.valueOf(v2[index])) {
            return 1;
        }

        if (Integer.valueOf(v1[index]) < Integer.valueOf(v2[index])) {
            return -1;
        }

        return compare(v1, v2, index + 1);
    }

}