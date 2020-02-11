package Vista;

import Lógica.Cafeteria;
import Modelo.Cuenta;
import Modelo.Mesa;
import Modelo.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class TPVCafeteria {
    private JPanel panelMain;
    private JComboBox comboBoxMesas;
    private JTextArea textAreaProducto;
    private JTextArea textAreaPrecio;
    private JTextField textFieldTotal;
    private JButton buttonCaña;
    private JButton buttonPinta;
    private JButton buttonCarajillo;
    private JButton buttonMixto;
    private JButton buttonCatalana;
    private JButton buttonColacao;
    private JLabel mesaLabel;
    private JButton buttonCerrarMesa;
    private JTextArea textAreaCuenta;
    private JComboBox comboBoxCuentas;
    private JButton recuentoCajaButton;
    private JButton mesasAbiertasButton;
    private JButton mesasCerradasButton;
    private JTextArea textAreaConsultas;
    private JTabbedPane tabbedPane1;
    private Cafeteria cafeteria = new Cafeteria();
    private boolean mesaSeleccionada = false;

    public TPVCafeteria() {
        comboBoxMesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxMesas.getSelectedItem().equals("Seleccionar")) {
                    Mesa mesa = cafeteria.getMesa(comboBoxMesas.getSelectedIndex());
                    mesaLabel.setText("MESA SELECCIONADA: " + mesa.getNumeroMesa());
                    mesaSeleccionada = true;
                    actualizarDatos();
                }
            }
        });
            buttonCaña.addActionListener(getActionListenerButton("Caña"));
            buttonPinta.addActionListener(getActionListenerButton("Pinta"));
            buttonCarajillo.addActionListener(getActionListenerButton("Carajillo"));
            buttonMixto.addActionListener(getActionListenerButton("Mixto"));
            buttonCatalana.addActionListener(getActionListenerButton("Catalana"));
            buttonColacao.addActionListener(getActionListenerButton("Colacao"));

            comboBoxCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxCuentas.getSelectedItem().equals("Seleccionar")) {
                    textAreaCuenta.setText("");
                    textAreaCuenta.append(cafeteria.getCuenta(comboBoxCuentas.getSelectedIndex()).toString());
                }
            }
        }); buttonCerrarMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Mesa mesa = cafeteria.getMesa(comboBoxMesas.getSelectedIndex());
                    if (!mesa.isCerrada()) {
                        Cuenta cuenta = cafeteria.cerrarMesa(comboBoxMesas.getSelectedIndex());
                        comboBoxCuentas.addItem("Cuenta Nº" + cuenta.getNumeroCuenta() + " (Mesa " + cuenta.getNumeroMesa() + ")");
                        actualizarDatos();
                    }
                }
            }
        });
            recuentoCajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaConsultas.setText("");
                textAreaConsultas.append("El recuento de la caja actualmente es " + cafeteria.getRecuentoCaja() + "€");
            }
        }); mesasCerradasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaConsultas.setText("");
                textAreaConsultas.append("Mesas cerradas: " + cafeteria.getMesasCerradas());
            }
        }); mesasAbiertasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaConsultas.setText("");
                textAreaConsultas.append("Mesas abiertas: " + cafeteria.getMesasAbiertas());
            }
        });
    }

    public ActionListener getActionListenerButton(String nombreProducto) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mesaSeleccionada) {
                    Producto producto = cafeteria.getProducto(nombreProducto);
                    cafeteria.addProductoAMesa(comboBoxMesas.getSelectedIndex(), producto.getNombre());
                    actualizarDatos();
                }
            }
        };
        return actionListener;
    }

    public void actualizarDatos() {
        borrarDatos();
        Mesa mesa = cafeteria.getMesa(comboBoxMesas.getSelectedIndex());
        if (mesa.getProductos().size()>0) {
            Iterator<Producto> it = mesa.getProductos().iterator();
            while (it.hasNext()) {
                Producto producto = it.next();
                textAreaProducto.append("\n" + producto.getNombre());
                textAreaPrecio.append("\n" + producto.getPrecio() + "€");
                textFieldTotal.setText(cafeteria.getTotalMesa(mesa.getNumeroMesa()) + "€");
            }
        }
    }

    public void borrarDatos() {
        textAreaProducto.setText("");
        textAreaPrecio.setText("");
        textFieldTotal.setText("");
    }

    public JPanel getPanel() {
        return panelMain;
    }

    public JComboBox getComboBoxMesas() {
        return comboBoxMesas;
    }

    public JComboBox getComboBoxCuentas() {
        return comboBoxCuentas;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }
}
