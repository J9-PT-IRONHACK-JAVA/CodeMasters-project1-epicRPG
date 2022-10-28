import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in); //Scanner

    public void run() throws IOException {

        boolean run = true; //when "run" is True, menu is "looping"

        while (run){
            clearScreen();
            System.out.println("Welcome to EPIC RPG!");
            System.out.println("Select option:");
            System.out.println("1) Create manual characters.");
            System.out.println("2) Create random characters.");
            System.out.println("3) Import CSV.");
            System.out.println("4) Figth!.");
            System.out.println("5) Exit.");
            int option;

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
                    var creator = new CharacterCreator();
                    creator.menu(scanner);
                    System.out.println("Press ENTER to continue...");
                    System.in.read();
                    break;
                }
                case 2: {
                    clearScreen();
                    var creator = new CharacterCreator();
                    System.out.println("Number of characteres??");
                    int q=scanner.nextInt();
                    creator.randomCreate(q);
                    System.out.println("Press DOUBLE ENTER to continue...");
                    System.in.read();
                    break;

                }
                case 3: {
                    clearScreen();
                    System.out.println("import CSV - Implementar aqui.....");
                    System.out.println("Press ENTER to continue...");

                    System.in.read();

                    break;

                }
                case 4: {
                    clearScreen();
                    System.out.println("Figth!!! - Implementar aqui.....");
                    System.out.println("Press ENTER to continue...");

                    System.in.read();

                    break;

                }
                case 5: {
                    clearScreen();
                    System.out.println("Thanks por play!");
                    System.out.println("--==EPIC RPG==--");
                    run = false; //Close the loop from run (the while loop)
                    scanner.close();
                    break;

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

    // Scren cleaner
    public void clearScreen(){
        for (int i = 0; i < 30; i++) {
            System.out.println();

        }
    }


}
