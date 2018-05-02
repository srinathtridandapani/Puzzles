package solutions;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leaderboard {

    /*
     * Complete the climbingLeaderboard function below.
     */
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        int index = 0;
        int uniqueIndex = 0;
        int lastScore = -1;
        int[] uniqueScores = new int[scores.length];
        while (index != scores.length) {
            int currScore = scores[index];
            if (currScore != lastScore) {
                uniqueScores[uniqueIndex] = currScore;
                uniqueIndex++;
            }
            lastScore = currScore;
            index++;
        }

        int i = uniqueIndex - 1;
        int k = 0;
        for (int aliceScore : alice) {
            while (i >= 0) {
                if (aliceScore < uniqueScores[i]) {
                    result[k] = i+2;
                    break;
                }
                i--;
            }
            if (i < 0) { // if true, each remaining aliceScore is highest score
                result[k] = 1;
            }
            k++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int scoresCount = Integer.parseInt(scanner.nextLine().trim());

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");

        for (int scoresItr = 0; scoresItr < scoresCount; scoresItr++) {
            int scoresItem = Integer.parseInt(scoresItems[scoresItr].trim());
            scores[scoresItr] = scoresItem;
        }

        int aliceCount = Integer.parseInt(scanner.nextLine().trim());

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int aliceItr = 0; aliceItr < aliceCount; aliceItr++) {
            int aliceItem = Integer.parseInt(aliceItems[aliceItr].trim());
            alice[aliceItr] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

