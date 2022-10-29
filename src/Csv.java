import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Csv {

    private ArrayList<Character> team = new ArrayList<Character>();

    public void meunCsv(Scanner scanner) throws FileNotFoundException {
        ArrayList<String> fileList = new ArrayList<>();
        boolean flag = false;
        String filename;
        do {
            System.out.println("Please put the name of CSV file:");
            filename = scanner.nextLine();
            try {
                File file = new File(filename);
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    fileList.add(reader.nextLine());
                }
                flag = true;

            } catch (Exception e) {
                System.out.println("File not found, try again...");
            }
        }while (flag == false);

        try {
            for (int i = 0; i < fileList.size(); i++) {
                String[] line = fileList.get(i).split(",");
                if (i != 0) {
                     if (line[0].equals("WA")) {
                         team.add(new Warrior(i + 1, line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                     } else {
                         team.add(new Wizard(i + 1, line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                     }
                    }
                }
            System.out.println("CHARACTERES CREADOS CORRECTAMENTE! -- ELIMINAR ESTA LINEA ");
        } catch (Exception e) {
            System.out.println("Error... Verify CSV file Format...");
        }

        System.out.println("Aqui implementar lo siguiente, teniendo en cuenta:");
        System.out.println("1) SI DA ERROR: ");
        System.out.println("   - Volver al menu anterior?\n" +
                           "   - pedir nuevamente el nobmre del archivo csv?\n" +
                           "   - generar un random?");
        System.out.println("2) SI NO DA ERROR Y CREA LOS CHARACTER SIN PROBLEMA:");
        System.out.println("   - retornar la lista?\n");

    }

}
