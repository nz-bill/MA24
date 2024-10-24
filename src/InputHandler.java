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

    public static boolean getYesOrNo(){
        while(true){
            String input = scanner.nextLine();

            if(input.toLowerCase().startsWith("j") || input.toLowerCase().startsWith("y")){
                return true;
            }
            if(input.toLowerCase().startsWith("n")){
                return false;
            }
            System.out.println("felaktig inmatning. Svara med ja eller nej");

        }




    }

    public static String getNewString(){
        return scanner.nextLine();
    }
}
