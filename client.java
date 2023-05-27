import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client extends Thread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("Local", 8080);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Write your username: ");
            String name = scanner.nextLine();
            output.println(name);

            String string = input.readLine();
            System.out.println("Server: " + string);

            while (true) {
                System.out.print("* ");
                String expression = scanner.nextLine();

                output.println(expression);

                if (expression.equalsIgnoreCase("bye")) {
                    System.out.println("leaving...");
                    break;
                }

                String result = input.readLine();
                System.out.println("Server: " + result);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

