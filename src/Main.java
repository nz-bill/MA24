import java.util.ArrayList;

public class Main {

    public static ArrayList<Person> personList = new ArrayList<>();

    public static void main(String[] args) {


        IOManager io = new IOManager("exempel.txt");

       // io.writeToFile();

        ArrayList<String> text = io.readFromFile();

//        for (String s: text){
//            System.out.println(s);
//        }

        System.out.println("personList = " + personList);

    }

    public static void createPersons(ArrayList<String> names){

        for (String name : names){
            Person p = new Person(name);
            personList.add(p);
        }

    }
}