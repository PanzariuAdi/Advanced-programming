package lab10;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Server {
    private int PORT;
    private static boolean serverRunning = true;
    public static List<Integer> threadList = new ArrayList<Integer>();
    public static int threadID = 0;
    static ServerSocket serverSocket;

    public Server(int port) throws IOException {

        this.PORT = port;
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);

            while (serverRunning) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }

            while(!threadList.isEmpty()) {}

        } catch (SocketException e) {
            System.out.println("Server stopped !");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static boolean isServerRunning() {
        return serverRunning;
    }

    public synchronized static void setServerRunningFalse() {
        serverRunning = false;
    }

}
