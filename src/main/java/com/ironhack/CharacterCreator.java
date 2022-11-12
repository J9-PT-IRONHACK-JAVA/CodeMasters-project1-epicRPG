package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterCreator {

    public static void generate(ArrayList<Character> team1, ArrayList<Character> team2) throws InterruptedException, IOException {

        int characters;

        var scan = new Scanner(System.in);

        System.out.println("How many characters do you want for each team (MAX 10):");
        do {
            try {
                characters = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                characters = 0;
            }
            if (characters < 1 || characters > 10){
                System.out.println("Wrong input!");
            }
        } while (characters < 1 || characters > 20);
        System.out.println("\nNICE! You are going to fight " + characters + " vs " + characters + "\n");
        System.out.println("TIME TO SET THE TEAM 1:");
        System.out.println("\nPress ENTER to continue...");
        System.in.read();
        temCreator(characters, scan, team1);
        EpicUtils.clearConsole();
        System.out.println("IME TO SET THE TEAM 2:");
        System.out.println("\nPress ENTER to continue...");
        System.in.read();
        temCreator(characters, scan, team2);
    }

    private static void temCreator(int characters, Scanner scan, ArrayList<Character> team1) {
        int character = 0;
        for (int i = 0; i < characters; i++) {
            EpicUtils.clearConsole();
            System.out.println("CHARACTER " + (i+1) + "\n");
            Banners.warriorWizard();
            System.out.println(" 1. Warrior or 2. Wizard?");
            character = 0;
            while (character != 1 || character != 2) {
                character = scan.nextInt();
                scan.nextLine();
                if (character != 1 && character != 2){
                    System.out.println("Bad input! Write 1 or 2 and press intro.");
                }
                if (character == 1) {
                    EpicUtils.clearConsole();
                    Banners.warrior();
                    warriorCreator(scan, team1, i);
                    break;
                } else if (character == 2){
                    EpicUtils.clearConsole();
                    Banners.wizard();
                    wizardCreator(scan, team1, i);
                    break;
                }
            }
        }
    }

    private static void warriorCreator(Scanner scan, ArrayList<Character> team, int i) {

        String name;
        int stamina;
        int strength;
        int hp;

        System.out.println("\nName for the Warrior:");
        name = scan.nextLine();
        System.out.println("\nSet the HP between 100 and 200:");
        hp = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the stamina between 10 and 50:");
        stamina = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the strength between 1 and 10:");
        strength = scan.nextInt();
        scan.nextLine();
        team.add(new Warrior(i, name, hp, stamina, strength));
    }

    private static void wizardCreator(Scanner scan, ArrayList<Character> team1, int i) {

        String name;
        int mana;
        int intelligence;
        int hp;

        System.out.println("\nName for the Wizard:");
        name = scan.nextLine();
        System.out.println("\nSet the HP between 50 and 100:");
        hp = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the mana between 10 and 50:");
        mana = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the intelligence between 1 and 50:");
        intelligence = scan.nextInt();
        scan.nextLine();
        team1.add(new Wizard(i, name, hp, mana, intelligence));
    }
}
