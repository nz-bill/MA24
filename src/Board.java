import java.util.ArrayList;

public class Board {

    private ArrayList<Square> grid = new ArrayList<>();
    private int size;
    public Board(int size) {
        this.size = size;
      for (int y = 0; y < size; y++){

          for(int x = 0; x < size; x++){
              grid.add(new Square(x,y));
          }

      }
    }

    public void printBoard(){
        for (int y = 0; y < this.size; y++){
            System.out.print("|");
            for(int x = 0; x < this.size; x++){
                grid.get(x).printSquare();
            }
            System.out.println(y +1);

        }

        for(int i = 0; i < this.size; i++){
            System.out.print(" ");
            System.out.print(i+1);
        }
        System.out.println();
    }
}