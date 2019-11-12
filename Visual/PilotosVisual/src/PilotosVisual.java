import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;


public class PilotosVisual {
    public JTextArea textAreaCarrera;
    public JPanel panelMain;
    private JButton iniciarButton;
    private JButton CarreraButton;

    public PilotosVisual() {

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaCarrera.setText("");
                RankingPilotos rankingPilotos = new RankingPilotos();
                textAreaCarrera.append("\nPARRILLA DE SALIDA INICIAL:\n\n");
                rankingPilotos.AnadirPilotos();
                Iterator it = rankingPilotos.obtenerRanking().iterator();
                while (it.hasNext()) {
                    textAreaCarrera.append(((it.next().toString())));
                }
            }
        });

        CarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaCarrera.setText("");
                RankingPilotos rankingPilotos = new RankingPilotos();
                rankingPilotos.AnadirPilotos();
                textAreaCarrera.append("\nNUEVA CARRERA GENERADA:\n\n");
                rankingPilotos.generarCarrera();
                Iterator it = rankingPilotos.obtenerRanking().iterator();
                while (it.hasNext()) {
                    textAreaCarrera.append(((it.next().toString())));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Carrera de F1");
        frame.setContentPane(new PilotosVisual().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));
    }
}
