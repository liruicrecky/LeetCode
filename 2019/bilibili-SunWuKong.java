import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long k = sc.nextLong();
        sc.nextLine();
        long[] powers = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Integer::parseInt).toArray();
        sc.close();

        Arrays.sort(powers);

        long minP = 0, maxP = powers[num - 1] * powers[num - 2];
        while (minP < maxP) {
            long mid = (minP + maxP + 1) >> 1;
            long cnt = 0;
            int low = 0, high = num - 1;
            while (low < high && cnt < k) {
                while (low < high && powers[low] * powers[high] < mid) {
                    ++low;
                }
                cnt += high - low > 0 ? high - low : 0;
                --high;
            }
            if (cnt >= k) {
                minP = mid;
            } else {
                maxP = mid - 1;
            }
        }
        System.out.println(minP);
    }
}