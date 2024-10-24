import java.util.ArrayList;

public class Player {

    private String name;

    private char marker;

    private  int wins;

    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
        this.wins = 0;
    }

    public int getWins() {
        return wins;
    }


    public void increaseWins() {
        this.wins++;
    }

    public String getName() {
        return name;
    }

    public char getMarker() {
        return marker;
    }
}
