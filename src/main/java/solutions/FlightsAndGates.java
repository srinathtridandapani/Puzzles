package solutions;

import java.util.Scanner;

public class FlightsAndGates {

    public static int minimumNumberOfGates(int[] arrival, int[] departure, int totalFlightsCount) {
        int minGates = 0;

        if (arrival.length == totalFlightsCount && departure.length == totalFlightsCount) {
            for (int i = 0; i < totalFlightsCount-1; i++) {
                if (arrival[i+1] <= departure[i]){
                    minGates++;
                }
            }
        }
        return minGates;

    }


    /**
     * Sample input and output
     * Input
     * Arrival - 900 940 950 1100 1500 1800
     * Departure - 910 1200 1120 1130 1900 2000
     *
     * Output - 3
     */
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = new int[6];
        int[] dep = new int[6];

        String[] arrItems = scan.nextLine().split(" ");
        String[] depItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < 6; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        for (int depItr = 0; depItr < 6; depItr++) {
            int depItem = Integer.parseInt(depItems[depItr].trim());
            dep[depItr] = depItem;
        }

        System.out.println(minimumNumberOfGates(arr, dep, 6));
    }
}
