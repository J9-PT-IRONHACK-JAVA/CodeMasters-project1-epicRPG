import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Character> team1 = new ArrayList<Character>();

        //var csv = new Csv();
        Scanner scanner = new Scanner(System.in);
        //csv.menuCsv(scanner);
        Csv.menuCsv(scanner, team1);
        System.out.println(team1);


    }
}
