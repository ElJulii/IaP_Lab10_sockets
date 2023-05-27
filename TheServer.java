
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TheServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("The server is running. Waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("User connected! : " + clientSocket);

                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                String name = input.readLine();
                System.out.println("User: " + name);

                output.println("Hi, " + name + "!!, choose 'x'  or type 'bye' to exit... ");

                String expression = input.readLine();
                System.out.println("We received: " + expression);

                if (expression.equalsIgnoreCase("bye")) {
                    System.out.println("Closing server...");
                    break;
                }

                double result = Expressions(expression);
                System.out.println("Result: " + result);


                clientSocket.close();
                System.out.println("User connected: " + clientSocket);
            }

            serverSocket.close();
            System.out.println("Server has being stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double Expressions(String expression) {
        double result = 0;

        String[] tokens = expression.split(" ");
        double x = Double.parseDouble(tokens[0]);
        int choice = Integer.parseInt(tokens[1]);
        double a = 5, nx = 8, b = 14, c = 16, d = 18, y = 21, e = 12, a1 = 12, a2 = 47;

        switch (choice) {
            case 1 -> result = ((5 * Math.pow(a, nx) / b + c) - Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3)))));
            case 2 -> result = (Math.abs((x - y)) / Math.pow((1 + 2 * x), a) - Math.pow(e, Math.sqrt(1 + a)));
            case 3 -> result = Math.sqrt(a + a1 * x + a2 * (Math.sqrt(Math.abs(Math.sin(x)))));
            case 4 ->
                    result = Math.log(Math.pow(a, 7)) + Math.pow(Math.atan(x), 2) + Math.PI / Math.sqrt(Math.abs(a + x));
            case 5 -> result = Math.sqrt((Math.pow((a + b), 2) / c + d) + Math.pow(e, Math.sqrt(x + 1)));
            case 6 -> result = Math.pow(e, ((2 * Math.sin(4 * x) + Math.pow(Math.cos(Math.pow(x, 2)), 2))));
            case 7 -> result = 1.0 / 4.0 * ((1.0 + Math.pow(x, 2.0) - x) + 1.0 / 2.0 * Math.tan(x));
            default -> System.out.println("incorrect action.");
        }

        return result;
    }
}


