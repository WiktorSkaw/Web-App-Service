import javax.swing.*;

public class SaperJbutton extends JButton {

    boolean isMine;
    boolean isDiscovered;
    boolean isFlag;
    int     minNumber;

    SaperJbutton() {
        isMine = false;
        isDiscovered = false;
        isFlag = false;
    }
}
