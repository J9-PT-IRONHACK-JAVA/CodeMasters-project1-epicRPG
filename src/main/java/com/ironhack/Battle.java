package com.ironhack;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {

    private static ArrayList<Character> cemetery;


    public static ArrayList<Character> battle(ArrayList<Character> team1, ArrayList<Character> team2, Scanner scanner) {
        int op1;
        int op2;
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

                // Ejecutar metodo de pelea!
                figth(team1.get(op1-1),team2.get(op2-1));
                // Imprimimos de nuevo los caracteres
                listCharacters(team1);
                listCharacters(team2);

                // Verificar si quedaron en menos de 1 de HP, mandarlos al cementerio
                if(team1.get(op1-1).getHp() < 1){
                    cemetery.add(team1.get(op1-1));
                }
                if(team2.get(op1-1).getHp() < 1){
                    cemetery.add(team2.get(op1-1));
                }
            }

        }
        return cemetery;
    }


    private static void listCharacters(ArrayList<Character> team){
        Character character;
        for (int i = 0; i < team.size(); i++) {
            if(team.get(i).getClass().getName().equals("com.ironhack.Warrior")){
                character = (Warrior)team.get(i);
            }else{
                character = (Wizard)team.get(i);
            }
            if(character.getClass().getName().equals("com.ironhack.Warrior")) {
                System.out.println(
                                (i+1) + " - " +
                                character.getClass().getName() + " - " +
                                character.getName() + " - " +
                                "HP: " + character.getHp() + " - " +
                                "Stamina: "+((Warrior)character).getStamina()+ " - " +
                                "Strength: "+((Warrior)character).getStrength()
                );
            }else{
                System.out.println(
                                (i+1) + " - " +
                                character.getClass().getName() + " - " +
                                character.getName() + " - " +
                                "HP: " + character.getHp() + " - " +
                                "Stamina: "+((Wizard)character).getMana()+ " - "+
                                "Strength: "+((Wizard)character).getIntelligence()
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
        String char1Type;
        String char2Type;
        if (char1.getClass().getName().equals("com.ironhack.Warrior")){
            char1 = ((Warrior)char1);
        }else{
            char1 = ((Wizard)char1);
        }
        if (char2.getClass().getName().equals("com.ironhack.Warrior")){
            char2 = ((Warrior)char2);
        }else{
            char2 = ((Wizard)char2);
        }

        //char1.setHp(char1.getHp()-((Attacker) char2).attack());
        //char2.setHp(char2.getHp()-((Attacker) char1).attack());

    }




    public ArrayList<Character> getCemetery() {
        return cemetery;
    }

    public void setCemetery(ArrayList<Character> cemetery) {
        this.cemetery = cemetery;
    }
}
