package Day01;

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
        try(Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("L")) {
                    line = line.substring(1);
                    int input = Integer.parseInt(line);
                    System.out.println("Left INT " + input);

                    int temp = (input - number);
                    System.out.println(temp);
                    if (temp >= 99) {
                        number = temp % 99;
                    } else if (temp <= 0) {
                        number = (-1) * temp;
                    } else {
                        number = 99 - temp + 1;
                    }

                    System.out.println("new number " + number);

                } else if (line.contains("R")) {
                    line = line.substring(1);
                    int input = Integer.parseInt(line);
                    System.out.println("Right INT " + input);


                    int temp = input + number;
                    System.out.println(temp);
                    if (temp >= 99) {
                        number = temp % 99 - 1;
                    } else if (temp <= 0) {
                        number = (-1) * temp;
                    } else {
                        number = temp;
                    }

                    System.out.println("new numebr " + number);
                }
                if (number == 0) {
                    System.out.println("JACKPOT ---- NUMBER 0 REACHED");
                    zeroCounter++;
                }
                System.out.println("----------");
            }
            System.out.println("End");
            System.out.println("ZeroCounter: " + zeroCounter);
        } catch (IOException e) {
            // yallah
            System.out.println("error " + e);
        }

    }
}
