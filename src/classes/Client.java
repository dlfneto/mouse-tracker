package classes;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    Mouse mouse;
    Socket socket;
    PrintStream output;
    InputStream input;

    String server;
    int port;

    public Client(String server, int port){
        mouse = new Mouse();
        this.server = server;
        this.port = port;
    }

    public void connect() throws IOException, Exception {
        socket = new Socket(this.server, this.port);
        if(!socket.isConnected()) throw new Exception("Failed to connect!");
        output = new PrintStream(socket.getOutputStream());
        input = socket.getInputStream();
        if(output.checkError()) throw new Exception("Output error!");
        System.out.printf(".: Connected to: %s:%d :.\n", this.server, this.port);
    }


    public void emitPositionLoop(){

        Coord oldPosition = new Coord(this.mouse.position.x, this.mouse.position.y);
        System.out.println("Sending Coords!");
        while(true){
            oldPosition.setPosition(this.mouse.position.x, this.mouse.position.y);
            this.mouse.position.setPosition(Mouse.getX(), Mouse.getY());
            if(this.mouse.position.compare(oldPosition)) continue;
            try{
                Thread.sleep(10);
                this.output.println(this.mouse.position);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

            if(isServerDisconnected()){
                System.out.println("Server Disconnected! :^(");
                break;
            }
        }
    }

    private boolean isServerDisconnected() {
        try {
            socket.sendUrgentData(0);
            return false;
        } catch (IOException e) {
            return true;
        }
    }

}
