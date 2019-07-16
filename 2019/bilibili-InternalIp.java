import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        int[] ip = Arrays.stream(line.split("\\.")).mapToInt(Integer::parseInt).toArray();

        // 10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        // 172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        // 192.168.x.x/16
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;

        byte b0 = (byte) ip[0];
        byte b1 = (byte) ip[1];

        switch (b0) {
        case SECTION_1:
            System.out.println("1");
            break;
        case SECTION_2:
            if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                System.out.println("1");
            }
            break;
        case SECTION_5:
            switch (b1) {
            case SECTION_6:
                System.out.println("1");
            }
            break;
        default:
            System.out.println("0");
        }

    }
}