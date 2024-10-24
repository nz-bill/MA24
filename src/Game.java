public class Game {

    private int draws;

    private Player player1;
    private Player player2;

    private Player currentPlayer;

    private Board board;

    private boolean running = true;

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

        while(running){
            board.printBoard();

            declareMove();
            if(board.checkWinner(currentPlayer)){
                running = winRoutine();
            }
            if (board.checkForDraw()){
                running = drawRoutine();
            }


//           if(currentPlayer.equals(player1)){
//               currentPlayer = player2;
//           } else{
//               currentPlayer = player1;
//           }
            currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
        }


    }

    public boolean drawRoutine(){
        System.out.println("det blev oavgjort");


        draws++;
        printScore();
        board.printBoard();

        System.out.println("vill du fotrsätta spela? (ja/nej");
        board.resetBoard();
        return InputHandler.getYesOrNo();
    }

    public boolean winRoutine(){
        System.out.println("GRATTIS! "+ currentPlayer.getName() +" vann");
        currentPlayer.increaseWins();
        printScore();
        board.printBoard();
        System.out.println("vill du fotrsätta spela? (ja/nej");
        board.resetBoard();

        return InputHandler.getYesOrNo();
    }

    public void printScore(){
        System.out.println(player1.getName() + ": " + player1.getWins());
        System.out.println(player2.getName() + ": " + player2.getWins());
        System.out.println("draws: " + draws);
    }

    public void declareMove(){

        boolean ok = false;
        do {
            System.out.println(currentPlayer.getName() + "(" + currentPlayer.getMarker()+"), din tur. ange en rad (1-" + board.getSize()+(")"));
            int row = InputHandler.getNewIntInRange(1,board.getSize());
            System.out.println("ange en kolumn (1-" + board.getSize()+")");
            int col = InputHandler.getNewIntInRange(1,board.getSize());

            ok = board.updateSquare(row,col, currentPlayer);
        } while(!ok);

    }
}
