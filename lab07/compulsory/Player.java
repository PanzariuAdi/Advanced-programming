package lab07;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable{
    private String name;
    private Board board;
    private List<Token> choosedTokens;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        choosedTokens = new ArrayList<Token>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public synchronized void getToken() {
        Token cToken = board.getTokens().get(0);
        choosedTokens.add(cToken);
        board.updateTokens();
        System.out.println(this.name + " -> " + cToken.getValue());
    }

    @Override
    public void run() {
        while (!board.getTokens().isEmpty()) {
            this.getToken();
        }
    }
}
