package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import lab10.Server;

public class ClientThread extends Thread{
    private Socket socket = null;
    public ClientThread (Socket socket) { this.socket = socket; }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request;

            while(true) {
                request = in.readLine();

                if (request.equals("exit")) {
                    System.out.println("Server stopping ...");
                    Server.stopServer();
                    break;
                }
                System.out.println("[SERVER] Received command " + request);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
