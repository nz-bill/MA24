import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Orc orc = new Orc();
        Goblin goblin = new Goblin();
        Murloc murloc = new Murloc();


        ArrayList<Enemy> enemies = new ArrayList<>();

        enemies.add(orc);
        enemies.add(goblin);
        enemies.add(murloc);


    }
}