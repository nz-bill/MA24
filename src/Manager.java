import java.util.ArrayList;

public class Manager {

    ArrayList<Person> personList = new ArrayList<>();
    ArrayList<Book> bookList = new ArrayList<>();
    Presenter presenter = new Presenter();

    public void start(){

        for (int i = 0; i < 10; i++){
            Person p = new Person("Bill", 40+i);

            personList.add(p);
        }
        for (int i = 0; i < 10; i++){
            Book p = new Book("fin titel", "348476-fgisdg-2334-35" + Integer.toString(i));

            bookList.add(p);
        }

        presenter.showPersons(personList);
        presenter.showPersons(bookList);

    }
}
