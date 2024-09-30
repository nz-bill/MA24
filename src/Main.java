import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {


        IOManager io = new IOManager("exempel.txt");
        PersonFactory pf = new PersonFactory();

       io.writeToFile();


        pf.createPersons(io.readFromFile(""));



        for(Person p : pf.personList){
            System.out.println(p.toString());
        }

    }


}