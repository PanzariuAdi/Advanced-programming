package lab07;

public class Token {
    private int firstNumber;
    private int secondNumber;
    private int value;

    public Token(int firstNumber, int secondNumber, int value) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.value = value;
    }

    public int getFirstNumber() { return firstNumber; }
    public int getSecondNumber() { return secondNumber; }
    public int getValue() { return value; }
}
