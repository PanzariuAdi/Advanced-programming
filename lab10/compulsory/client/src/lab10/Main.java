package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try (
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ){
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Type a command : ");
                String command = scanner.next();

                if (command.equals("exit")) {
                    System.out.println("Client closing ...");
                    out.println(command);

                    break;
                }
                out.println(command);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
