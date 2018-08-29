package timesavers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsFileOperations {

    public static void main(String[] args) {

        /**
         * Reads lines in lines.txt one by one.
         * Output:
         * line1
         * line2
         * line3
         * line4
         * line5
         */

        String fileName = "c://lines.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * Perform operations on lines in file.
         * Output:
         * LINE1
         * LINE2
         * LINE4
         * LINE5
         */
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);

        /**
         * lines() api in BufferedReader gives stream access, to perform operations.
         * Output:
         * line1
         * line2
         * line3
         * line4
         * line5
         */
        List<String> list1 = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list1 = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list1.forEach(System.out::println);
    }
}
