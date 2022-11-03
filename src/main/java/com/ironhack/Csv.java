package com.ironhack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Csv {

    public static void menuCsv(Scanner scanner, ArrayList<Character> team) throws FileNotFoundException {
        ArrayList<String> fileList = new ArrayList<>();
        boolean flag = false;
        String filename;
        do {
            System.out.println("Please put the name of CSV file:");
            filename = scanner.nextLine();
            try {
                File file = new File(filename);
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    fileList.add(reader.nextLine());
                }
                flag = true;

            } catch (Exception e) {
                System.out.println("File not found, try again...");
            }
        }while (flag == false);

        try {
            for (int i = 0; i < fileList.size(); i++) {
                String[] line = fileList.get(i).split(",");
                if (i != 0) {
                     if (line[0].equals("WA")) {
                         team.add(new Warrior(i + 1, line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                     } else {
                         team.add(new Wizard(i + 1, line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                     }
                    }
                }
        } catch (Exception e) {
            System.out.println("Error... Verify CSV file Format...");
        }

    }


}
