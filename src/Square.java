public class Square {

    private Player owner;

    private int posX;
    private int posY;

    public Square(int posX, int posY) {
        this.owner = null;
        this.posX = posX;
        this.posY = posY;
    }

    public void printSquare(){

        char mark = ' ';
        if(this.owner != null) {
            mark = this.owner.getMarker();
        }

        System.out.print( mark + "|" );
    }
}
