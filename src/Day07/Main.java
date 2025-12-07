package Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        URL path = Day07.Main.class.getResource("Input.txt");
        File f = new File(path.getFile());
        String previousLine = "";
        List<String> fullList = new ArrayList<>();
        int total = 0;
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                System.out.println("prev " + previousLine);
                char[] prevArray = previousLine.toCharArray();
                String line = scanner.nextLine();
                char[] lineArray = line.toCharArray();
                System.out.println("curr " + line);

                if (previousLine.contains("S")) {
                    int index = previousLine.indexOf("S");
                    lineArray[index] = '|';
                    line = String.valueOf(lineArray);
                } else if (!previousLine.isBlank()) {
                    for (int i = 0; i < lineArray.length; i++) {
                        if (lineArray[i] == '^' && prevArray[i] == '|') {
                            lineArray[i-1] = '|';
                            lineArray[i+1] = '|';
                            line = String.valueOf(lineArray);
                            total++;
                        } else if (prevArray[i] == '|') {
                            lineArray[i] = '|';
                            line = String.valueOf(lineArray);
                        }
                    }
                }

                previousLine = line;
                System.out.println("newp " + previousLine);
                fullList.add(previousLine);
                System.out.println();
            }
        }

        for (String s : fullList) {
            System.out.println(s);
        }
        System.out.println("\nTotal is " + total);
    }
}
