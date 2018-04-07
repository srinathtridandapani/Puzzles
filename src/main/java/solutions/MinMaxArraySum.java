package solutions;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxArraySum {

    /*
     * Complete the miniMaxSum function below.
     */
    static void miniMaxSum(int[] arr) {
        long minimum = 0;
        long maximum = 0;

        Arrays.sort(arr);

        for(int i = 0; i< arr.length; i++){
            if(i == 0){
                minimum = minimum + arr[i];
                continue;
            }
            if(i == (arr.length-1)){
                maximum = maximum + arr[i];
                break;
            }
            minimum = minimum + arr[i];
            maximum = maximum + arr[i];
        }

        System.out.println(minimum + " " + maximum);

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < 5; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        miniMaxSum(arr);
    }
}

