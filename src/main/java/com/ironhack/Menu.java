package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {

    private static Scanner scanner = new Scanner(System.in); //Scanner

    public static void run(ArrayList<Character> team1, ArrayList<Character> team2) throws IOException, InterruptedException {

        int option =0;

        while (option!=5){
            EpicUtils.clearConsole();
            System.out.println("Welcome to EPIC RPG!");
            System.out.println("Select option:");
            System.out.println("1) Create manual characters.");
            System.out.println("2) Chose between 3 random characters.");
            System.out.println("3) Create random teams.");
            System.out.println("4) Import CSV.");
            System.out.println("5) Exit.");

            try{
                option = Integer.parseInt(scanner.nextLine());
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
                    System.out.println("\nCreate Manual Characters....");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    CharacterCreator.generate(team1, team2);
                    Battle.battle(team1, team2, scanner);
                    break;
                }
                case 2: {
                    EpicUtils.clearConsole();
                    System.out.println("\nChose between 3 random generated characters....");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    CharacterThreeRandom.generate(team1, team2);
                    EpicUtils.loadingBar();
                    Battle.battle(team1,team2,scanner);
                    return;

                }
                case 3: {
                    EpicUtils.clearConsole();
                    System.out.println("\nCreate a random teams.....");
                    System.out.println("Press ENTER to continue...");
                    RandomTeam.generate(team1,team2);
                    System.in.read();
                    return;

                }
                case 4: {
                    EpicUtils.clearConsole();
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    Csv.menuCsv(scanner,team1);
                    Csv.menuCsv(scanner,team2);
                    break;
                }
                case -1: {
                    EpicUtils.clearConsole();
                    System.out.println("Thanks for play!");
                    System.out.println("--==EPIC RPG==--");
                    scanner.close();
                    System.exit(-1);

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
        }
    }
}
