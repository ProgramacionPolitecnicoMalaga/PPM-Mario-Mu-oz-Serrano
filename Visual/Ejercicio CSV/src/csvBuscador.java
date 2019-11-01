import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

public class csvBuscador {
    private JPanel panelMain;
    private JTextField textBuscar;
    private JButton buscarButton;
    private JTextArea textResultados;
    private static final String SEPARADOR = ";";
    private String buscarCoincidencia;

    public csvBuscador() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String[] linea;
                buscarCoincidencia = textBuscar.getText();
                BufferedReader br = null;

                try {
                    br = new BufferedReader(new FileReader("productos.csv"));
                    String line = br.readLine();
                    textResultados.setText("");
                    while (null != line) {
                        linea = line.split(SEPARADOR);
                        textResultados.append(buscarProductos(linea));
                        line = br.readLine();
                    }

                } catch (Exception e) {
                    System.err.println("Error! " + e.getMessage());
                } finally {
                    if (null != br) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            System.err.println("Error closing file !! " + e.getMessage());
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Buscador de productos");
        frame.setContentPane(new csvBuscador().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));
    }

    public String buscarProductos(String[] linea){
        String resultadosBusqueda = "";
        OrdenarProductos ordenarProductos = new OrdenarProductos();
        if (cleanString(linea[1].toUpperCase()).contains(buscarCoincidencia.toUpperCase())) {
            resultadosBusqueda = ordenarProductos.ordenarProductos(linea);
        }

        else if (cleanString(linea[2].toUpperCase()).contains(buscarCoincidencia.toUpperCase())) {
            resultadosBusqueda = ordenarProductos.ordenarProductos(linea);
        }
        return resultadosBusqueda;
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
}


