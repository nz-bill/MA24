public abstract class Person {
    String name;
    String pNumber;

    private Address address;

    public Person(){
       this.address = new Address("nope","");
    }
    public Person(String name, String pNumber, Address address){

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
