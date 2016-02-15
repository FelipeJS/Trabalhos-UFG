package validacao;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Campos
 */
public class Validacao {

    public boolean Validacao1(String str) {
        final int MAX_VALUE = 6;
        final int MIN_VALUE = 1;

        if (str.length() > MAX_VALUE || str.length() < MIN_VALUE) {
            return false;
        } else if (Character.isDigit(str.charAt(0)) == true) {
            return false;
        } else if (str.contains("^[a-Z]") || (str.isEmpty())) {
            return false;
        } else if (str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_') {
            return false;
        } else {
            return true;
        }

    }
}
