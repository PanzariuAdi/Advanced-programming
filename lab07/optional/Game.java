package lab07;

public class Game {
    private int turn = 0;
    private Player firstPlayer;
    private Player secondPlayer;
    private Board board;
    private static Game instance;

    public Game() {
        firstPlayer = new HumanPlayer();
        secondPlayer = new ComputerPlayer();
    }

    public void initializeGame(int numberTokens, int maxValue, String player1, String player2, float waitTime) throws InterruptedException {
        board = new Board(numberTokens, maxValue);

        firstPlayer.setName("Adi");
        firstPlayer.setBoard(board);
        firstPlayer.setOrder(0);

        secondPlayer.setName("Computer");
        secondPlayer.setOrder(1);
        secondPlayer.setBoard(board);

        Daemon daemon = new Daemon(waitTime);


        Thread firstPlayerT = new Thread(firstPlayer);
        Thread secondPlayerT = new Thread(secondPlayer);
        Thread daemonT = new Thread(daemon);

        firstPlayerT.start();
        secondPlayerT.start();
        daemonT.start();

        firstPlayerT.join();
        secondPlayerT.join();

        daemon.setPlaying(false);

        if (firstPlayer.getScore() > secondPlayer.getScore()) {
            System.out.println(firstPlayer.getName() + " a castigat !");
        } else {
            System.out.println(secondPlayer.getName() + " a castigat !");
        }

    }

    public synchronized int getTurn() { return turn % 2; }
    public synchronized void changeTurn() {
        notifyAll();
        turn++;
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public void stopGame() {
        this.firstPlayer.stopPlay();
        this.secondPlayer.stopPlay();
    }

}
