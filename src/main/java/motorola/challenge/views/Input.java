package motorola.challenge.views;

import javax.swing.JOptionPane;

public class Input {
    static StringBuilder stringBuilder = new StringBuilder();

    public String drawInput() {
        
        stringBuilder.append("Please, type the String to be processed.");

        return JOptionPane.showInputDialog(stringBuilder.toString());
    }

}
