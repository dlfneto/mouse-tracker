import java.io.IOException;

import javax.swing.JOptionPane;

import classes.Server;

public class TestServer {
    public static void run() {

        int port = 0;
        
        while(port == 0) try{
            port = Integer.parseInt(JOptionPane.showInputDialog("Insira a porta:"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Insira uma porta válida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        Server server = new Server(port);

        try{
            server.initialize();
            server.listen();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
