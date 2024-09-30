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
            printWriter.println("Cesar");

            printWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *  läser in från en fil
     * @param fileN namnet på filen vi läser ifrån
     * @return en lista av stränger som vi har fått från filen
     */
    public ArrayList<String> readFromFile(String fileN){
        ArrayList<String> text = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                text.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return text;
    }



}
