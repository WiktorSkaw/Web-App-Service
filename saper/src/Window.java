import javax.swing.*;
import java.awt.*;

public class Window extends JFrame  {

    Board ob = new Board(10,10);


    public void run(){
         JFrame frame;

        frame = new JFrame();
        Click click = new Click();

        for(int i = 0; i < 10; i++ ){       // wypelnienie okna 100 przyciskami
            for(int j = 0; j < 10; j++ ) {
                frame.add(ob.board[i][j]);
                ob.board[i][j].addMouseListener(click);
            }
        }

        frame.setVisible(true);                       // ustawienia okna
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridLayout(10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Saper");
        frame.setResizable(false);
    }




}