package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class randomTeam {

    public static void generate(ArrayList<Character> team1, ArrayList<Character> team2) throws IOException {

        // Crear partidos completamente random
        // nº jugadores random entre 2 y 20

        System.out.println("Press any key to generate a random team");
        System.in.read();
        int numberOfRandomPlayers = (2 + (int) (Math.random() * ((20 - 2) + 1)));
        System.out.println("You are going to fight " + numberOfRandomPlayers + "vs. " + numberOfRandomPlayers + ". Press any key to continue. ");
        System.in.read();

        // ratio warrior:wizard aleatorio
        int classDice = (2 + (int) (Math.random() * ((2 - 1) + 1)));

        //* PENDIENTE CREAR CLASES DE TEAM PARA AÑADIR OBJETOS *\\
        // Add to Team 1
        // status randomizadas dentro de un rango
        for (int i = 0; i <= numberOfRandomPlayers; i++) {
            switch (classDice) {
                case 1:
                    // 1º Clase  - 2º Nombre - 3º HP - 4º Stamina/mana - 5º Fuerza/inteligencia
                    team1.add(new Warrior(i, "RandomName1", (50 + (int) (Math.random() * ((100 - 50) + 1))), (10 + (int) (Math.random() * ((50 - 10) + 1))), (1 + (int) (Math.random() * ((50 - 1) + 1)))));
                    break;
                case 2:
                    team1.add(new Wizard(i, "RandomName2", (100 + (int) (Math.random() * ((200 - 100) + 1))), (10 + (int) (Math.random() * ((50 - 10) + 1))), (1 + (int) (Math.random() * ((10 - 1) + 1)))));
                    break;
            }
        }
        // Add to Team 2
        for (int i = 0; i <= numberOfRandomPlayers; i++) {
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
