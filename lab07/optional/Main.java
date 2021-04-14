package lab07;

    public class Main {

    public static void main(String[] args) {
        String player1, player2;
        player1 = "Adi";
        player2 = "Marian";
        Game game = new Game();

        try {
            game.initializeGame(2, 10, player1, player2, 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
