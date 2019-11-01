import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hipotenusa {
    private JPanel panelMain;
    private JTextField txtCateto1;
    private JButton butAnadir;
    private JTextField txtCateto2;
    private JTextField txtHipotenusa;
    private JLabel hipotenusa;
    private JLabel cateto1txt;
    private JLabel cateto2txt;
    private double cateto1;
    private double cateto2;

    public Hipotenusa() {
        butAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cateto1 = Double.parseDouble(txtCateto1.getText());
                cateto2 = Double.parseDouble(txtCateto2.getText());
                txtHipotenusa.setText(String.valueOf(hipotenusa()));
                txtCateto1.setText("");
                txtCateto2.setText("");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculo de hipotenusa");
        frame.setContentPane(new Hipotenusa().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private double hipotenusa() {
        double hipotenusa;
        hipotenusa = Math.hypot(cateto1, cateto2);
        return hipotenusa;
    }

}
