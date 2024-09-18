public class Person {

    private String name;
    private int age;


    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(String name){
        this.name = name;
        this.age = 0;
    }

    public void greet(Person p){
        System.out.println("Hej " + p.getName() + ", jag heter " + this.name);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


}
