public class Person {

    private String firstName;

    private String lastName;
    private int age;

    private Address address;

    public static int count;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        count++;
    }

    public Person(String firstName, String lastName, int age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        count++;
    }

    public Person(){
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        count++;
    }

    public void greeting(){
        System.out.println("hej hej!, jag heter " + this.firstName);
    }


    @Override
    public String toString() {

        if (this.address != null){
            return firstName + " " + lastName + ", " + age +", " + this.address;
        } else {
            return firstName + " " + lastName + ", " + age +", " + "NO ADDRESS";
        }


    }

    public static void staticMethod(){
        System.out.println("jag är inget objekt");
    }

    public void setFirstName(String name){
        if(!name.equals("")){
            this.firstName = name;
        }

    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
