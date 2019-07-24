import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String... args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    while (bf.ready()) {
      String s = bf.readLine();
      slove(s);
    }

    bf.close();
  }

  private static void slove(String s) {
    char[] arr = s.toCharArray();
    int leftC = 0, leftD = 0;
    int tmpC = 0, tmpD = 0;

    for (char c : arr) {
      if (c == 'C') {
        leftC += tmpC;
      } else {
        ++tmpC;
      }

      if (c == 'D') {
        leftD += tmpD;
      } else {
        ++tmpD;
      }
    }

    System.out.println(leftC > leftD ? leftD : leftC);
  }
}