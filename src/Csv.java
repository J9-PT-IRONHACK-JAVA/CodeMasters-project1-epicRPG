import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Csv {

    private ArrayList<Character> team = new ArrayList<Character>();

    public void meunCsv(Scanner scanner) throws FileNotFoundException {
        System.out.println("Please put the name of CSV file:");
        String filename = scanner.nextLine();
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        ArrayList<String> fileList = new ArrayList<>();
        while (reader.hasNextLine()){
            fileList.add(reader.nextLine());
        }
        System.out.println(fileList.get(1).split(",").getClass().getName());
        /*
        for (int i = 0; i < fileList.size(); i++) {
            if (i!=0){
                System.out.println(fileList.get(i));
            }

        }
        System.out.println(fileList.get(1).split(","));

        /*
        var char1 = new Warrior(id,name,hp,stamina,stregnth)
        var char2 = new Wizard(id,name,hp,stamina,stregnth)
        */

        for (int i = 0; i < fileList.size(); i++) {
            System.out.println(fileList.get(i));

        }




    }

}
