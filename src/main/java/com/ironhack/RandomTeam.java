package com.ironhack;

import java.io.IOException;
import java.util.ArrayList;
import net.datafaker.Faker;



public class RandomTeam {

    public static void generate(ArrayList<Character> team1, ArrayList<Character> team2) throws IOException {

        // Crear partidos completamente random
        // nº jugadores random entre 2 y 10 (20 era too much)


//        System.out.println("Press any key to generate a random team");
//        System.in.read();
        int numberOfRandomPlayers = (2 + (int) (Math.random() * ((10 - 2) + 1)));
        System.out.println("You are going to fight " + numberOfRandomPlayers + " vs. " + numberOfRandomPlayers + ". Press any key to continue. ");
        System.in.read();
        for (int i = 0; i < numberOfRandomPlayers; i++) {
            int classDice = (1 + (int) (Math.random() * ((2 - 1) + 1)));
            switch (classDice) {
                case 1:
                    team1.add(new Warrior(i, randomWarriorName(new Faker()), (int)(Math.random()*200+100),(int)(Math.random()*50+10), (int)(Math.random()*50+1)));
                    break;
                case 2:
                    team1.add(new Wizard(i, randomWizardName(new Faker()), (int)(Math.random()*100+50),(int)(Math.random()*50+10),(int)(Math.random()*50+1)));
                    break;
            }
        }
        // Add to Team 2
        for (int i = 0; i < numberOfRandomPlayers; i++) {
            int classDice = (1 + (int) (Math.random() * ((2 - 1) + 1)));
            switch (classDice) {
                case 1:
                    team2.add(new Warrior(i, randomWarriorName(new Faker()), (int)(Math.random()*200+100),(int)(Math.random()*50+10), (int)(Math.random()*50+1)));
                    break;
                case 2:
                    team2.add(new Wizard(i, randomWizardName(new Faker()), (int)(Math.random()*100+50),(int)(Math.random()*50+10),(int)(Math.random()*50+1)));
                    break;
            }
        }
    }  private static String randomWarriorName(Faker faker) {
        String nameWarrior = faker.witcher().monster();
        if (nameWarrior.indexOf(" ") != -1) {
            nameWarrior = nameWarrior.substring(0, nameWarrior.indexOf(" "));
        } return nameWarrior;
    }
    private static String randomWizardName(Faker faker) {
        String nameWizard = faker.witcher().witcher();
        if (nameWizard.indexOf(" ") != -1) {
            nameWizard = nameWizard.substring(0, nameWizard.indexOf(" "));
        }  return nameWizard;
    }
    public static void warriorNameGenerator(){
        var warriorFaker = new Faker();
        String randomName1 = randomWarriorName(warriorFaker);
//        if (name2.equals(name1)) {name2 += " Jr";}
//        if (name3.equals(name1) || name3.equals(name2)) {
//            name3 += " Jr";
//            if (name3.equals(name2)) {name3 += " Jr";}
//        }
    }
    public static void wizardNameGenerator(){
        var wizardFaker = new Faker();
        String randomName2 = randomWizardName(wizardFaker);

    }
}