import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(new
        // FileInputStream("input.txt")));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (bf.ready()) {
            int nWeapon = Integer.parseInt(bf.readLine());
            int[] weaponLen = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int nCustom = Integer.parseInt(bf.readLine());
            int[][] ranges = new int[nCustom][2];
            for (int i = 0; i < nCustom; i++) {
                ranges[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int count = 0;
            for (int[] range : ranges) {
                int l = range[0], r = range[1];
                if (r - l + 1 < 3) {
                    continue;
                }
                if (r - l + 1 >= 47) {
                    ++count;
                } else if (checkTri(weaponLen, l, r)) {
                    ++count;
                }
            }

            System.out.println(count);
        }
        bf.close();
    }

    private static boolean checkTri(int[] weaponLen, int l, int r) {
        int[] sub = IntStream.range(l - 1, r).map(i -> weaponLen[i]).toArray();
        Arrays.sort(sub);
        for (int i = 0; i < sub.length - 2; i++) {
            if (sub[i] + sub[i + 1] > sub[i + 2]) {
                return true;
            }
        }

        return false;

        /*
         * for (int i = l; i <= r - 2; i++) { for (int j = i + 1; j <= r - 1; j++) { for
         * (int k = j + 1; k <= r; k++) { if (weaponLen[i] + weaponLen[j] > weaponLen[k]
         * && weaponLen[i] + weaponLen[k] > weaponLen[j] && weaponLen[j] + weaponLen[k]
         * > weaponLen[i]) { return true; } } } } return false;
         */

    }
}