import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

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

            choice = getNewInt();

            switch (choice){
                case 1:
                    System.out.println("upcoming feature" );
                    break;

                case 2:
                    System.out.println("choice = " + choice);
                    break;
                case 0:
                    System.out.println("choice = " + choice);
                    break;

            }
        } while(choice != 0 );


    }

    public int getNewInt(){


        while(!scanner.hasNextInt()){
            System.out.println("felaktig inmantning, ange ett heltal");
            scanner.nextLine();
        }

        return scanner.nextInt();
    }




}
