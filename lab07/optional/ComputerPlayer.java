package lab07;

public class ComputerPlayer extends Player{

    @Override
    public void playGame() {
        if (!this.getBoard().getTokens().isEmpty()) {
            System.out.println("Computer's tokens : " + playerTokens());
            getToken(0);
        }
    }
}
