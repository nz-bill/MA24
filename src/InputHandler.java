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
    public static int getNewIntInRange(int min, int max){

        while(true){
            while(!scanner.hasNextInt()){
                System.out.println("felaktig inmantning, ange ett heltal");
                scanner.nextLine();
            }

            int i = scanner.nextInt();
            if(i >= min && i <= max){
                scanner.nextLine();
                return i;
            }
            System.out.println("felaktig inmantning, ange ettt heltal mellan " + min +" och "+max);
        }


    }

    public static String getNewString(){
        return scanner.nextLine();
    }
}
