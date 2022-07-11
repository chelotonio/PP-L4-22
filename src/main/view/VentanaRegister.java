package main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase VentanaRegister
 * Clase que representa la ventana desde donde se pueden registrar los usuarios que iniciarán una partida.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/11
 */

public class VentanaRegister extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<String> usuarios = new ArrayList<>();
    private JTextField uTextField;
    private JButton agregarUsuario;
    private JButton botonBack;
    private JLabel usuarioLabel;
    DefaultListModel contenidoJlist;

    JList listaGraficaUsuarios;

    // Métodos de la clase.
    public VentanaRegister() {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Ventana de listas");
        setSize(200, 200);
        setLocationRelativeTo(null);

        usuarioLabel = new JLabel("Escriba un nombre de usuario");
        uTextField = new JTextField(5);
        agregarUsuario = new JButton("Agregar usuario");
        botonBack = new JButton("Volver");
        contenidoJlist = new DefaultListModel();
        var listaGraficaUsuarios = new JList(contenidoJlist);

        add(usuarioLabel);
        add(uTextField);
        add(agregarUsuario);
        add(botonBack);
        add(listaGraficaUsuarios);

        setLayout(new FlowLayout());

        agregarUsuario.addActionListener(this);
        botonBack.addActionListener(this);

    }

    // Constructor que recibe una lista de datos y la mantiene.
    public VentanaRegister(ArrayList<String> lista) {


        super("Ventana de listas");
        setSize(200, 200);
        setLocationRelativeTo(null);

        usuarioLabel = new JLabel("Escriba un nombre de usuario");
        uTextField = new JTextField(5);
        agregarUsuario = new JButton("Agregar usuario");
        botonBack = new JButton("Volver");
        contenidoJlist = new DefaultListModel();
        var listaGraficaUsuarios = new JList(contenidoJlist);

        add(usuarioLabel);
        add(uTextField);
        add(agregarUsuario);
        add(botonBack);
        add(listaGraficaUsuarios);

        setLayout(new FlowLayout());

        agregarUsuario.addActionListener(this);
        botonBack.addActionListener(this);

        // Se repilica la lista ingresada por parametro a la lista vacía generada por la ventana.
        this.usuarios = lista;

        // Se actualiza la lista gráfica con los usuarios ya ingresados anteriormente.
        for(int i = 0; i < usuarios.size(); i++) {
            contenidoJlist.addElement(usuarios.get(i));
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == agregarUsuario) {
                var nombre = uTextField.getText();
                if (usuarios.contains(nombre)) {
                    JOptionPane.showMessageDialog(this, "El usuario ingresado ya se encuentra registrado");
                } else {
                    // Se agrega a estructura de datos (List)
                    usuarios.add(nombre);
                    // Se agrega a elemento grafico (JList)
                    contenidoJlist.addElement(nombre);
                    JOptionPane.showMessageDialog(this, "Usuario ingresado con éxito");
                }

            } else if (e.getSource() == botonBack) {
                dispose();
                new VentanaLobby(usuarios).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
