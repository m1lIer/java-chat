import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;
import java.util.Scanner;

public class git
{
    // создание переменных для уо
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args)
    {
        try{
            System.out.println("m1ller's local chat v0.1");
            server = new ServerSocket(8001);
            clientSocket = server.accept();
            System.out.println(">>> Server ready");

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String client_message = in.readLine();
                System.out.println("Done readline");
                System.out.println(client_message);

                out.write("Your message - ");
                System.out.println("Done sent");
                out.flush();
            }
            finally {
                server.close();
                clientSocket.close();
                in.close();
                out.close();
            }
        }
        catch (IOException e){
            System.err.println(e);
        }
    }
}