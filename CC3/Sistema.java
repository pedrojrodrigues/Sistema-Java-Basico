
package cc3;

import javax.swing.*;


public class Sistema {

    
    public static void main(String[] args) {
        String x = "";
        
        x = JOptionPane.showInputDialog("Entre com o nome");
        JOptionPane.showMessageDialog(null,
                "nome: " + x, "aula",
                JOptionPane.ERROR_MESSAGE);
    }
    
}
