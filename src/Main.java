
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        int option;
        try{

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            option = JOptionPane.showOptionDialog(
                frame,
                "Escolha uma opção: ",
                "Remote Mouse Track",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[] {"Server", "Client"},
                JOptionPane.YES_OPTION
            );

            if(option == JOptionPane.YES_OPTION) TestServer.run();
            else if(option == JOptionPane.NO_OPTION) TestClient.run();
            else System.out.println("Bye :^)");
            
            frame.dispose();
            System.exit(0);

        }catch(Exception e){
            System.out.println(":^(");
        }

    }
}
