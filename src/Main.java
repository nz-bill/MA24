import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Address a1 = new Address("vägen", "23","12345","Stadboda");
        Address a2 = new Address("stigen", "22","12345","Stadboda");


        System.out.println("count :" + Person.count);

        Person p1 = new Person("Bill","Palmestedt", 43);
        Person p2 = new Person("Bosse","Parnevik", 84);

        System.out.println("count :" + Person.count);

        Person p3 = new Person();
        Person p4 = new Person("Arne", "Andersson", 32, a1);

        ArrayList<Person> persons = new ArrayList<>();




        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);


        p1.setAddress(a2);
        p2.setAddress(a2);

        p3.setFirstName("Berit");
        p3.setLastName("Karlsson");
        p3.setAge(67);

        for(Person p: persons){
            System.out.println(p);


        }

        Person.staticMethod();


        p1.greeting();
        p2.greeting();

        System.out.println("count :" + Person.count);




    }
}