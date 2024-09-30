import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOManager {

    String fileName;

    public IOManager(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(){


        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(new FileWriter(fileName));
            printWriter.println("Bill");
            printWriter.println("Bosse");
            printWriter.println("Arne");

            printWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<String> readFromFile(){
        ArrayList<String> text = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                text.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return text;
    }



}
