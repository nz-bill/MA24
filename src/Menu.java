import java.util.Scanner;

public class Menu {



    public void displayMenu(){

        System.out.println("------- Tic tac toe -------");
        System.out.println("Välj ett alternativ");
        System.out.println("1.  starta spel (1 spelare)");
        System.out.println("2.  starta spel (2 spelare)");
        System.out.println("0.  avsluta");
    }

    public void start(){
        int choice = -1;
        do {
            displayMenu();

            choice = InputHandler.getNewIntInRange(0,3);

            switch (choice){
                case 1:
                    System.out.println("upcoming feature" );
                    break;

                case 2:
                    System.out.println("ange namn på spelare 1");
                    String name1 = InputHandler.getNewString();
                    Player p1 = new Player(name1,'X');

                    System.out.println("ange namn på spelare 2");
                    String name2 = InputHandler.getNewString();
                    Player p2 = new Player(name2,'O');

                    System.out.println("hur stor spelplan?");

                    Game game = new Game(p1,p2,InputHandler.getNewInt());
                    game.play();

                    break;

                    //hemlig dev option- ta bort innan release
                case 3: Player pl1 = new Player("Bill",'X');
                        Player pl2 = new Player("boll", 'O');
                        Game game2 = new Game(pl1,pl2,3);
                        game2.play();
                case 0:
                    System.out.println("choice = " + choice);
                    break;

            }
        } while(choice != 0 );


    }






}
