package Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Main {
    static int total = 0;
    public static void main(String[] args) throws FileNotFoundException {
        URL path = Day04.Main.class.getResource("Input.txt");
        File f = new File(path.getFile());
        Map<Integer, String> lineMap = new HashMap<>();
        int i = 0;
        int j = 0;

        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineMap.put(i,line);
                i++;
            }
        }

        // check first line
        checkCheckCheck(null, lineMap.get(j), lineMap.get(j+1));

        while (j < lineMap.size()) {
            String first = lineMap.get(j);
            String second = lineMap.get(j+1);
            String third = lineMap.get(j+2);

            checkCheckCheck(first, second != null ? second : "........", third);

            j++;
        }
    }

    static void checkCheckCheck(String first, String second, String third) {
        int index = 0;
        for (char c : second.toCharArray()) {
            if (c == '@') {
                System.out.println("first: " + first);
                System.out.println("[second]: " + second);
                System.out.println("third: " + third);
                System.out.println("-------------------");
                String threeAbove = "...";
                if (first != null) {
                    if (index == first.length() - 1) {
                        threeAbove = String.valueOf(first.charAt(index-1)) + String.valueOf(first.charAt(index))  + (".");
                    } else if (index == 0) {
                        threeAbove = (".") + first.charAt(0) + first.charAt(1);
                    } else {
                        threeAbove = first.substring(index -1, index+2);
                    }
                }
                System.out.print("Index: " + index + " | Above: " + threeAbove);
                String threeBelow = "...";
                if (third != null) {
                    if (index == third.length() - 1) {
                        threeBelow = String.valueOf(third.charAt(index-1)) + String.valueOf(third.charAt(index)) + (".");
                    } else if (index == 0) {
                        threeBelow = (".") + third.charAt(0) + third.charAt(1);
                    } else {
                        threeBelow = third.substring(index -1, index+2);
                    }
                }
                System.out.print(" | Below: " + threeBelow);
                String left = index-1 < 0 ? "." : String.valueOf(second.charAt(index-1));
                System.out.print(" | Left: " + left);
                String right = index+1 > second.length() - 1 ? "." : String.valueOf(second.charAt(index+1));
                System.out.print(" | Right: " + right);
                System.out.println("\n--------------");

                int amountOfAt = 0;
                amountOfAt = threeAbove.length() - threeAbove.replace("@", "").length();
                amountOfAt += threeBelow.length() - threeBelow.replace("@", "").length();
                if (left.equals("@")) {
                    amountOfAt++;
                }
                if (right.equals("@")) {
                    amountOfAt++;
                }
                System.out.println("AmountOfAt: " + amountOfAt);

                if (amountOfAt < 4) {
                    System.out.println("RINGDINGDING");
                    total++;
                    System.out.println("New total " + total);
                }
                System.out.println("\n");
            }
            index++;
        }
    }
}
