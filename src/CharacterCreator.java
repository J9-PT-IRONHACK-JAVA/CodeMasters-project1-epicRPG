import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CharacterCreator {
    ArrayList<Character> team1 = new ArrayList<Character>();
    ArrayList<Character> team2 = new ArrayList<Character>();

    public static void menu(){

//        String command = "start";
//
//        while (command.equals("exit") == false){
//            System.out.println();
//        }

        int character = 0;
        int characters;
        var scan = new Scanner(System.in);
        var team1 = new ArrayList<Character>();
        var team2 = new ArrayList<Character>();

        System.out.println("How many characters do you want for each team:");
        characters = scan.nextInt();
        for (int i = 0; i < characters; i++) {
            System.out.println("\nCharacter " + i + ".\n 1. Warrior or 2. Wizard?");
            while (character != 1 || character != 2) {
                character = scan.nextInt();
                if (character != 1 && character != 2){
                    System.out.println("Bad input!");
                }
            }
            if (character == 1) {
                team1.add(new Warrior(i, "ivan", 50, 100, 50));
            } else {
                team1.add(new Wizard(i, "salva", 50, 100, 50));
            }
        }

        for (int i = 0; i < characters; i++) {
            team2.add(new Wizard(i, "salva", 50, 100, 50));
        }
    }

    public void randomCreate(int q){
        Random r = new Random();
        for (int i = 0; i < q; i++) {
            var addCharacter1 = r.nextBoolean();
            if (addCharacter1==true) {
                team1.add(new Warrior(
                        i+1,
                        "Warrior " + i+1,
                        r.nextInt(50 - 1) + 1,
                        r.nextInt(100 - 1) + 1,
                        r.nextInt(50 - 1) + 1
                ));
            }else {

                team1.add(new Wizard(
                        i+1,
                        "Wizard  " + i+1,
                        r.nextInt(50 - 1) + 1,
                        r.nextInt(100 - 1) + 1,
                        r.nextInt(50 - 1) + 1
                ));
            }
            var addCharacter2 = r.nextBoolean();
            if (addCharacter2==true) {
                team2.add(new Warrior(
                        i+1,
                        "Warrior " + i+1,
                        r.nextInt(50 - 1) + 1,
                        r.nextInt(100 - 1) + 1,
                        r.nextInt(50 - 1) + 1
                ));
            }else {

                team2.add(new Wizard(
                        i+1,
                        "Wizard  " + i+1,
                        r.nextInt(50 - 1) + 1,
                        r.nextInt(100 - 1) + 1,
                        r.nextInt(50 - 1) + 1
                ));
            }
        }
        // print the random warriors:
        System.out.println("Team 1:");
        for (int i = 0; i < q; i++) {
            System.out.println(team1.get(i));
        }
        System.out.println("Team 2:");
        for (int i = 0; i < q; i++) {
            System.out.println(team2.get(i));
        }


    }
}
