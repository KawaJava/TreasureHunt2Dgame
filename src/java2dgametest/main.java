package java2dgametest;

import java.io.IOException;
import javax.swing.JFrame;

public class main {

    public static void main(String[] args) throws IOException {
       
       JFrame window = new JFrame();
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setResizable(false);
       window.setTitle("Treasure Hunt");
       
       GamePanel gamePanel=new GamePanel();
       window.add(gamePanel);
       
       window.pack();
       
       window.setLocationRelativeTo(null);
       window.setVisible(true);
       
       gamePanel.setupGame();
       gamePanel.startGameThread();
    }
    
}
