import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tiradas {
    private JPanel panelMain;
    private JButton tiradaButton;
    private JTextField textMultiple;
    private JButton tiradaMultipleButton;
    private JButton limpiarButton;
    private JTextField txtCantidadTotalTiradas;
    private JTextField txtCruz;
    private JTextField txtPorcentajeCruz;
    private JTextField txtCara;
    private JTextField txtPorcentajeCara;
    private JLabel imgTirada;
    private JLabel txtResultadoTirada;
    private JLabel imgMultipleCara;
    private JLabel txtMultipleCara;
    private JLabel imgMultipleCruz;
    private JLabel txtMultipleCruz;
    private Moneda moneda = new Moneda();
    private static final int cara = 0;
    private static final int cruz = 1;
    private ImageIcon caraImg = new ImageIcon("cara.png");
    private ImageIcon cruzImg = new ImageIcon("cruz.png");
    private Image caraImagen = caraImg.getImage();
    private Image cruzImagen = cruzImg.getImage();


    public Tiradas() {
        tiradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                moneda.tirarMoneda();
                txtMultipleCara.setText("");
                txtMultipleCruz.setText("");
                imgMultipleCara.setIcon(null);
                imgMultipleCruz.setIcon(null);
                if (moneda.getTiradaUnica()==cara){
                    imgTirada.setIcon(new ImageIcon(caraImagen));
                    txtResultadoTirada.setText("Salió cara!");
                }
                if (moneda.getTiradaUnica()==cruz){
                    imgTirada.setIcon(new ImageIcon(cruzImagen));
                    txtResultadoTirada.setText("Salió cruz!");
                }
                txtCara.setText(String.valueOf(moneda.getCantidadTotalCara()));
                txtCruz.setText(String.valueOf(moneda.getCantidadTotalCruz()));
                txtCantidadTotalTiradas.setText(String.valueOf(moneda.getCantidadTotalTiradas()));
                txtPorcentajeCara.setText(String.valueOf((moneda.getCantidadTotalCara()*100/moneda.getCantidadTotalTiradas())));
                txtPorcentajeCruz.setText(String.valueOf((moneda.getCantidadTotalCruz()*100/moneda.getCantidadTotalTiradas())));
            }

        });

        tiradaMultipleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                while (!textMultiple.getText().equals("")) {
                    imgTirada.setIcon(null);
                    txtResultadoTirada.setText("");
                    imgMultipleCara.setIcon(new ImageIcon(caraImagen));
                    imgMultipleCruz.setIcon(new ImageIcon(cruzImagen));
                    moneda.tiradaMultiple(Integer.parseInt(textMultiple.getText()));
                    textMultiple.setText("");

                    txtCara.setText(String.valueOf(moneda.getCantidadTotalCara()));
                    txtMultipleCara.setText("Cara salió " + moneda.getCaraTiradaMultiple() + " veces!");
                    txtCruz.setText(String.valueOf(moneda.getCantidadTotalCruz()));
                    txtMultipleCruz.setText("Cruz salió " + moneda.getCruzTiradaMultiple() + " veces!");
                    txtCantidadTotalTiradas.setText(String.valueOf(moneda.getCantidadTotalTiradas()));
                    txtPorcentajeCara.setText(String.valueOf((moneda.getCantidadTotalCara()*100/moneda.getCantidadTotalTiradas())));
                    txtPorcentajeCruz.setText(String.valueOf((moneda.getCantidadTotalCruz()*100/moneda.getCantidadTotalTiradas())));
                    }
            }

        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                moneda.reiniciar();
                imgTirada.setIcon(null);
                imgMultipleCara.setIcon(null);
                imgMultipleCruz.setIcon(null);
                txtResultadoTirada.setText("");
                txtMultipleCara.setText("");
                txtMultipleCruz.setText("");
                txtCara.setText("");
                txtCruz.setText("");
                txtCantidadTotalTiradas.setText("");
                txtPorcentajeCara.setText("");
                txtPorcentajeCruz.setText("");
            }

        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cara o Cruz");
        frame.setContentPane(new Tiradas().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
