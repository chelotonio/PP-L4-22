package main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase VentanaConfigurar
 * Clase que
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/11
 */

public class VentanaConfigurar extends JFrame implements ActionListener {

    ArrayList<String> usuarios;
    ArrayList<ArrayList> cardsSet;
    Integer playerAmount = 0;
    private JButton boton1;
    private JButton boton3;
    private JButton boton4;
    private JLabel lobbyLabel;
    private JLabel txtPlayers;
    private JTextField casillaPlayers;

    // Métodos de la clase.

    public VentanaConfigurar() {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Construir partida");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Se genera el boton y el texto que presenta.
        boton1 = new JButton("Crear nuevo set de cartas");
        boton3 = new JButton("Ingresar");
        boton4 = new JButton("Volver");
        lobbyLabel = new JLabel("Configure su partida");
        txtPlayers = new JLabel("Ingrese la cantidad de jugadores:");
        casillaPlayers = new JTextField(3);

        add(lobbyLabel);
        // Se agrega el botón a la ventana y se configura su disposición.
        add(boton1);
        boton1.setSize(200, 300);
        add(txtPlayers);
        add(casillaPlayers);
        add(boton3);
        boton3.setSize(200, 300);
        add(boton4);
        boton3.setSize(200, 300);

        // Se aplica un corrector de disposición de los elementos de la ventana.
        setLayout(new FlowLayout());

        // Se activa y dispone el botón para recibir una acción.
        boton1.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);

    }

    public VentanaConfigurar(ArrayList<String> lista, ArrayList<ArrayList> baraja) {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Construir partida");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Se genera el boton y el texto que presenta.
        boton1 = new JButton("Crear nuevo set de cartas");
        boton3 = new JButton("Ingresar");
        boton4 = new JButton("Volver");
        lobbyLabel = new JLabel("Configure su partida");
        txtPlayers = new JLabel("Ingrese la cantidad de jugadores:");
        casillaPlayers = new JTextField(3);

        add(lobbyLabel);
        // Se agrega el botón a la ventana y se configura su disposición.
        add(boton1);
        boton1.setSize(200, 300);
        add(txtPlayers);
        add(casillaPlayers);
        add(boton3);
        boton3.setSize(200, 300);
        add(boton4);
        boton3.setSize(200, 300);

        // Se aplica un corrector de disposición de los elementos de la ventana.
        setLayout(new FlowLayout());

        // Se activa y dispone el botón para recibir una acción.
        boton1.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);

        this.usuarios = lista;
        this.cardsSet = baraja;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            if(evento.getSource() == boton1) {
                // Se abre ventana que permite crear cardsSet ingresando NumE, MaxC, escoger simbolos, revolver baraja.
                dispose();
                new VentanaCardsSet(usuarios, cardsSet).setVisible(true);
            } else if(evento.getSource() == boton3) {
                String cJ = casillaPlayers.getText();
                int cantPlayers = Integer.parseInt(cJ);
                cantPlayers = playerAmount;
                String message = "Cantidad de jugadores ingresada con éxito";
                JOptionPane.showMessageDialog(this, message);
            } else if(evento.getSource() == boton4) {
                dispose();
                new VentanaLobby(usuarios, cardsSet).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}