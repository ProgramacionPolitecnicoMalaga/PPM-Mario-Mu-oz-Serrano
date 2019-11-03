import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

public class Carrito {
    private JPanel panelMain;
    private JTextField textTotal;
    private JTextField textUnidades;
    private JTextField textProducto;
    private JButton comprarButton;
    private JButton reiniciarButton;
    private JTextArea textPrecioUnidad;
    private JTextArea textTotalPrecioCantidad;
    private JTextArea textNombreCantidad;
    private static final String SEPARADOR = ";";
    private String buscarCoincidencia;
    private Double precioTotal = 0.0;

    public Carrito() {
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String[] linea;
                buscarCoincidencia = textProducto.getText();
                BufferedReader br = null;

                try {
                    br = new BufferedReader(new FileReader("productos.csv"));
                    String line = br.readLine();
                    while (null != line) {

                        linea = line.split(SEPARADOR);

                        if (cleanString(linea[1].toUpperCase()).equals(cleanString(buscarCoincidencia.toUpperCase()))) {
                            if (textUnidades.getText().equals("")) {
                                textNombreCantidad.append("                                           " + "1");
                                textTotalPrecioCantidad.append("                                  " + Double.parseDouble(linea[4].replaceAll(",",".")) + "€" + "\n");
                                precioTotal += Double.parseDouble(linea[4].replaceAll(",","."));
                            }

                            else {
                                textNombreCantidad.append("                                           " + textUnidades.getText());
                                textTotalPrecioCantidad.append("                                  " + Double.parseDouble(linea[4].replaceAll(",","."))*Double.parseDouble(textUnidades.getText()) + "€" + "\n");
                                precioTotal += Double.parseDouble(linea[4].replaceAll(",","."))*Double.parseDouble(textUnidades.getText());
                            }

                            textNombreCantidad.append("                     " + linea[1] + "\n");
                            textPrecioUnidad.append("                                " + linea[4] + "€" + "\n");
                            textTotal.setText(String.valueOf(precioTotal) + "€");
                        }

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

        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                precioTotal = 0.0;
                textUnidades.setText("");
                textProducto.setText("");
                textNombreCantidad.setText("");
                textPrecioUnidad.setText("");
                textTotalPrecioCantidad.setText("");
                textTotal.setText("");
            }

        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tienda de productos");
        frame.setContentPane(new Carrito().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(900, 600));
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }

}
