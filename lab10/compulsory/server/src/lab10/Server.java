package lab10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int PORT;
    private static boolean serverRunning = true;
    ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.PORT = port;
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while(serverRunning) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static void stopServer() {
        serverRunning = false;
    }
}
