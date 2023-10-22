package classes;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    ServerSocket socket;
    Socket client;
    Mouse mouse;

    int port;

    Scanner input;

    public Server(int port){
        this.port = port;
        this.mouse = new Mouse();
    }

    public void initialize() throws IOException{
        socket = new ServerSocket(port);
        System.out.printf(".: Server Initialized on %s:%d :.\n", this.socket.getInetAddress().getHostAddress(), this.port);
    }

    public void listen() throws IOException, AWTException{
        client = this.socket.accept();
        System.out.printf(".! Client Connected - %s !.\n", this.client.getInetAddress().getHostAddress());

        InputStream inputStream = client.getInputStream();
        input = new Scanner(inputStream);

        Coord newPosition = new Coord(mouse.position.x, mouse.position.y);
        Robot bot = new Robot();
        while(input.hasNextLine()){
            newPosition.setPosition(input.nextLine());
            mouse.position.setPosition(newPosition.x, newPosition.y);
            System.out.println("Received Position: " + mouse.position);
            bot.mouseMove(newPosition.x, newPosition.y);
        }

        System.out.printf(".! Client Disconnected - %s !.\n", this.client.getInetAddress().getHostAddress());
    }
}
