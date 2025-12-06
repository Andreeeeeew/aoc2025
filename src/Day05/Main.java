package Day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Long> freshIngredients = new ArrayList<>();
    public static Long total = 0L;
    public static void main(String[] args) throws FileNotFoundException {
        List<Long> ingredients = new ArrayList<>();
        List<Range> ranges = new ArrayList<>();
        URL path = Day05.Main.class.getResource("Input.txt");
        File f = new File(path.getFile());
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains("-")) {
                    Range r = new Range();
                    r.start = Long.parseLong(line.split("-")[0]);
                    r.end = Long.parseLong(line.split("-")[1]);
                    ranges.add(r);
                } else {
                    if (line.isEmpty()) {
                        // ignore
                    } else {
                        ingredients.add(Long.parseLong(line));
                    }
                }
            }
            System.out.println("reached");

        }

        for (long ingredient : ingredients) {
            for (Range range : ranges) {
                if (ingredient >= range.start && ingredient <= range.end) {
                    total++;
                    break;
                }
            }
        }
        System.out.println("\nYOU DID IT - Total: " + total);
    }
}
