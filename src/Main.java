import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var csv = new Csv();
        Scanner scanner = new Scanner(System.in);
        csv.meunCsv(scanner);
      
    }
}
