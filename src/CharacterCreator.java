import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CharacterCreator {
    
    ArrayList<Character> team1 = new ArrayList<Character>();
    ArrayList<Character> team2 = new ArrayList<Character>();

    public static void menu(){

        int character = 0;
        int characters;

        var scan = new Scanner(System.in);
        var team1 = new ArrayList<Character>();
        var team2 = new ArrayList<Character>();

        System.out.println("How many characters do you want for each team:");
        characters = scan.nextInt();
        scan.nextLine();
        System.out.println("\nNICE! You are going to fight "+characters+" vs "+characters+"\n");
        System.out.println("TIME TO SET THE TEAM 1:");
        for (int i = 0; i < characters; i++) {
            System.out.println("\nCHARACTER "+(i+1)+".\n 1. Warrior or 2. Wizard?");
            character = 0;
            while (character != 1 || character != 2) {
                character = scan.nextInt();
                scan.nextLine();
                if (character != 1 && character != 2){
                    System.out.println("Bad input! Write 1 or 2 and press intro.");
                }
                if (character == 1) {
                    warriorCreator(scan, team1, i);
                    break;
                } else if (character == 2){
                    wizardCreator(scan, team1, i);
                    break;
                }
            }
        }

        System.out.println("\n\nTIME TO SET THE TEAM 2:");
        for (int i = 0; i < characters; i++) {
            System.out.println("\nCHARACTER " +(i+1)+ ".\n 1. Warrior or 2. Wizard?");
            character = 0;
            while (character != 1 || character != 2) {
                character = scan.nextInt();
                scan.nextLine();
                if (character != 1 && character != 2){
                    System.out.println("Bad input!");
                }
                if (character == 1) {
                    warriorCreator(scan, team2, i);
                    break;
                } else if (character == 2){
                    wizardCreator(scan, team2, i);
                    break;
                }
            }
            character=0;

        }
        for (int i = 0; i < characters; i++) {
            System.out.println("Adding Character to TEAM Nª 2");
            System.out.println("\nCharacter " + (i + 1) + ".\n 1. Warrior or 2. Wizard?");
            while (character != 1 && character != 2) {
                character = scan.nextInt();
                if (character != 1 && character != 2) {
                    System.out.println("Bad input!");
                }
            }
            if (character == 1) {
                team2.add(new Warrior(i + 1, "Warrior", 50, 100, 50));
            } else if (character == 2) {
                team2.add(new Wizard(i + 1, "Wizard", 50, 100, 50));
            }
            character=0;

        }

        for (int i = 0; i < characters; i++) {
            System.out.println(team1.get(i));
        }
        for (int i = 0; i < characters; i++) {
            System.out.println(team2.get(i));
        }

    }

    private static void warriorCreator(Scanner scan, ArrayList<Character> team, int i) {

        String name;
        int stamina;
        int strength;
        int hp;

        System.out.println("\nName for the Warrior:");
        name = scan.nextLine();
        System.out.println("\nSet the HP between 100 and 200:");
        hp = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the stamina between 10 and 50:");
        stamina = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the strength between 1 and 10:");
        strength = scan.nextInt();
        scan.nextLine();
        team.add(new Warrior(i, name, hp, stamina, strength));
    }

    private static void wizardCreator(Scanner scan, ArrayList<Character> team1, int i) {

        String name;
        int mana;
        int intelligence;
        int hp;

        System.out.println("\nName for the Wizard:");
        name = scan.nextLine();
        System.out.println("\nSet the HP between 50 and 100:");
        hp = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the mana between 10 and 50:");
        mana = scan.nextInt();
        scan.nextLine();
        System.out.println("\nSet the intelligence between 1 and 50:");
        intelligence = scan.nextInt();
        scan.nextLine();
        team1.add(new Warrior(i, name, hp, mana, intelligence));
    }
}
