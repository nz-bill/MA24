import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Person p1 = new Person("Bill", 43);
//
//        Person p2 = new Person("Arne", 57);


//        p1.greet(p2);
//
//        p2.greet(p1);
//        System.out.println("namnge spelare 1");
//        String name1 = scanner.next();
//        System.out.println("namnge spelare 2");
//        String name2 = scanner.next();

        Game game = new Game(new Player("Bill"), new Player("Bosse"));

        game.playGame();


// ----------- slumptal ---------------
//        Random r = new Random();
//        for (int i = 0; i <10; i++){
//            System.out.println(r.nextInt(0,11));
//        }
//
//        for (int i = 0; i <10; i++){
//            System.out.println((int)(Math.random() * 10));
//        }
// -------------------------------------

    }
}