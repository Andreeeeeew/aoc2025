package Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        URL path = Main.class.getResource("Input.txt");
        File f = new File(path.getFile());
        List<List<Integer>> formatted = new ArrayList<>();
        String[] plusOrSum = new String[0];
        long total = 0;
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("   ", " ");
                line = line.replace("  ", " ");
                System.out.println(line);

                String[] ranges = line.split(" ");
                List<Integer> list = new ArrayList<>();

                if (line.contains("*")) {
                    plusOrSum = ranges;
                    break;
                }

                for (String s : ranges) {
                    if (!(s.isBlank())) {
                        System.out.println(s);
                        list.add(Integer.parseInt(s));
                    }
                }

                formatted.add(list);
            }

            System.out.println("lenght " + formatted.size());

            int lengthOfList = 0;
            for (List<Integer> intlist : formatted) {
                System.out.println(intlist);
                lengthOfList = intlist.size();
            }
            System.out.println("size of list " + lengthOfList);

            for (int i = 0; i <= lengthOfList - 1; i++) {
                int first = formatted.get(0).get(i);
                int second = formatted.get(1).get(i);
                int third = formatted.get(2).get(i);
                int fourth = formatted.get(3).get(i);
                String operation = plusOrSum[i];

                System.out.println("first " + first + " second " + second + " third " + third + " fourth " + fourth + " op " + operation);

                if (operation.equals("*")) {
                    total += (long) first * second * third * fourth;
                } else if (operation.equals("+")) {
                    total += first + second + third + fourth;
                }
            }

            System.out.println("TotALATLAL A : " + total);

        }
    }
}
