import java.io.IOException;

import javax.swing.JOptionPane;

import classes.Client;

public class TestClient {
    public static void run() {

        String server = "0.0.0.0";
        int port = 0;

        while(port == 0) try{
            server = JOptionPane.showInputDialog("Insira o servidor:");        
            port = Integer.parseInt(JOptionPane.showInputDialog("Insira a porta:"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        Client client = new Client(server, port);
        
        try{
            client.connect();
            client.emitPositionLoop();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
