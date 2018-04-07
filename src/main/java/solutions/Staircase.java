package solutions;

import java.util.Scanner;

public class Staircase {

    /*
     * Complete the staircase function below.
     */
    static void staircase(int n) {

        for(int i=1 ; i<=n ; i++){
            int k = n - i;
            while(k!=0){
                System.out.print(" ");
                k--;
            }
            int hashCount = i;
            while(hashCount != 0){
                System.out.print("#");
                hashCount--;
            }

            System.out.println();
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        staircase(n);
    }
}
