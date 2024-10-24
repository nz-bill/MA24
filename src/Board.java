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
        int index = 0;
        for (int y = 0; y < this.size; y++){
            System.out.print("|");
            for(int x = 0; x < this.size; x++){
                grid.get(index).printSquare();
                index++;
            }
            System.out.println(y +1);

        }


        for(int i = 0; i < this.size; i++){
            System.out.print(" ");
            System.out.print(i+1);
        }
        System.out.println();
    }

    //i och size
    //vi vill ha row och col
//
//        int y = i/size;
//        int x = i%size;
//
//        System.out.println("x = " + (x+1));
//        System.out.println("y = " + (y+1));
    public boolean updateSquare(int row, int col, Player newOwner){

//        if(row < 1 || row > size ){
//            System.out.println("felaktig rad, ange tal mellan 1-" + size);
//            return  false;
//        }
//        if(col < 1 || col > size ){
//            System.out.println("felaktig kolumn, ange tal mellan 1-" + size);
//            return  false;
//        }

        //gör om row och col till index: ex (om size = 3) 1,1 = 0. 2,2 = 4. 3,3 = 8 etc
        int i = ((row-1) * size) + col-1;

        if(grid.get(i).getOwner() != null){
            System.out.println("rutan är upptagen, välj en ny");
           return false;
        }

        grid.get(i).setOwner(newOwner);



        return true;
    }

    public int getSize() {
        return size;
    }
}
