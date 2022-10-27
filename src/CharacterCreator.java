import java.util.ArrayList;
import java.util.Scanner;

public class CharacterCreator {

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

}
