package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battle {

    public static void battle(ArrayList<Character> team1, ArrayList<Character> team2, Scanner scanner, ArrayList<Character> graveYard) throws IOException, InterruptedException {
        int op1;
        int op2;

        EpicUtils.loadingBar();
        Banners.swords();
        if (team1.size()!=team2.size()){
            System.out.println("Team number of Characters of teams must be equal");
        }else{
            System.out.println("TEAM 1:");
            listCharacters(team1,false);
            System.out.println("*******");
            System.out.println("TEAM 2:");
            listCharacters(team2,false);
            System.out.println("************");
            System.out.println("\u001B[41m Press ENTER to start the war!\u001B[0m");
            System.in.read();
            EpicUtils.clearConsole();

            while (sumHp(team1) > 0 && sumHp(team2) > 0){
                EpicUtils.clearConsole();
                System.out.println("Team 1 select character:");
                listCharacters(team1,true);
                op1 = scanner.nextInt();
                System.out.println("Team 2 select character:");
                listCharacters(team2,true);
                op2 = scanner.nextInt();
                // Set round Nº 1
                int round=1;
                var figther1=team1.get(op1-1);
                var figther2=team2.get(op2-1);

                // While los 2 hps sean mayor a 0
                while (figther1.getHp() > 0 && figther2.getHp() > 0){
                    EpicUtils.clearConsole();
                    System.out.println("Round Nº: "+round);
                    listCharacters(new ArrayList<>(List.of(figther1)),false);
                    System.out.println("\t\tVS");
                    listCharacters(new ArrayList<>(List.of(figther2)),false);

                    System.out.println("\u001B[33m Press enter to figth! \u001B[0m");
                    System.in.read();

                    figth(figther1,figther2);

                    round+=1;
                }
                System.out.println("End of Battle...");

                if(team1.get(op1-1).isAlive()==false){
                    System.out.println("Fighter of Team1 dead \u001B[47m\u001B[30m†\u001B[0m \u001B[31m" + figther1.getName()+"\u001B[0m");
                    System.out.println("Killed by \u001B[34m"+figther2.getName()+"\u001B[0m");
                    if(figther1 instanceof Warrior){
                        graveYard.add(new Warrior(round, figther1.getName(), 1, ((Warrior) figther1).getStamina(), ((Warrior) figther1).getStrength()));
                    }else{
                        graveYard.add(new Wizard(round, figther1.getName(), 1,((Wizard) figther1).getMana(),((Wizard) figther1).getIntelligence()));
                    }

                }
                if(team2.get(op2-1).isAlive()==false){
                    System.out.println("Fighter of Team2 dead \u001B[47m\u001B[30m†\u001B[0m \u001B[31m" + figther2.getName()+"\u001B[0m");
                    System.out.println("Killed by \u001B[34m"+figther1.getName()+"\u001B[0m");
                    if(figther2 instanceof Warrior){
                        graveYard.add(new Warrior(round, figther2.getName(), 2, ((Warrior) figther2).getStamina(), ((Warrior) figther2).getStrength()));
                    }else{
                        graveYard.add(new Wizard(round, figther2.getName(), 2,((Wizard) figther2).getMana(),((Wizard) figther2).getIntelligence()));
                    }
                }
                System.out.println("Press ENTER to continue.");
                System.in.read();
            }
        }
        System.out.println("\n \u001B[43m**** END OF WAR ****\u001B[0m");
        if(sumHp(team1) > 0){
            System.out.println("\n \u001B[31m-== TEAM 1 WIN ==-\u001B[0m");
        }else if(sumHp(team2) > 0){
            System.out.println("\n \u001B[31m-== TEAM 2 WIN ==-\u001B[0m");
        }else{
            System.out.println("\n \u001B[31m-== TIE ==-\u001B[0m");
        }

        System.out.println("Press ENTER to continue.");
        System.in.read();
        team1.clear();
        team2.clear();
    }


    private static void listCharacters(ArrayList<Character> team, boolean printNumber){
        Character character;
        for (int i = 0; i < team.size(); i++) {
            character = team.get(i);
            if (team.get(i).isAlive()==true) {
                if (character instanceof Warrior) {
                    String warrior =
                            (i + 1) + ") " +
                                    "Warrior - " +
                                    character.getName() + " - " +
                                    "HP: " + character.getHp() + " - " +
                                    "Stamina: " + ((Warrior) character).getStamina() + " - " +
                                    "Strength: " + ((Warrior) character).getStrength();
                    if (!printNumber){
                        warrior = warrior.substring(3);
                    }
                    System.out.println(warrior);
                } else {
                    String wizard =
                            (i + 1) + ") " +
                                    "Wizard - " +
                                    character.getName() + " - " +
                                    "HP: " + character.getHp() + " - " +
                                    "Mana: " + ((Wizard) character).getMana() + " - " +
                                    "Intelligence: " + ((Wizard) character).getIntelligence();
                    if (!printNumber){
                        wizard = wizard.substring(3);
                    }
                    System.out.println(wizard);
                }
            }
        }
    }

    public static int sumHp(ArrayList<Character> team){
        int hp=0;
        for (int i = 0; i < team.size(); i++) {
            hp+=team.get(i).getHp();
        }
        return hp;
    }

    public static void figth(Character char1, Character char2){
        char1.receiveAttack(((Attacker)char2).attack());
        char2.receiveAttack(((Attacker)char1).attack());
    }
    public static void printCemetery(ArrayList<Character> team) throws InterruptedException, IOException {
        Character character;
        if (team.isEmpty()) {
            System.out.println("Graveyard is empty... yet.");
            Thread.sleep(3000);
            return;
        }
        Banners.graveyard();
        for (int i = 0; i < team.size(); i++) {
            character = team.get(i);
            if (character instanceof Warrior) {
                String warrior =
                                (i + 1) + ") † " +
                                "Warrior - " +
                                character.getName();// + " - " +
                                //"From team Nº: " + character.getHp();
                System.out.println(warrior);
            } else {
                String wizard =
                                (i + 1) + ") † " +
                                "Wizard - " +
                                character.getName(); // + " - " +
                                //"From team Nº: " + character.getHp();
                System.out.println(wizard);
            }
        }
        System.out.println("\nPress ENTER to continue...");
        System.in.read();
    }
}
