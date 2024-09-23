public class Student extends Person{

    private int grade;
    public Student(String name, String pNumber, Address address) {
        super(name, pNumber, address);
    }

    public void registerForCourse(){

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
