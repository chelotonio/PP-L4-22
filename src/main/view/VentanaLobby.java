package main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLobby extends JFrame implements ActionListener {
    private JButton boton1;
    public VentanaLobby() {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Ventana Principal");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Se genera el boton y el texto que presenta.
        boton1 = new JButton("Presionar boton 1");

        // Se agrega el botón a la ventana y se configura su disposición.
        add(boton1);
        boton1.setSize(200, 300);

        // Se aplica un corrector de disposición de los elementos de la ventana.
        setLayout(new FlowLayout());

        // Se activa y dispone el botón para recibir una acción.
        boton1.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            if(evento.getSource() == boton1) {
                String message = "Hola, has presionado el primer boton";
                JOptionPane.showMessageDialog(this, message);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
