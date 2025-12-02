package Day01_Extra;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URL path = Main.class.getResource("Input.txt");
        File f = new File(path.getFile());
        int number = 50;
        int zeroCounter = 0;
        int amountOfZeroReached = 0;
        try(Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Current Number: " + number);
                if (line.contains("L")) {
                    line = line.substring(1);
                    int input = Integer.parseInt(line);
                    System.out.println("(-) Left Input: " + input);

                    int temp = 0;
                    if (input > 99) {
                        amountOfZeroReached += input / 100;
                        System.out.println("here");
                        input = input % 100;
                        temp = input;
                    } else {
                        temp = input;
                    }

                    if ((number - temp) < 0) {
                        number = 100 + (number - temp);
                        amountOfZeroReached++;
                        System.out.println("there");
                    } else {
                        number = number - temp;
                    }

                } else if (line.contains("R")) {
                    line = line.substring(1);
                    int input = Integer.parseInt(line);
                    System.out.println("(+) Right Input: " + input);

                    int temp = 0;
                    if (input > 99) {
                        amountOfZeroReached += input / 100;
                        System.out.println("here2");
                        input = input % 100;
                        temp = input;
                    } else {
                        temp = input;
                    }

                    if ((number + temp) > 99) {
                        amountOfZeroReached += (number + temp) / 100;
                        System.out.println("there2");
                        number = (number + temp) % 100;
                    } else {
                        number = number + temp;
                    }
                }
                System.out.println("New Number " + number);
                if (number == 0) {
                    System.out.println("JACKPOT ---- NUMBER 0 REACHED");
                    zeroCounter++;
                }
                System.out.println("----------");
            }
            System.out.println("End");
            System.out.println("ZeroCounter: " + zeroCounter);
            System.out.println("AmountOfZeroReached: " + amountOfZeroReached);
        } catch (IOException e) {
            // yallah
            System.out.println("error " + e);
        }

    }
}