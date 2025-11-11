import java.net.*;
import java.io.*;
import java.util.*;

public class SimpleClient {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleClient(String ip, int port) throws IOException{
        this.socket = new Socket(ip, port);
        System.out.println("Client connecting");
        InputStream i= socket.getInputStream();
        OutputStream o= socket.getOutputStream();
        this.in = new Scanner(i);
        this.out = new PrintWriter(o, true);

    }
    public void sendMessage(String message) {
        out.println(message);
    }
    public String receiveMessage() {
        return in.nextLine(); 
    }
    public void close() {

    }
  public static void main(String[] args) throws IOException {
        SimpleClient a= new SimpleClient("127.0.0.1", 8888);
        FileOperator file = new FileOperator("client.txt");
        while (true){
            String message = file.readline();
            if (message.equals("exit")){
                break;
            }
            System.out.println("Me: "+message);
            
            String server=a.receiveMessage();
            System.out.println("Server: "+server);
        }
        a.close();
    }
}
