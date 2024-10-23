import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static int getNewInt(){


        while(!scanner.hasNextInt()){
            System.out.println("felaktig inmantning, ange ett heltal");
            scanner.nextLine();
        }
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    public static String getNewString(){
        return scanner.nextLine();
    }
}
