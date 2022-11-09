package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;


public class RandomTeam {

    public static void generate(ArrayList<Character> team1, ArrayList<Character> team2) throws IOException {

        // Crear partidos completamente random
        // nº jugadores random entre 2 y 10 (20 era too much)

        System.out.println("Press any key to generate a random team");
        System.in.read();
        int numberOfRandomPlayers = (2 + (int) (Math.random() * ((10 - 2) + 1)));
        System.out.println("You are going to fight " + numberOfRandomPlayers + " vs. " + numberOfRandomPlayers + ". Press any key to continue. ");
        System.in.read();
        for (int i = 0; i < numberOfRandomPlayers; i++) {
            int classDice = (1 + (int) (Math.random() * ((2 - 1) + 1)));
            switch (classDice) {
                case 1:
                    team1.add(new Warrior(i, "RandomName1", (50 + (int) (Math.random() * ((100 - 50) + 1))), (10 + (int) (Math.random() * ((50 - 10) + 1))), (1 + (int) (Math.random() * ((50 - 1) + 1)))));
                    break;
                case 2:
                    team1.add(new Wizard(i, "RandomName2", (100 + (int) (Math.random() * ((200 - 100) + 1))), (10 + (int) (Math.random() * ((50 - 10) + 1))), (1 + (int) (Math.random() * ((10 - 1) + 1)))));
                    break;
            }
        }
        // Add to Team 2
        for (int i = 0; i < numberOfRandomPlayers; i++) {
            int classDice = (1 + (int) (Math.random() * ((2 - 1) + 1)));
            switch (classDice) {
                case 1:
                    team2.add(new Warrior(i, "RandomName1", (50 + (int) (Math.random() * ((100 - 50) + 1))), (10 + (int) (Math.random() * ((50 - 10) + 1))), (1 + (int) (Math.random() * ((50 - 1) + 1)))));
                    break;
                case 2:
                    team2.add(new Wizard(i, "RandomName2", (100 + (int) (Math.random() * ((200 - 100) + 1))), (10 + (int) (Math.random() * ((50 - 10) + 1))), (1 + (int) (Math.random() * ((10 - 1) + 1)))));
                    break;
            }
        }
    }
}