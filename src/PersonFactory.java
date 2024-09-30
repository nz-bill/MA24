import java.util.ArrayList;

public class PersonFactory {
    public  ArrayList<Person> personList = new ArrayList<>();

    public void createPersons(ArrayList<String> names){

        for (String name : names){
            Person p = new Person(name);
            personList.add(p);
        }

    }


}
