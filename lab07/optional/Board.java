package lab07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Token> tokens;

    public Board(Integer nrTokens, Integer maxTokenValue) {
        Random rnd = new Random();
        tokens = new ArrayList<Token>();
        for(int i = 1; i <= nrTokens; i++) {
            for(int j = 1; j <= nrTokens; j++) {
//                if (i == j) continue;
                tokens.add(new Token(i, j, rnd.nextInt(maxTokenValue)));
            }
        }
    }

    public void setTokens(List<Token> tokens) { this.tokens = tokens; }
    public synchronized List<Token> getTokens() { return tokens; }
    public synchronized void updateTokens(int index) { tokens.remove(index); }
    public synchronized int getNumberRemainTokens() { return tokens.size(); }

    public void stringBoard() {
        int n = (int) Math.sqrt(tokens.size());
        int index = 0;
        for (Token token : tokens) {
            if (index % n == 0) System.out.println();
            System.out.print("(" + token.getFirstNumber() + ", " + token.getSecondNumber() + ", " + token.getValue() + ") ");
            index++;
        }
    }
}
