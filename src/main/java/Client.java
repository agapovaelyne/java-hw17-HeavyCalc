import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 55444);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.print("Enter the number to count: ");
                input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }
                try {
                    int number = Integer.parseInt(input);
                    out.println(number);
                    System.out.println(in.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect format of input!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
