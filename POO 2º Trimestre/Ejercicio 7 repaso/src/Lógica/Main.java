package Lógica;

import Vista.TPVCafeteria;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static TPVCafeteria tpv;
    public static void main(String[] args) {
        tpv = new TPVCafeteria();
        tpv.init();

        JFrame frame = new JFrame("TPV");
        frame.setContentPane(tpv.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
