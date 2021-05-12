package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    public ClientThread (Socket socket) { this.socket = socket; }
    private int thID;

    private long start, end;
    float elapsedTimeMin;

    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request;

            Server.threadList.add(Server.threadID);
            thID = Server.threadID;
            Server.threadID++;

            while (true) {
                start = System.nanoTime();
                request = in.readLine();

                if (request.equals("stop")) {
                    System.out.println("Server stopping ...");
                    Server.setServerRunningFalse();
                    Server.serverSocket.close();
                    break;
                }

                System.out.println("[SERVER] Received command " + request);
                end = System.nanoTime() - start;

                elapsedTimeMin = end / 1_000_000_000F / 60F;

                if (elapsedTimeMin >= 10) {
                    System.out.println("Client " + thID + " out of time ! Closing him ...");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Server.threadList.remove(thID);
                if (Server.threadList.isEmpty() && !Server.isServerRunning()) {
                    stopServer();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopServer() {
        try {
            Server.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
