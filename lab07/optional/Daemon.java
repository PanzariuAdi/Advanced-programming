package lab07;

public class Daemon implements Runnable{

    float waitTime = 10;
    private boolean playing = true;

    public Daemon(float waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        long end = System.nanoTime();

        while ((end - start) * 100000 <= waitTime && playing) {
            end = System.nanoTime();
        }

        System.out.println("TIME IS OVER");
        Game.getInstance().stopGame();
    }

    public void setPlaying(boolean playing) { this.playing = playing; }
}
