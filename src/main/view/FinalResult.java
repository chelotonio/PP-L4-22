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

public class FinalResult extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<String> usuarios;
    ArrayList<ArrayList> cardsSet;
    Integer playerAmount = 0;
    Integer turn = 0;
    double tiempoJ1 = 0;
    double tiempoJ2 = 0;
    private JButton backMP;
    private JLabel label1;
    private JLabel label2;
    DefaultListModel contenidoJlist;

    // Métodos de la clase.
    public FinalResult(ArrayList<String> lista, ArrayList<ArrayList> baraja, Integer cantidad, Integer numTurn, Double t1, Double t2) {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Resultado final");
        setSize(200, 200);
        setLocationRelativeTo(null);

        label1 = new JLabel("¡Partida Finalizada!");
        label2 = new JLabel("ha ganado la partida!");
        backMP = new JButton("Volver al menú principal");
        contenidoJlist = new DefaultListModel();
        var listaGraficaUsuarios = new JList(contenidoJlist);

        this.usuarios = lista;
        this.tiempoJ1 = t1;
        this.tiempoJ2 = t2;

        if(tiempoJ1 < tiempoJ2) {
            contenidoJlist.addElement(usuarios.get(0));
        } else {
            contenidoJlist.addElement(usuarios.get(1));
        }

        add(label1);
        add(listaGraficaUsuarios);
        add(label2);
        add(backMP);

        setLayout(new FlowLayout());

        backMP.addActionListener(this);

        this.cardsSet = baraja;
        this.playerAmount = cantidad;
        this.turn = numTurn;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == backMP) {
                dispose();
                new VentanaLobby(usuarios, cardsSet, playerAmount, 1, 0.0, 0.0).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}

