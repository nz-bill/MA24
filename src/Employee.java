public abstract class Employee extends  Person{

    private int salary;
    public Employee(String name, String pNumber, Address address, int salary) {
        super(name, pNumber, address);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
