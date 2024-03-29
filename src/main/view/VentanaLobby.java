package main.view;

import main.model.Card;
import main.model.Dobble;
import main.model.DobbleGame;
import main.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase VentanaLobby
 * Clase que representa la ventana principal desde la cual el usuario puede configurar e iniciar su partida.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/11
 */

public class VentanaLobby extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<Player> usuarios;
    ArrayList<Card> cardsSet;
    Dobble setCartas = new Dobble(cardsSet);
    Integer playerAmount = 0;
    Integer turn = 0;
    private DobbleGame dobbleGame;
    double tiempoJ1 = 0;
    double tiempoJ2 = 0;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JLabel lobbyLabel;

    // Métodos de la clase.
    public VentanaLobby(ArrayList<Player> lista, ArrayList<Card> baraja, Integer cantidad, Integer numTurn, Double t1, Double t2, DobbleGame dobbleGame) {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Menú Principal");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Se genera el boton y el texto que presenta.
        boton1 = new JButton("Jugar");
        boton2 = new JButton("Configurar nueva partida");
        boton3 = new JButton("Registrar jugadores");
        lobbyLabel = new JLabel("¡Bienvenido a Dobble!");

        add(lobbyLabel);
        // Se agrega el botón a la ventana y se configura su disposición.
        add(boton1);
        boton1.setSize(200, 300);
        add(boton2);
        boton2.setSize(200, 300);
        add(boton3);
        boton3.setSize(200, 300);

        // Se aplica un corrector de disposición de los elementos de la ventana.
        setLayout(new FlowLayout());

        // Se activa y dispone el botón para recibir una acción.
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);

        this.usuarios = lista;
        this.cardsSet = baraja;
        this.playerAmount = cantidad;
        this.turn = numTurn;
        this.tiempoJ1 = t1;
        this.tiempoJ2 = t2;
        this.dobbleGame = dobbleGame;

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            if(evento.getSource() == boton1) {
                dispose();
                new UserVsUser(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);
            } else if(evento.getSource() == boton2) {
                dispose();
                new VentanaConfigurar(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);
            } else if(evento.getSource() == boton3) {
                dispose();
                new VentanaRegister(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
