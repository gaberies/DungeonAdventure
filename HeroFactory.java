import java.util.Scanner;

public class HeroFactory {
    static Scanner scanner = new Scanner(System.in);
    public Hero buildHero() {

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief");
        int choice = scanner.nextInt();
        switch (choice){
            case 1: return new Warrior();

            case 2: return new Sorceress();

            case 3: return new Thief();

            default: return new Thief();
        }
    }
}
