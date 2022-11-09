package com.ironhack;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterThreeRandom {

    public static void generate(ArrayList<Character> team1, ArrayList<Character> team2){

        int characters;

        var scan = new Scanner(System.in);
        var faker = new Faker();

        System.out.println("How many characters do you want for each team:");
        characters = scan.nextInt();
        scan.nextLine();
        System.out.println("\nNICE! You are going to fight "+characters+" vs "+characters+"\n");
        
        //CREATE TEAM 1
        System.out.println("TIME TO SET THE TEAM 1:");
        teamCreator(team1, characters, scan, faker);
        //CREATE TEAM 2
        EpicUtils.clearConsole();
        System.out.println("\n\nTIME TO SET THE TEAM 2:");
        teamCreator(team2, characters, scan, faker);
    }

    private static void teamCreator(ArrayList<Character> team, int characters, Scanner scan, Faker faker) {
        int character;
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
                //CHOSE WARRIOR OR WIZARD
                if (character == 1) {
                    threeRandomWarriors(scan, team, i, faker);
                    break;
                } else if (character == 2){
                    threeRandomWizards(scan, team, i, faker);
                    break;
                }
            }
        }
    }

    public static void threeRandomWarriors(Scanner scan, ArrayList<Character> team, int i, Faker faker){

        String selected = "test";
        String name1 = randomWarriorName(faker);
        String name2 = randomWarriorName(faker);
        String name3 = randomWarriorName(faker);
        if (name2.equals(name1)) {name2 += " Jr";}
        if (name3.equals(name1) || name3.equals(name2)) {
            name3 += " Jr";
            if (name3.equals(name2)) {name3 += " Jr";}
        }

        int stamina1 = 10 + (int)(Math.random() * ((50 - 10) + 1));
        int stamina2 = 10 + (int)(Math.random() * ((50 - 10) + 1));
        int stamina3 = 10 + (int)(Math.random() * ((50 - 10) + 1));

        int strength1 = 1 + (int)(Math.random() * ((10 - 1) + 1));
        int strength2 = 1 + (int)(Math.random() * ((10 - 1) + 1));
        int strength3 = 1 + (int)(Math.random() * ((10 - 1) + 1));

        int hp1 = 100 + (int)(Math.random() * ((200 - 100) + 1));
        int hp2 = 100 + (int)(Math.random() * ((200 - 100) + 1));
        int hp3 = 100 + (int)(Math.random() * ((200 - 100) + 1));

        System.out.println("You have to choose between these three warriors:\n");
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Name:", name1, name2, name3);
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Stamina:", stamina1, stamina2, stamina3);
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Strength:", strength1, strength2, strength3);
        System.out.printf("%-15s %-15s %-15s %-15s\n", "HP:", hp1, hp2, hp3);
        System.out.println("\nName of your chosen warrior:");
        selectRandom(scan, team, i, selected, name1, name2, name3, stamina1, stamina2, stamina3, strength1, strength2, strength3, hp1, hp2, hp3);
    }

    public static void threeRandomWizards(Scanner scan, ArrayList<Character> team, int i, Faker faker){

        String selected = "test";
        String name1 = randomWizardName(faker);
        String name2 = randomWizardName(faker);
        String name3 = randomWizardName(faker);
        if (name2.equals(name1)) {name2 += " Jr";}
        if (name3.equals(name1) || name3.equals(name2)) {
            name3 += " Jr";
            if (name3.equals(name2)) {name3 += " Jr";}
        }

        int mana1 = 10 + (int)(Math.random() * ((50 - 10) + 1));
        int mana2 = 10 + (int)(Math.random() * ((50 - 10) + 1));
        int mana3 = 10 + (int)(Math.random() * ((50 - 10) + 1));

        int intelligence1 = 1 + (int)(Math.random() * ((50 - 1) + 1));
        int intelligence2 = 1 + (int)(Math.random() * ((50 - 1) + 1));
        int intelligence3 = 1 + (int)(Math.random() * ((50 - 1) + 1));

        int hp1 = 50 + (int)(Math.random() * ((100 - 50) + 1));
        int hp2 = 50 + (int)(Math.random() * ((100 - 50) + 1));
        int hp3 = 50 + (int)(Math.random() * ((100 - 50) + 1));

        System.out.println("You have to choose between these three wizards:\n");
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Name:", name1, name2, name3);
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Mana:", mana1, mana2, mana3);
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Intelligence:", intelligence1, intelligence2, intelligence3);
        System.out.printf("%-15s %-15s %-15s %-15s\n", "HP:", hp1, hp2, hp3);
        System.out.println("\nName of your chosen wizard:");
        selectRandom(scan, team, i, selected, name1, name2, name3, mana1, mana2, mana3, intelligence1, intelligence2, intelligence3, hp1, hp2, hp3);
    }

    private static void selectRandom(Scanner scan, ArrayList<Character> team, int i, String selected, String name1, String name2, String name3, int manaSta1, int manaSta2, int manaSta3, int intelStr1, int intelStr2, int intelStr3, int hp1, int hp2, int hp3) {
        while (!selected.equals(name1) || !selected.equals(name2) || !selected.equals(name3)){
            selected = scan.nextLine();
            if (!selected.equals(name1) && !selected.equals(name2) && !selected.equals(name3)){
                System.out.println("Wrong name!");
            }
            if (selected.equals(name1)){
                team.add(new Wizard(i, name1, hp1, manaSta1, intelStr1));
                break;
            } else if (selected.equals(name2)){
                team.add(new Wizard(i, name2, hp2, manaSta2, intelStr2));
                break;
            } else if (selected.equals(name3)) {
                team.add(new Wizard(i, name3, hp3, manaSta3, intelStr3));
                break;
            }
        }
    }

    private static String randomWarriorName(Faker faker) {
        String name1 = faker.witcher().monster();
        if (name1.indexOf(" ") != -1) {
            name1 = name1.substring(0, name1.indexOf(" "));
        }
        return name1;
    }

    private static String randomWizardName(Faker faker) {
        String name1 = faker.witcher().witcher();
        if (name1.indexOf(" ") != -1) {
            name1 = name1.substring(0, name1.indexOf(" "));
        }
        return name1;
    }
}
