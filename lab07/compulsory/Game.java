package lab07;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;

    public Game(Board board, List<Player> playerList) {
        this.board = board;
        this.playerList = playerList;
    }

    public void play() {
        for (Player player : playerList) {
            new Thread(player).start();
        }
    }
}
