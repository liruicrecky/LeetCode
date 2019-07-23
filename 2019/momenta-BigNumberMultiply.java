import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (bf.ready()) {
            String[] line = bf.readLine().split(" ");
            BigInteger n1 = new BigInteger(line[0]);
            BigInteger n2 = new BigInteger(line[1]);
            System.out.println(n1.multiply(n2));
            // bigNumberMultiply(s1, s2);
        }

        bf.close();
    }

    private static void bigNumberMultiply(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int len1 = c1.length, len2 = c2.length;
        int len = len1 + len2 - 1;
        int[] cache = new int[len];
        int n1, n2;
        int i, j;

        for (i = len1 - 1; i >= 0; i--) {
            n1 = c1[i] - '0';
            for (j = len2 - 1; j >= 0; j--) {
                n2 = c2[j] - '0';
                cache[i + j] += n1 * n2;
            }
        }

        for (i = len - 1; i > 0; i--) {
            cache[i - 1] += cache[i] / 10;
            cache[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int k : cache) {
            sb.append(k);
        }
 
        System.out.println(sb.toString());
    }

}