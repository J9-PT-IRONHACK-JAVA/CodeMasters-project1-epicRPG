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
        if (team1.size()!=team2.size()){
            System.out.println("Team number of Characters of teams must be equal");
        }else{
            System.out.println("TEAM 1:");
            listCharacters(team1);
            System.out.println("*******");
            System.out.println("TEAM 2:");
            listCharacters(team2);
            System.out.println("************");
            System.out.println("Press ENTER to start the war!");
            System.in.read();
            EpicUtils.clearConsole();

            while (sumHp(team1) > 0 && sumHp(team2) > 0){
                EpicUtils.clearConsole();
                System.out.println("Team 1 select character:");
                listCharacters(team1);
                op1 = scanner.nextInt();
                System.out.println("Team 2 select character:");
                listCharacters(team2);
                op2 = scanner.nextInt();
                // Set round Nº 1
                int round=1;
                var figther1=team1.get(op1-1);
                var figther2=team2.get(op2-1);

                // While los 2 hps sean mayor a 0
                while (figther1.getHp() > 0 && figther2.getHp() > 0){
                    EpicUtils.clearConsole();
                    System.out.println("Round Nº: "+round);
                    listCharacters(new ArrayList<>(List.of(figther1)));
                    System.out.println("VS");
                    listCharacters(new ArrayList<>(List.of(figther2)));

                    System.out.println("Press enter to battle...");
                    System.in.read();

                    figth(figther1,figther2);

                    round+=1;
                }
                System.out.println("End of Battle...");

                if(team1.get(op1-1).isAlive()==false){
                    System.out.println("Fighter of team1 dead...");
                    if(figther1 instanceof Warrior){
                        graveYard.add(new Warrior(round, figther1.getName(), 1, ((Warrior) figther1).getStamina(), ((Warrior) figther1).getStrength()));
                    }else{
                        graveYard.add(new Wizard(round, figther1.getName(), 1,((Wizard) figther1).getMana(),((Wizard) figther1).getIntelligence()));
                    }

                }
                if(team2.get(op2-1).isAlive()==false){
                    System.out.println("Fighter of team2 dead...");
                    if(figther2 instanceof Warrior){
                        graveYard.add(new Warrior(round, figther2.getName(), 2, ((Warrior) figther2).getStamina(), ((Warrior) figther2).getStrength()));
                    }else{
                        graveYard.add(new Wizard(round, figther2.getName(), 2,((Wizard) figther2).getMana(),((Wizard) figther2).getIntelligence()));
                    }
                }
            }
        }
        System.out.println("**** END OF WAR ****");
        System.out.println("Press ENTER to continue.");
        System.in.read();
    }


    private static void listCharacters(ArrayList<Character> team){
        Character character;
        for (int i = 0; i < team.size(); i++) {
            character = team.get(i);
            if (team.get(i).isAlive()==true) {
                if (character instanceof Warrior) {
                    String warrior =
                            (i + 1) + ") - " +
                                    "Warrior - " +
                                    character.getName() + " - " +
                                    "HP: " + character.getHp() + " - " +
                                    "Stamina: " + ((Warrior) character).getStamina() + " - " +
                                    "Strength: " + ((Warrior) character).getStrength();

                    System.out.println(warrior);
                } else {
                    String wizard =
                            (i + 1) + ") - " +
                                    "Wizard - " +
                                    character.getName() + " - " +
                                    "HP: " + character.getHp() + " - " +
                                    "Mana: " + ((Wizard) character).getMana() + " - " +
                                    "Intelligence: " + ((Wizard) character).getIntelligence();
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
    public static void printCemetery(ArrayList<Character> team){
        Character character;
        for (int i = 0; i < team.size(); i++) {
            character = team.get(i);
            if (character instanceof Warrior) {
                String warrior =
                                (i + 1) + ") † " +
                                "Warrior - " +
                                character.getName() + " - " +
                                "From team Nº: " + character.getHp();
                System.out.println(warrior);
            } else {
                String wizard =
                                (i + 1) + ") † " +
                                "Wizard - " +
                                character.getName() + " - " +
                                "From team Nº: " + character.getHp();
                System.out.println(wizard);
            }
        }
    }
}
