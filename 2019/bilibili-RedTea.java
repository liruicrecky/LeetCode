import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cups = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        int target = sc.nextInt();
        sc.close();

        int[] vols = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(vols);

        int s = 0, e = vols.length - 1;
        boolean find = false;
        while (s < e) {
            int firstCup = vols[s], secondCup = vols[e];
            if (firstCup + secondCup == target) {
                System.out.printf("%d %d\n", firstCup, secondCup);
                find = true;
                ++s;
            } else if (firstCup + secondCup > target) {
                --e;
            } else {
                ++s;
            }
        }

        if (!find) {
            System.out.println("NO");
        }
    }
}