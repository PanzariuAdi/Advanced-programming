package lab07;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Runnable{
    private String name;
    private Board board;
    private List<Token> choosedTokens;
    private int score;
    private boolean playing = true;
    private int order;

    public Player() {
        choosedTokens = new ArrayList<Token>();
    }

    public Player(String name) {
        this.name = name;
        choosedTokens = new ArrayList<Token>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getScore() { return score; }
    public Board getBoard() { return board; }
    public void setBoard(Board board) { this.board = board; }
    public List<Token> getChoosedTokens() { return choosedTokens; }
    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order;}

    public synchronized void getToken(int index) {
        Token cToken = board.getTokens().get(index);
        choosedTokens.add(cToken);
        board.updateTokens(index);
        this.score = this.score + cToken.getValue();
    }

    @Override
    public void run() {
        Game game = Game.getInstance();

        while (playing) {
            if (playing && game.getTurn() != this.order) {
                synchronized (game){
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        playing = false;
                    }
                }
            }
            playGame();
            game.changeTurn();
            if (board.getNumberRemainTokens() == 0)
                stopPlay();
        }
        game.stopGame();
        System.out.println("Game over");

    }

    public void stopPlay() { this.playing = false; }

    public StringBuilder playerTokens() {
        StringBuilder sb = new StringBuilder();
        for (Token token : choosedTokens) {
            sb.append("(");
            sb.append(token.getFirstNumber());
            sb.append(", ");
            sb.append(token.getSecondNumber());
            sb.append(", ");
            sb.append(token.getValue());
            sb.append(") ");
        }
        return sb;
    }
    public abstract void playGame();
}
