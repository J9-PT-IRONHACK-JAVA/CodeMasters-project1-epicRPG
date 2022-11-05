package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
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

            // Cambiarle el loop para que ataque hasta que quede en 0 el HP de TODOS
            while (sumHp(team1) != 0 && sumHp(team2) != 0){
                System.out.println("Team 1 select character:");
                // imprimir lista character VIVOS y opcion a elegir
                op1 = scanner.nextInt();
                System.out.println("Team 2 select character:");
                op2 = scanner.nextInt();
                int round=1;

                // While los 2 hps sean mayor a 0
                while (team1.get(op1-1).getHp() > 0 && team2.get(op1-1).getHp() >0){
                    System.out.println("Round Nº: "+round);
                    figth(team1.get(op1-1),team2.get(op2-1));
                    listCharacters(team1);
                    listCharacters(team2);
                    round+=1;
                    System.out.println("Press enter to continue...");
                    System.in.read();
                }

                // Verificar si quedaron en menos de 1 de HP, mandarlos al cementerio
                if(team1.get(op1-1).getHp() < 1){
                    cemetery.add(team1.get(op1-1));
                }
                if(team2.get(op1-1).getHp() < 1){
                    cemetery.add(team2.get(op1-1));
                }
            }

        }
        listCharacters(cemetery);
        return cemetery;
    }


    private static void listCharacters(ArrayList<Character> team){
        Character character;
        for (int i = 0; i < team.size(); i++) {
            character = team.get(i);
            if(character instanceof Warrior) {
            System.out.println(
                                (i+1) + " - " +
                                "Warrior - " +
                                character.getName() + " - " +
                                "HP: " + character.getHp() + " - " +
                                "Stamina: "+((Warrior)character).getStamina()+ " - " +
                                "Strength: "+((Warrior)character).getStrength()
                );
            }else{
                System.out.println(
                                (i+1) + " - " + "Wizard - " +
                                character.getName() + " - " +
                                "HP: " + character.getHp() + " - " +
                                "Mana: "+((Wizard)character).getMana()+ " - "+
                                "Intelligence: "+((Wizard)character).getIntelligence()
                );

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
