import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class client {
// private переменные для удобного использования
    private static BufferedReader in; // Прием сообщений
    private static BufferedWriter out; // Отправка сообщения
    private static BufferedReader reader; // Записть сообщения
    private static Socket client; // Сокет для соединения с сервером

    public static void main(String[] args)
    {
        try {

            boolean run = true;
            while (run) {
                client = new Socket("localhost", 8001); // Подключение по "localhost" по порту 8001
                reader = new BufferedReader(new InputStreamReader(System.in)); // переменная для чтения сообщения
                in = new BufferedReader(new InputStreamReader(client.getInputStream())); // переменная для приема сообщений
                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); // переменная для отправки сообщений
                System.out.print("Message: ");

                String message = reader.readLine();
                if (message == "/exit") {
                    run = false;
                }
                out.write(message);
                out.flush(); // чистим буфер
                System.out.println("Done flush");
                String serverMessage = in.readLine();
                System.out.println("Done Readline");
                System.out.println(serverMessage);
            }
            // закрытие
            out.close();
            in.close();
            reader.close();
            client.close();

        }catch (IOException e){
            System.out.println("Err ----- " + e);
        }


    }
}