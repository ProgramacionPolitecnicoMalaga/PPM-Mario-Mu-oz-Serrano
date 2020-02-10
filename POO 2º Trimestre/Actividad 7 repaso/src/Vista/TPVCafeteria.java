package Vista;

import Lógica.Cafeteria;
import Modelo.Cuenta;
import Modelo.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                    mesaLabel.setText("MESA SELECCIONADA: " + comboBoxMesas.getSelectedIndex());
                    mesaSeleccionada = true;
                }
            }
        });
            buttonCaña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Producto producto = cafeteria.getProducto("Caña");
                    cafeteria.addProductoAMesa(comboBoxMesas.getSelectedIndex(), producto.getNombre());
                    textAreaProducto.append("\n" + producto.getNombre());
                    textAreaPrecio.append("\n" + producto.getPrecio() + "€");
                    actualizarTotal(comboBoxMesas.getSelectedIndex());
                }
            }
        }); buttonPinta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Producto producto = cafeteria.getProducto("Pinta");
                    cafeteria.addProductoAMesa(comboBoxMesas.getSelectedIndex(), producto.getNombre());
                    textAreaProducto.append("\n" + producto.getNombre());
                    textAreaPrecio.append("\n" + producto.getPrecio() + "€");
                    actualizarTotal(comboBoxMesas.getSelectedIndex());
                }
            }
        }); buttonCarajillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Producto producto = cafeteria.getProducto("Carajillo");
                    cafeteria.addProductoAMesa(comboBoxMesas.getSelectedIndex(), producto.getNombre());
                    textAreaProducto.append("\n" + producto.getNombre());
                    textAreaPrecio.append("\n" + producto.getPrecio() + "€");
                    actualizarTotal(comboBoxMesas.getSelectedIndex());
                }
            }
        }); buttonMixto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Producto producto = cafeteria.getProducto("Mixto");
                    cafeteria.addProductoAMesa(comboBoxMesas.getSelectedIndex(), producto.getNombre());
                    textAreaProducto.append("\n" + producto.getNombre());
                    textAreaPrecio.append("\n" + producto.getPrecio() + "€");
                    actualizarTotal(comboBoxMesas.getSelectedIndex());
                }
            }
        }); buttonCatalana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Producto producto = cafeteria.getProducto("Catalana");
                    cafeteria.addProductoAMesa(comboBoxMesas.getSelectedIndex(), producto.getNombre());
                    textAreaProducto.append("\n" + producto.getNombre());
                    textAreaPrecio.append("\n" + producto.getPrecio() + "€");
                    actualizarTotal(comboBoxMesas.getSelectedIndex());
                }
            }
        }); buttonColacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Producto producto = cafeteria.getProducto("Colacao");
                    cafeteria.addProductoAMesa(comboBoxMesas.getSelectedIndex(), producto.getNombre());
                    textAreaProducto.append("\n" + producto.getNombre());
                    textAreaPrecio.append("\n" + producto.getPrecio() + "€");
                    actualizarTotal(comboBoxMesas.getSelectedIndex());
                }
            }
        }); buttonCerrarMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mesaSeleccionada) {
                    Cuenta cuenta = cafeteria.cerrarMesa(comboBoxMesas.getSelectedIndex());
                    comboBoxCuentas.addItem("Cuenta Nº" + cuenta.getNumeroCuenta() + " (Mesa " + cuenta.getNumeroMesa() + ")");
                    textAreaProducto.setText("");
                    textAreaPrecio.setText("");
                    textFieldTotal.setText("");
                }
            }
        }); comboBoxCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!comboBoxCuentas.getSelectedItem().equals("Seleccionar")) {
                    textAreaCuenta.setText("");
                    textAreaCuenta.append(cafeteria.getCuenta(comboBoxCuentas.getSelectedIndex()).toString());
                }
            }
        }); recuentoCajaButton.addActionListener(new ActionListener() {
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

    private void actualizarTotal(int numeroMesa) {
        textFieldTotal.setText(cafeteria.getTotalMesa(numeroMesa) + "€");
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
