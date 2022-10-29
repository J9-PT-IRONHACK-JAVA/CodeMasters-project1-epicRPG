import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class randomTeam {

    public static void generate() throws IOException {

        // Crear partidos completamente random
        // nº jugadores random entre 2 y 20

        System.out.println("Press any key to generate a random team");
        System.in.read();
        int numberOfRandomPlayers = (2 + (int) (Math.random() * ((20 - 2) + 1)));
        System.out.println("You are going to fight " + numberOfRandomPlayers + "vs. " + numberOfRandomPlayers+". Press any key to continue. ");
        System.in.read();

        // ratio warrior:wizard aleatorio
        int classDice = (2 + (int) (Math.random() * ((2 - 1) + 1)));
        ArrayList team1 = new ArrayList();
        ArrayList team2 = new ArrayList();

        // 1º clase  - 2º nombre - 3º hp - 4º stamia/mana - 5º fuerza/inteligencia
        // Add to Team 1
        for(int i=0;i<=numberOfRandomPlayers;i++){
            switch (classDice){
                case 1:
                    team1.add("Wizard","RandomName1",(50 + (int) (Math.random() * ((100 - 50) + 1))),(10 + (int) (Math.random() * ((50 - 10) + 1))),(1 + (int) (Math.random() * ((50 - 1) + 1)));
                    break;
                case 2:
                    team1.add("Warrior","RandomName2",(100 + (int) (Math.random() * ((200 - 100) + 1))),(10 + (int) (Math.random() * ((50 - 10) + 1))),(1 + (int) (Math.random() * ((10 - 1) + 1)));
                    break;
            }}
        // Add to Team 2
        for(int i=0;i<=numberOfRandomPlayers;i++){
            switch (classDice){
                case 1:
                    team2.add("Wizard","RandomName1",(50 + (int) (Math.random() * ((100 - 50) + 1))),(10 + (int) (Math.random() * ((50 - 10) + 1))),(1 + (int) (Math.random() * ((50 - 1) + 1)));
                    break;
                case 2:
                    team2.add("Warrior","RandomName2",(100 + (int) (Math.random() * ((200 - 100) + 1))),(10 + (int) (Math.random() * ((50 - 10) + 1))),(1 + (int) (Math.random() * ((10 - 1) + 1)));
                    break;
            }
        }




        // status randomizadas dentro de un rango

    }
}
