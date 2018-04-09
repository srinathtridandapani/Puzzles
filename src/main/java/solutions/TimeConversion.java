package solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        boolean amFlag = false;
        boolean pmFlag = false;
        StringBuilder outputTime = new StringBuilder();
        if (s.contains("AM") || s.contains("am")) {
            amFlag = true;
        } else if (s.contains("PM") || s.contains("pm")) {
            pmFlag = true;
        }

        if (s.contains(":") && s.split(":").length == 3) {
            String[] parsedString = s.split(":");
            try {
                int hr = Integer.parseInt(parsedString[0]);
                int mm = Integer.parseInt(parsedString[1]);
                String ss = parsedString[2].substring(0, 2);
                int ss1 = Integer.parseInt(ss);
                if ((hr >= 0 && hr <= 12) && (mm >= 0 && mm <= 59) && (ss1 >= 0 && ss1 <= 59)) {
                    if (amFlag) {
                        if (Integer.parseInt(parsedString[0]) == 12) {
                            outputTime.append(0);
                            outputTime.append(0);

                        } else if (Integer.parseInt(parsedString[0]) >= 0 && Integer.parseInt(parsedString[0]) <= 11) {
                            outputTime.append(parsedString[0]);
                        }
                        outputTime.append(":").append(parsedString[1]).append(":").append(ss);
                    } else if (pmFlag) {
                        if (Integer.parseInt(parsedString[0]) == 12) {
                            outputTime.append(12);
                        } else if (Integer.parseInt(parsedString[0]) >= 0 && Integer.parseInt(parsedString[0]) <= 11) {
                            int adjustedHr = Integer.parseInt(parsedString[0]) + 12;
                            outputTime.append(adjustedHr);
                        }
                        outputTime.append(":").append(parsedString[1]).append(":").append(ss);
                    }
                }
            } catch (NumberFormatException nfe) {}
        }
        return outputTime.toString();

    }

    public static void main(String[] args) throws IOException {
        String s = "12:40:22AM";

        String result = timeConversion(s);

        System.out.println(result);
    }
}

