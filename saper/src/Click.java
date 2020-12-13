import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener {

    int score = 0;

    @Override
    public void mouseClicked (MouseEvent e){

        SaperJbutton  button = (SaperJbutton) e.getSource();
        int end;
        int win;

        if (e.getButton() == MouseEvent.BUTTON1) {
                if (button.isMine) {
                    button.isDiscovered = true;
                    button.setText("M");
                    button.setBackground(Color.red);
                    end = JOptionPane.showConfirmDialog(null, "Zakończ gre", "PRZEGRANA", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
                    if (end == JOptionPane.OK_OPTION || end == JOptionPane.CLOSED_OPTION)
                        System.exit(0);
                } else {

                    if(!button.isDiscovered)
                        score++;

                    button.isDiscovered = true;
                     button.setBackground(Color.blue);
                    button.setText(String.valueOf(button.minNumber));
                    if(score == 90) {
                        win = JOptionPane.showConfirmDialog(null, "Zakończ gre", "WYGRANA!!!", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
                            if (win == JOptionPane.OK_OPTION || win == JOptionPane.CLOSED_OPTION)
                                System.exit(0);
                    }
                }
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            if(!button.isDiscovered) {
                button.setText("F");
                button.setBackground(Color.green);
                button.isFlag = true;
                }
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
