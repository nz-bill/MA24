import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Course course1 = new Course("Java Grunder");


        Address a1 = new Address("Stigen", "24");
        Address a2 = new Address("Vägen", "26");

        Student s1 = new Student("Bosse", "283874632785", a1);
        //Person p1 = new Person("Anders", "346753563", a2);
        Teacher t1 = new Teacher("Bill", "23756258", a2, 124);

        //Person testPerson = new Person();

        //System.out.println(testPerson.getAddress().getStreetName());

        Admin admin = new Admin("Andreas", "2837562578", a2, 23432);

        t1.setGrade(s1, course1, 1);


        ArrayList<Employee> persons = new ArrayList<>();



       t1.setSalary(3564354);
       t1.getAddress();






    }
}