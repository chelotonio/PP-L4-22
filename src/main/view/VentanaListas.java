package main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaListas extends JFrame implements ActionListener {

    private List<String> usuarios = new ArrayList<>();
    private JTextField uTextField;
    private JButton agregarUsuario;
    private JButton botonBack;
    private JLabel usuarioLabel;
    DefaultListModel contenidoJlist;

    JList listaGraficaUsuarios;

    public VentanaListas() {
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarUsuario) {
            var nombre = uTextField.getText();
            if (usuarios.contains(nombre)) {
                JOptionPane.showMessageDialog(this, "El usuario ingresado ya se encuentra registrado");
            } else {
                // Se agrega a estructura de datos (List)
                usuarios.add(nombre);
                // Se agrega a elemento grafico (JList)
                contenidoJlist.addElement(nombre);
            }

        } else if (e.getSource() == botonBack) {
            dispose();
            new VentanaLobby().setVisible(true);
        }
    }
}
