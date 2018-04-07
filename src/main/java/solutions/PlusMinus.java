package solutions;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {

    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        int size = arr.length;
        for(int i = 0 ;i < size; i++){
            if(arr[i] > 0)
                positive++;
            if(arr[i] < 0)
                negative++;
            if(arr[i] == 0)
                zero++;
        }


        DecimalFormat dec = new DecimalFormat("#0.0000");
        System.out.println(dec.format(positive/(double)size));
        System.out.println(dec.format(negative/(double)size));
        System.out.println(dec.format(zero/(double)size));

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr);
    }
}

