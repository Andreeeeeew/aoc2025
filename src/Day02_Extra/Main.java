package Day02_Extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Long> invalidIDs = new ArrayList<>();
    public static Long total = 0l;

    public static void main(String[] args) throws FileNotFoundException {
        URL path = Day02_Extra.Main.class.getResource("Input.txt");
        File f = new File(path.getFile());

        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Current Line: " + line);
                String[] ranges = line.split(",");
                for (String range : ranges) {
                    System.out.println("---------");
                    System.out.println("Range: " + range);
                    String[] temp = range.split("-");
                    System.out.print("First half: " + temp[0]);
                    System.out.print(" - Second half: " + temp[1]);

                    getInvalidIDs(temp[0], temp[1]);
                    System.out.println("Size: " + invalidIDs.size());
                }

                System.out.println("total: " + total);
            }
        }
    }

    static void getInvalidIDs(String startIndex, String endIndex) {
        long start = Long.parseLong(startIndex);
        long end = Long.parseLong(endIndex);

        for (long i = start; i <= end; i++) {
            String number = Long.toString(i);
            if (number.length() % 2 == 0) {
                String firstHalf = number.substring(0, (number.length() / 2));
                String secondHalf = number.substring((number.length() / 2));

                if (firstHalf.equals(secondHalf)) {
                    System.out.println("\nRINGADINGDING");
                    System.out.println("\nfull Number: " + number);
                    System.out.println("firstHalf: " + firstHalf);
                    System.out.println("secondHalf: " + secondHalf);

                    invalidIDs.add(Long.parseLong(number));
                    total += i;
                }
            }

        }
    }
}
