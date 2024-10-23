public class Game {

    private int draws;

    private Player player1;
    private Player player2;

    private Player currentPlayer;

    private Board board;

    public Game(Player player1, Player player2, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.draws = 0;
        this.currentPlayer = player1;
        this.board = new Board(size);
    }


    public void play(){
        System.out.println("Player1: " + player1.getName());
        System.out.println("Player2: " + player2.getName());

        while(true){
            board.printBoard();


        }


    }
}
