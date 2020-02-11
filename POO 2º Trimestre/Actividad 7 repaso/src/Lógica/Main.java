package Lógica;

import Vista.ControladorVistaTexto;
import Vista.TPVCafeteria;
import javax.swing.*;
import java.awt.*;

public class Main {

    private static TPVCafeteria tpv;
    private static ControladorVistaTexto vistaTexto;

    public static void main(String[] args) {
        tpv = new TPVCafeteria();
        vistaTexto = new ControladorVistaTexto();
        init();
        initVisual();

        //vistaTexto.inicializarVista();

        JFrame frame = new JFrame("TPV");
        frame.setContentPane(tpv.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void init(){
        for (int i=1; i<17; i++) {
            vistaTexto.cafeteria.addMesa(i);
        }
        // -------------------
        String[] nombresProducto = {"Caña","Pinta","Carajillo","Mixto","Catalana","Colacao"};
        double[] preciosProducto = {1.00,3.00,1.20,1.50,1.20,1.50};
        for (int i=0; i<nombresProducto.length; i++)
            vistaTexto.cafeteria.addProducto(nombresProducto[i],preciosProducto[i]);
    }

    public static void initVisual(){
        tpv.getComboBoxCuentas().addItem("Seleccionar");
        tpv.getComboBoxMesas().addItem("Seleccionar");
        for (int i=1; i<17; i++) {
            tpv.getCafeteria().addMesa(i);
            tpv.getComboBoxMesas().addItem("Mesa " + i);
        }
        // -------------------
        String[] nombresProducto = {"Caña","Pinta","Carajillo","Mixto","Catalana","Colacao"};
        double[] preciosProducto = {1.00,3.00,1.20,1.50,1.20,1.50};
        for (int i=0; i<nombresProducto.length; i++)
            tpv.getCafeteria().addProducto(nombresProducto[i],preciosProducto[i]);
    }
}
