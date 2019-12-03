import com.google.gson.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class BusquedaJson {

    private JButton buscarButton;
    private JPanel panelMain;
    private JTextArea textComentario;
    private JTextArea textPeligrosidad;
    private JTextArea textNombre;
    private JTextField textBusqueda;
    private Aditivo[] aditivos;

    public BusquedaJson() {
        listaAditivos();
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPeligrosidad.setText("");
                textNombre.setText("");
                textComentario.setText("");

                // Bucle para buscar coincidencias de texto
                for (Aditivo aditivo : aditivos) {
                    if (aditivo.getComentario().contains(textBusqueda.getText()) |
                        aditivo.getNombre().contains(textBusqueda.getText()) |
                        aditivo.getNombre().contains(textBusqueda.getText())) {
                        textPeligrosidad.append(aditivo.getPeligrosidad() + "\n");
                        textNombre.append(aditivo.getNombre() + "\n");
                        textComentario.append(aditivo.getComentario() + "\n");
                    }
                }
            }
        });
    }

    public String fichero() {
        // Pasar fichero json a String.
        String fichero = "";
        try (BufferedReader br = new BufferedReader(new FileReader("aditivos.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                fichero += linea;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return fichero;
    }

    public void listaAditivos() {
        // Crear lista de objetos de la clase Aditivo y mostrarlos todos inicialmente.
        Gson gson = new Gson();
        aditivos = gson.fromJson(fichero(), Aditivo[].class);
        for (Aditivo aditivo : aditivos) {
            textPeligrosidad.append(aditivo.getPeligrosidad() + "\n");
            textNombre.append(aditivo.getNombre() + "\n");
            textComentario.append(aditivo.getComentario() + "\n");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BusquedaJson");
        frame.setContentPane(new BusquedaJson().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
