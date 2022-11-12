package com.ironhack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

        // DESDE AQUI EL SAVE TO CSV!
    public static void saveToCsv(ArrayList<Character> team1,ArrayList<Character> team2) throws IOException {

        var fileWritterTeam1 = new FileWriter("team1.csv");
        var fileWritterTeam2 = new FileWriter("team2.csv");
        fileWritterTeam1.write("-== TEAM 1 ==-\n");
        fileWritterTeam2.write("-== TEAM 2 ==-\n");


        for (int i = 0; i < team1.size(); i++) {
            var character = team1.get(i);
            if(character instanceof Warrior){
                fileWritterTeam1.write(((Warrior)character).toCsv());
            }else{
                fileWritterTeam1.write(((Wizard)character).toCsv());
            }
        }
        for (int i = 0; i < team2.size(); i++) {
            var character = team2.get(i);
            if(character instanceof Warrior){
                fileWritterTeam2.write(((Warrior)character).toCsv());
            }else{
                fileWritterTeam2.write(((Wizard)character).toCsv());
            }
        }
        fileWritterTeam1.close();
        fileWritterTeam2.close();
    }
}
