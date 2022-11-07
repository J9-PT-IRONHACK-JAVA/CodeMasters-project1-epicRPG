package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battle {

    public static ArrayList<Character> battle(ArrayList<Character> team1, ArrayList<Character> team2, Scanner scanner) throws IOException {
        int op1;
        int op2;
        var cemetery = new ArrayList<Character>();

        // Verificamos que la cantidad de caracteres del primer team sea igual a la cantidad del 2do
        //Caso contrario se retorna null
        if (team1.size()!=team2.size()){
            System.out.println("Team number of Characters of teams must be equal");
            return null;
        }else{
            System.out.println("TEAM 1:");
            listCharacters(team1);
            System.out.println("*******");
            System.out.println("TEAM 2:");
            listCharacters(team2);
            System.out.println("************");
            System.out.println("Start battle!");

            while (sumHp(team1) != 0 && sumHp(team2) != 0){
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
                while (figther1.getHp() != 0 && figther2.getHp() != 0){
                    System.out.println("Round Nº: "+round);
                    listCharacters(new ArrayList<Character>(List.of(figther1)));
                    System.out.println("VS");
                    listCharacters(new ArrayList<Character>(List.of(figther2)));

                    figth(figther1,figther2);

                    round+=1;
                    System.out.println("Press enter to continue...");
                    System.in.read();
                }
                System.out.println("End of Battle...");
                int i=1;
                if(figther1.getHp() < 1){
                    System.out.println("Fighter of team1 dead...");
                    cemetery.add(figther1);
                }
                if(figther2.getHp() < 1){
                    System.out.println("Fighter of team2 dead...");
                    cemetery.add(figther2);
                }
            }

        }
        System.out.println("Cemetery:");
        listCharacters(team1);
        System.out.println("Press enter to continue...");
        System.in.read();
        return cemetery;
    }


    private static void listCharacters(ArrayList<Character> team){
        Character character;
        for (int i = 0; i < team.size(); i++) {
            character = team.get(i);
            if (team.get(i).getHp()>0) {
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
        char1.setHp(char1.getHp()-((Attacker) char2).attack());
        char2.setHp(char2.getHp()-((Attacker) char1).attack());
    }

}
