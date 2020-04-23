
import com.politecnicomalaga.vista.VistaPrincipal;
import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        VistaPrincipal uiPrincipal = new VistaPrincipal();
        JFrame frame = new JFrame("Mensajería");
        frame.setContentPane(uiPrincipal.getpanelMain());
        frame.getRootPane().setDefaultButton(uiPrincipal.getAceptarButton());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
