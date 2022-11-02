import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {

    private static Scanner scanner = new Scanner(System.in); //Scanner

    public static void run(ArrayList<Character> team1, ArrayList<Character> team2) throws IOException {

        int option= 0;

        while (option != -1){
            clearScreen();
            System.out.println("Welcome to EPIC RPG!");
            System.out.println("Select option:");
            System.out.println("1) Create manual characters.");
            System.out.println("2) Chose between 3 random characters.");
            System.out.println("3) Create a random teams.");
            System.out.println("4) Import CSV.");
            System.out.println("5) Exit.");

            try{
                option = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e){
                option = 0;
            }

            switch (option) {
                case 0: {
                    clearScreen();
                    System.out.println("Error!! Only NUMBERS please...");
                    System.out.println("Press ENTER to continue...");
                    System.out.println("*********************************");
                    System.in.read();
                    break;
                }
                case 1: {
                    clearScreen();
                    System.out.println("Create Manual Characters....");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    CharacterCreator.menu(team1, team2);
                    return;
                    //break;
                }
                case 2: {
                    clearScreen();
                    System.out.println("Chose between 3 random generated characters....");
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    CharacterThreeRandom.menu();
                    return;

                }
                case 3: {
                    clearScreen();
                    System.out.println("Create a random teams.....");
                    System.out.println("Press ENTER to continue...");
//DRINA
                    System.in.read();
                    return;

                }
                case 4: {
                    clearScreen();
                    System.out.println("Import teams from a 'csv' file.....");
                    System.out.println("Press ENTER to continue...");
//ANDRES
                    System.in.read();
                    return;

                }
                case -1: {
                    clearScreen();
                    System.out.println("Thanks por play!");
                    System.out.println("--==EPIC RPG==--");
                    scanner.close();
                    System.exit(-1);

                }
                default: {
                    clearScreen();
                    System.out.println("Option Error! Select a correct option...");
                    System.out.println("Press ENTER to continue...");
                    System.out.println("*********************************");
                    System.in.read();
                    break;

                }
            }
        }
    }

    // Screen cleaner
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
    }

}
