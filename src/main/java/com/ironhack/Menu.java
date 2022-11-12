package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {

    private static Scanner scanner = new Scanner(System.in); //Scanner

    public static void run(ArrayList<Character> team1, ArrayList<Character> team2, ArrayList<Character> graveYard) throws IOException, InterruptedException {

        int option =0;

        while (option!=6){
            EpicUtils.clearConsole();
            System.out.println("Welcome to EPIC RPG!");
            System.out.println("Select option:");
            System.out.println("1) Create manual characters.");
            System.out.println("2) Choose between 3 random characters.");
            System.out.println("3) Create a random team.");
            System.out.println("4) Import CSV.");
            System.out.println("5) Print the graveyard.");
            System.out.println("6) Exit.");

            try{
                option = Integer.parseInt(scanner.next());
            }
            catch (Exception e){
                option = 0;
            }
            switch (option) {
                case 0: {
                    EpicUtils.clearConsole();
                    System.out.println("Error!! Only NUMBERS please...");
                    System.out.println("Press ENTER to continue...");
                    System.out.println("*********************************");
                    System.in.read();
                    break;
                }
                case 1: {
                    EpicUtils.clearConsole();
                    System.out.println("Create Manual Characters....");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    CharacterCreator.generate(team1, team2);
                    Csv.saveToCsv(team1,team2);
                    break;
                }
                case 2: {
                    EpicUtils.clearConsole();
                    System.out.println("Chose between 3 random generated characters....");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    CharacterThreeRandom.generate(team1, team2);
                    Csv.saveToCsv(team1,team2);
                    break;
                }
                case 3: {
                    EpicUtils.clearConsole();
                    System.out.println("Create a random teams.....");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    RandomTeam.generate(team1, team2);
                    Csv.saveToCsv(team1,team2);
                    break;
                }
                case 4: {
                    EpicUtils.clearConsole();
                    System.out.println("Import teams from a CSV file.");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    System.out.println("Import the Team 1...");
                    Csv.menuCsv(scanner, team1);
                    System.out.println("Import the Team 2...");
                    Csv.menuCsv(scanner, team2);
                    break;
                }
                case 5: {
                    EpicUtils.clearConsole();
                    Battle.printCemetery(graveYard);
                    break;
                }
                case 6: {
                    EpicUtils.clearConsole();
                    System.out.println("Thanks for play!");
                    System.out.println("--==EPIC RPG==--");
                    scanner.close();
                    System.exit(0);
                }
                default: {
                    EpicUtils.clearConsole();
                    System.out.println("Option Error! Select a correct option...");
                    System.out.println("Press ENTER to continue...");
                    System.out.println("*********************************");
                    System.in.read();
                    break;

                }
            }
            if (option == 1 | option == 2 | option == 3 | option == 4) {
                int chose;

                EpicUtils.clearConsole();
                System.out.println("1) Normal battle.");
                System.out.println("2) Simulated battle.");
                do {
                    try {
                        chose = Integer.parseInt(scanner.next());
                    } catch (Exception e) {
                        chose = 0;
                    }
                } while (chose != 1 && chose != 2);
                if (chose == 1) {
                    Battle.battle(team1, team2, scanner, graveYard);
                } else {
                    LazyBattle.lazyBattle(team1, team2, scanner, graveYard);
                }
            }
        }
    }
}
