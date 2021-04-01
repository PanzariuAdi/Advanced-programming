package lab07;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(5, 10);
        List<Player> players = new ArrayList<Player>();
        Player p1 = new Player("Stallone", board);
        Player p2 = new Player("Chuck Norris", board);
        players.add(p1);
        players.add(p2);
        Game game = new Game(board, players);
        game.play();
    }
}
