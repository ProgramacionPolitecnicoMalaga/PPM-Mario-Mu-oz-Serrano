package com.politecnicomalaga;
import com.politecnicomalaga.controlador.ControladorCredenciales;
import com.politecnicomalaga.vista.UIPrincipal;
import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        UIPrincipal uiPrincipal = new UIPrincipal(new ControladorCredenciales());
        JFrame frame = new JFrame("Credenciales");
        frame.setContentPane(uiPrincipal.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1200, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
