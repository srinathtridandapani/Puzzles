package solutions;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandles {

    /*
     * Complete the birthdayCakeCandles function below.
     */
    static int birthdayCakeCandles(int n, int[] ar) {
        Arrays.sort(ar);
        int length = ar.length;
        int max = 0;
        int lastmax = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] >= max) {
                lastmax = max;
                max = ar[i];
                flag = true;
            }
            if (lastmax != max)
                count = 1;
            else if (flag) {
                flag = false;
                count++;
            }
        }
        return count;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] ar = new int[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = birthdayCakeCandles(n, ar);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
    }
}

