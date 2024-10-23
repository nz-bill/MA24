public class Player {

    private String name;

    private char marker;

    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
    }

    public String getName() {
        return name;
    }

    public char getMarker() {
        return marker;
    }
}
