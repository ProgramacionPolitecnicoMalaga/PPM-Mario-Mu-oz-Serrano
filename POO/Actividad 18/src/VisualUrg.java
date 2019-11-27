import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class VisualUrg {

    private JTextArea textListado;
    private JTextField textNombre;
    private JTextField textEdad;
    private JComboBox<String> comboTipoUrgencia;
    private JComboBox<String> comboGravedad;
    private JTextField textUltimoPaciente;
    private JPanel panelMain;
    private JButton registrarButton;
    private JButton atenderPacienteButton;
    private int prioridad;
    private String[] tipos = new String[11];
    private ListaEspera listaEspera = new ListaEspera();

    public VisualUrg() {
        obtenerListadoUrgencia();
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textListado.setText("");
                Incidencia incidencia = new Incidencia((String) comboTipoUrgencia.getSelectedItem(),getGravedad());
                prioridad = obtenerPrioridad(incidencia);
                listaEspera.añadirPaciente(new Paciente(textNombre.getText(), Integer.parseInt(textEdad.getText()), incidencia, prioridad));
                ordenarImprimirListado();
                }
            });

        atenderPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textListado.setText("");
                textUltimoPaciente.setText("");
                textUltimoPaciente.setText("Prioridad " + listaEspera.getPrimeroLista().getPrioridad() + ", nombre: " + listaEspera.getPrimeroLista().getNombre());
                listaEspera.getLista().remove(listaEspera.getPrimeroLista());
                ordenarImprimirListado();
            }
            });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Urgencias");
        frame.setContentPane(new VisualUrg().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));
    }

    public int obtenerPrioridad(Incidencia incidencia) {
        if (comboGravedad.getSelectedItem().equals("Grave")) {
            prioridad = 1;
        }
        else {
            for (int i = 0; i < tipos.length; i++) {
                if (tipos[i].equals(incidencia.getDescripcion())) {
                    prioridad = i + 1;
                }
            }
        }
        return prioridad;
    }

    public void ordenarImprimirListado() {
        Object[] arr = listaEspera.getLista().toArray();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            textListado.append(arr[i].toString());
        }
    }

    public boolean getGravedad() {
        if (comboGravedad.getSelectedItem().equals("Grave")) {
            return true;
        }
            return false;
    }

    public void obtenerListadoUrgencia() {
        String[] linea;
        BufferedReader br = null;
        int i = 0;
        try {
            br = new BufferedReader(new FileReader("tipos_urgencia.csv"));
            String line = br.readLine();
            while (null != line) {
                linea = line.split(";");
                tipos[i] = linea[1];
                comboTipoUrgencia.addItem(linea[1]);
                i++;
                line = br.readLine();
            }
            comboGravedad.addItem("Leve");
            comboGravedad.addItem("Grave");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
