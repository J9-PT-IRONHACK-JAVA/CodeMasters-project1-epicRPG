package com.ironhack;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterThreeRandom {

    public static void menu(ArrayList<Character> team1, ArrayList<Character> team2){

        int character;
        int characters;

        var scan = new Scanner(System.in);

        System.out.println("How many characters do you want for each team:");
        characters = scan.nextInt();
        scan.nextLine();
        System.out.println("\nNICE! You are going to fight "+characters+" vs "+characters+"\n");
        System.out.println("TIME TO SET THE TEAM 1:");
        for (int i = 0; i < characters; i++) {
            System.out.println("\nCHARACTER " + (i+1) + "\n");
            Banners.warriorWizard();
            System.out.println(" 1. com.ironhack.Warrior or 2. com.ironhack.Wizard?");
            character = 0;
            while (character != 1 || character != 2) {
                character = scan.nextInt();
                scan.nextLine();
                if (character != 1 && character != 2){
                    System.out.println("Bad input! Write 1 or 2 and press intro.");
                }
                if (character == 1) {
                    threeRandomWarriors(scan, team1, i);
                    break;
                } else if (character == 2){
                    threeRandomWizards(scan, team1, i);
                    break;
                }
            }
        }
        System.out.println("\n\nTIME TO SET THE TEAM 2:");
        for (int i = 0; i < characters; i++) {
            Banners.warriorWizard();
            System.out.println("\nCHARACTER "+(i+1)+".\n 1. com.ironhack.Warrior or 2. com.ironhack.Wizard?");
            character = 0;
            while (character != 1 || character != 2) {
                character = scan.nextInt();
                scan.nextLine();
                if (character != 1 && character != 2){
                    System.out.println("Bad input! Write 1 or 2 and press intro.");
                }
                if (character == 1) {
                    threeRandomWarriors(scan, team2, i);
                    break;
                } else if (character == 2){
                    threeRandomWizards(scan, team2, i);
                    break;
                }
            }
        }
    }

    public static void threeRandomWarriors(Scanner scan, ArrayList<Character> team, int i){

        String selected = "test";
        String[] namesList = {"Federico", "Patricia", "Andres", "Drina", "Ivan", "Valerio"};
        String name1 = namesList[0 + (int)(Math.random() * ((5 - 0) + 1))];
        String name2 = namesList[0 + (int)(Math.random() * ((5 - 0) + 1))];
        String name3 = namesList[0 + (int)(Math.random() * ((5 - 0) + 1))];

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
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Name:", name1, name2, name3);
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Stamina:", stamina1, stamina2, stamina3);
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Strength:", strength1, strength2, strength3);
        System.out.printf("%-10s %-10s %-10s %-10s\n", "HP:", hp1, hp2, hp3);
        System.out.println("\nName of your chosen warrior:");
        while (!selected.equals(name1) || !selected.equals(name2) || !selected.equals(name3)){
            selected = scan.nextLine();
            if (!selected.equals(name1) && !selected.equals(name2) && !selected.equals(name3)){
                System.out.println("Wrong name!");
            }
            if (selected.equals(name1)){
                team.add(new Warrior(i, name1, hp1, stamina1, strength1));
                break;
            } else if (selected.equals(name2)){
                team.add(new Warrior(i, name2, hp2, stamina2, strength2));
                break;
            } else if (selected.equals(name3)) {
                team.add(new Warrior(i, name3, hp3, stamina3, strength3));
                break;
            }
        }
    }

    public static void threeRandomWizards(Scanner scan, ArrayList<Character> team, int i){

        String selected = "test";
        String[] namesList = {"Federico", "Patricia", "Andres", "Drina", "Ivan", "Valerio"};
        String name1 = namesList[0 + (int)(Math.random() * ((5 - 0) + 1))];
        String name2 = namesList[0 + (int)(Math.random() * ((5 - 0) + 1))];
        String name3 = namesList[0 + (int)(Math.random() * ((5 - 0) + 1))];

        int mana1 = 10 + (int)(Math.random() * ((50 - 10) + 1));
        int mana2 = 10 + (int)(Math.random() * ((50 - 10) + 1));
        int mana3 = 10 + (int)(Math.random() * ((50 - 10) + 1));

        int intelligence1 = 1 + (int)(Math.random() * ((50 - 1) + 1));
        int intelligence2 = 1 + (int)(Math.random() * ((50 - 1) + 1));
        int intelligence3 = 1 + (int)(Math.random() * ((50 - 1) + 1));

        int hp1 = 100 + (int)(Math.random() * ((200 - 100) + 1));
        int hp2 = 100 + (int)(Math.random() * ((200 - 100) + 1));
        int hp3 = 100 + (int)(Math.random() * ((200 - 100) + 1));

        System.out.println("You have to choose between these three wizards:\n");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Name:", name1, name2, name3);
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Mana:", mana1, mana2, mana3);
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Intelligence:", intelligence1, intelligence2, intelligence3);
        System.out.printf("%-15s %-10s %-10s %-10s\n", "HP:", hp1, hp2, hp3);
        System.out.println("\nName of your chosen wizard:");
        while (!selected.equals(name1) || !selected.equals(name2) || !selected.equals(name3)){
            selected = scan.nextLine();
            if (!selected.equals(name1) && !selected.equals(name2) && !selected.equals(name3)){
                System.out.println("Wrong name!");
            }
            if (selected.equals(name1)){
                team.add(new Wizard(i, name1, hp1, mana1, intelligence1));
                break;
            } else if (selected.equals(name2)){
                team.add(new Wizard(i, name2, hp2, mana2, intelligence2));
                break;
            } else if (selected.equals(name3)) {
                team.add(new Wizard(i, name3, hp3, mana3, intelligence2));
                break;
            }
        }
    }
}