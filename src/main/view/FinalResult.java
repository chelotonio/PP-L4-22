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
    private JButton backMP;
    private JLabel label1;
    private JLabel label2;

    // Métodos de la clase.
    public FinalResult(ArrayList<String> lista, ArrayList<ArrayList> baraja, Integer cantidad) {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Resultado final");
        setSize(200, 200);
        setLocationRelativeTo(null);

        label1 = new JLabel("¡Partida Finalizada!");
        label2 = new JLabel("¡tantan ha ganado la partida!");
        backMP = new JButton("Volver al menú principal");

        add(label1);
        add(label2);
        add(backMP);

        setLayout(new FlowLayout());

        backMP.addActionListener(this);

        this.usuarios = lista;
        this.cardsSet = baraja;
        this.playerAmount = cantidad;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == backMP) {
                dispose();
                new UserVsUser(usuarios, cardsSet, playerAmount).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}

