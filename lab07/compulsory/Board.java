package lab07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Token> tokens;

    public Board(Integer nrTokens, Integer maxTokenValue) {
        Random rnd = new Random();
        tokens = new ArrayList<Token>();
        for(int i = 0; i < nrTokens; i++) {
            for(int j = 0; j < nrTokens; j++) {
                if (i == j) continue;
                tokens.add(new Token(i, j, rnd.nextInt(maxTokenValue)));
            }
        }
    }

    public void setTokens(List<Token> tokens) { this.tokens = tokens; }
    public synchronized List<Token> getTokens() { return tokens; }
    public synchronized void updateTokens() { tokens.remove(0); } // For now choose always first token in the list
}
