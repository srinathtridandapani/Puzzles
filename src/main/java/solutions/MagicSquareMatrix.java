package solutions;

import java.util.Scanner;

public class MagicSquareMatrix {

    /**
     * Solution:
     In order to solve this problem we need to understand several properties of a “magic square” such as :
     1. Sum of all diagonal, horizontal and vertical rows are the same.
     2. The middle part of the magic square is a number which is a median of all numbers in range (in this case the median is 5 since the range is [1,9] ).
     3. There are 8 different types of magic square in a matrix with 3 x 3 size.
     * The problem is asking to print out the smallest possible cost to turn a random square input-ed
     * into a magic square which must be one of the eight magic squares. So the easiest solution is to put all 8 possible magic square into our program and compare it to the input
     * ( by performing |a-b| operation on all the elements ) and then output the smallest integer obtained during the process.
     *
     * Input: 4 9 2 3 5 7 8 1 5
     * Output: 1
     */
    static int formingMagicSquare(int[][] s) {


        int[][] frame1 =
                {{4, 9, 2},
                        {3, 5, 7},
                        {8, 1, 6}};

        int[][] frame11 =
                {{8, 1, 6},
                        {3, 5, 7},
                        {4, 9, 2}};

        int[][] frame2 =
                {{8, 3, 4},
                        {1, 5, 9},
                        {6, 7, 2}};

        int[][] frame12 =
                {{4, 3, 8},
                        {9, 5, 1},
                        {2, 7, 6}};

        int[][] frame3 =
                {{6, 1, 8},
                        {7, 5, 3},
                        {2, 9, 4}};

        int[][] frame13 =
                {{2, 9, 4},
                        {7, 5, 3},
                        {6, 1, 8}};

        int[][] frame4 =
                {{2, 7, 6},
                        {9, 5, 1},
                        {4, 3, 8}};

        int[][] frame14 =
                {{6, 7, 2},
                        {1, 5, 9},
                        {8, 3, 4}};

        int cost1 = diff(s, frame1);
        int cost2 = diff(s, frame2);
        int cost3 = diff(s, frame3);
        int cost4 = diff(s, frame4);

        int cost11 = diff(s, frame11);
        int cost12 = diff(s, frame12);
        int cost13 = diff(s, frame13);
        int cost14 = diff(s, frame14);

        int min = Math.min(cost1, Math.min(cost2, Math.min(cost3, cost4)));
        int min1 = Math.min(cost11, Math.min(cost12, Math.min(cost13, cost14)));
        return Math.min(min,min1);

    }

    static int diff(int[][] numbers, int[][] frame) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost += Math.abs(numbers[i][j] - frame[i][j]);
            }
        }
        return cost;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}

