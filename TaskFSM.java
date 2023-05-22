import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть рядок");
            String line = scanner.nextLine();
            if(line.isEmpty())
            {
                break;
            }
            Automat automat = new Automat(line);
            System.out.println(automat.scanner()+"\n");
        }
    }
}
