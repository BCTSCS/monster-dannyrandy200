import java.net.*;
import java.io.*;
import java.util.*;


public class SimpleServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started and listening at "+port);
    }
    public void acceptClient() throws IOException {
        socket=serverSocket.accept();
        InputStream i = socket.getInputStream();
        OutputStream o = socket.getOutputStream();
        this.in = new Scanner(i);
        this.out = new PrintWriter(o, true);
    }
    public String receiveMessage() {
        return in.nextLine();
    }
    public void sendMessage(String message) {
        out.println(message);
    }
    public void close() {
    }
    public static void main(String[] args) throws IOException{
        SimpleServer s= new SimpleServer(8888);
        s.acceptClient();

        FileOperator file = new FileOperator("server.txt");
        while (true) {
            String user = s.receiveMessage();
            System.out.println("User: "+user);
            if (user.equals("exit")){
                break;
            }
            String response = file.readline();
            s.sendMessage(response);
            System.out.println("Us: "+response);
        }
        s.close();
    }
}

