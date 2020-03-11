import com.politecnicomalaga.controlador.ControladorEmpleados;
import com.politecnicomalaga.vista.VistaEmpleados;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {

        VistaEmpleados vistaEmpleados = new VistaEmpleados(new ControladorEmpleados());
        JFrame frame = new JFrame("Empleados");
        frame.setContentPane(vistaEmpleados.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
