package main.view;

import main.Dobble;

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

public class TurnSet extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<String> usuarios;
    ArrayList<ArrayList> cardsSet;
    Integer playerAmount = 0;
    Integer turn = 0;
    double tiempoJ1 = 0;
    double tiempoJ2 = 0;
    private JButton sgteTurno;
    private JLabel label1;
    private JLabel label2;

    // Métodos de la clase.
    public TurnSet(ArrayList<String> lista, ArrayList<ArrayList> baraja, Integer cantidad, Integer numTurn, Double t1, Double t2) {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Generación de cardsSet");
        setSize(200, 200);
        setLocationRelativeTo(null);

        label1 = new JLabel("¡Correcto!");
        label2 = new JLabel("Es el turno del siguiente jugador");
        sgteTurno = new JButton("Comenzar turno");

        add(label1);
        add(label2);
        add(sgteTurno);

        setLayout(new FlowLayout());

        sgteTurno.addActionListener(this);

        this.usuarios = lista;
        this.cardsSet = baraja;
        this.playerAmount = cantidad;
        this.turn = numTurn;
        this.tiempoJ1 = t1;
        this.tiempoJ2 = t2;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == sgteTurno) {
                dispose();
                this.turn = turn + 1;
                new UserVsUser(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
