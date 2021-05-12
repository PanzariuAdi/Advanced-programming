package lab10;

import java.io.IOException;

public class StopThread extends Thread{
    public void run() {
        try {
            Server.serverSocket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
