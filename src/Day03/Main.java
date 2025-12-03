package Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        URL path = Day03.Main.class.getResource("Input.txt");
        File f = new File(path.getFile());
        int highest;
        int secondHighest;
        int joltage;
        int current;
        int total = 0;


        try (Scanner scanner = new Scanner(f)) {

            while (scanner.hasNextLine()) {
                highest = 0;
                secondHighest = 0;
                String line = scanner.nextLine();
                System.out.println("-..........-");
                System.out.println(line);

                for (char c : line.toCharArray()) {
                    current = Integer.parseInt(String.valueOf(c));
                    if (current > highest) {
                        secondHighest = highest;
                        highest = current;
                    } else if (current > secondHighest) {
                        secondHighest = current;
                    }
                }

                System.out.print("Highest: " + highest);
                System.out.print(" - SecondHighest: " + secondHighest + "\n");

                int posHighest = line.indexOf(Integer.toString(highest));
                int posSecondHighest = line.indexOf(Integer.toString(secondHighest));
                System.out.print(posHighest + " poshigh");
                System.out.print(" - " + posSecondHighest + " posSecon \n");

                if (posHighest < posSecondHighest) {
                    String joltageString = String.valueOf(highest) + String.valueOf(secondHighest);
                    joltage = Integer.parseInt(joltageString);
                    System.out.println(joltage);
                } else if (posSecondHighest < posHighest) {
                    String joltageString = String.valueOf(secondHighest) + String.valueOf(highest);
                    joltage = Integer.parseInt(joltageString);
                    System.out.println(joltage);
                } else {
                    String joltageString = String.valueOf(secondHighest) + String.valueOf(highest);
                    joltage = Integer.parseInt(joltageString);
                    System.out.println(joltage);
                }
                total+=joltage;
            }
            System.out.println(total);
        }
    }
}
