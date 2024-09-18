import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    ArrayList<Item> items = new ArrayList<>();
    private Player player1;
    private Player player2;


    private Player winner;
    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;

        items.add(new Item("1", "axe", 15, -5, 0));
        items.add(new Item("2","shield", 0, 15, 0));
        items.add(new Item("3","health potion", 0,0,10));
        items.add(new Item("4", "kunai", 5, 0, 0));
        items.add(new Item("5", "bazooka", 25, -10, -10));


    }

    public void playGame(){






        armPlayer(player1);
        armPlayer(player2);

        System.out.println("I ena ringhörnan: ");
        System.out.println("player1 = " + player1);
        System.out.println();
        System.out.println("i den andra ringhörnan");
        System.out.println("player2 = " + player2);

        gameLoop();

    }
    public void armPlayer(Player player){
        Random r = new Random();
        int index = r.nextInt(0, items.size());
        player.setWeapon(items.get(index));

        player.takeDamage(-player.getWeapon().getHealthBoost());
        System.out.println(player.getName() + " has a " + player.getWeapon().getName());

    }
    public void gameLoop(){
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("press any key to resume fight");
            scanner.next();

            player1.attack(player2);
            System.out.println(player2.getName() + " health is now at: " + player2.getHealth());
            System.out.println();
            player2.attack(player1);
            System.out.println(player1.getName() + " health is now at: " + player1.getHealth());
            System.out.println();


        } while(player1.getHealth() > 0 && player2.getHealth() > 0);

            if(player1.getHealth() == player2.getHealth()){
                System.out.println("ingen vann, båda är sämst");
            } else if(player1.getHealth() > player2.getHealth()){
                winner = player1;
                System.out.println(winner.getName() + " vann för hen är bäst!");
            } else {
                winner = player2;
                System.out.println(winner.getName() + " vann för hen är bäst!");
            }

    }
}

