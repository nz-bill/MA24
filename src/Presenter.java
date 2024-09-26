import java.util.ArrayList;

public class Presenter {

    public void showPersons(ArrayList<? extends Item> pList){
        for(Item p : pList){
            System.out.println(p.toString());
        }
    }

    public boolean getAnswer(int i){
        if(i < 10) {
            return true;
        } else return false;

       // return (i < 10 )? true : false;
    }
}
