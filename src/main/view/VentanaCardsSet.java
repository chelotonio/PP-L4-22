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
 * Clase VentanaCardsSet
 * Clase que representa la ventana desde donde se puede crear un nuevo set de cartas a partir de la cantidad de elementos y el número de cartas.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/11
 */

public class VentanaCardsSet extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<Player> usuarios;
    ArrayList<Card> cardsSet;
    Dobble setCartas = new Dobble(cardsSet);
    Integer playerAmount = 0;
    Integer turn = 0;
    double tiempoJ1 = 0;
    double tiempoJ2 = 0;
    Dobble dobble = new Dobble(cardsSet);

    private DobbleGame dobbleGame = new DobbleGame(setCartas, playerAmount, "Player vs Player", 4234, usuarios, turn);
    private JTextField numEtf;
    private JTextField maxCtf;
    private JButton crearBaraja;
    private JButton botonBack;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    DefaultListModel contenidoJlist;

    JList listaGraficaUsuarios;

    // Métodos de la clase.
    public VentanaCardsSet(ArrayList<Player> lista, ArrayList<Card> baraja, Integer cantidad, Integer numTurn, Double t1, Double t2, DobbleGame dobbleGame) {

        // Se establecen las disposiciones y componentes básicos de una ventana.
        super("Generación de cardsSet");
        setSize(200, 200);
        setLocationRelativeTo(null);

        label1 = new JLabel("Ingrese los siguientes datos:");
        label2 = new JLabel("Cantidad de elementos:");
        label3 = new JLabel("Cantidad de cartas:");
        numEtf = new JTextField(3);
        maxCtf = new JTextField(3);
        crearBaraja = new JButton("Crear baraja");
        botonBack = new JButton("Volver");
        contenidoJlist = new DefaultListModel();
        var listaGraficaUsuarios = new JList(contenidoJlist);

        add(label1);
        add(label2);
        add(numEtf);
        add(label3);
        add(maxCtf);
        add(crearBaraja);
        add(botonBack);
        add(listaGraficaUsuarios);

        setLayout(new FlowLayout());

        crearBaraja.addActionListener(this);
        botonBack.addActionListener(this);

        this.usuarios = lista;
        this.cardsSet = baraja;
        this.playerAmount = cantidad;
        this.turn = numTurn;
        this.tiempoJ1 = t1;
        this.tiempoJ2 = t2;
        this.dobbleGame = dobbleGame;



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == crearBaraja) {

                String numE = numEtf.getText();
                String maxC = maxCtf.getText();

                // Convertir Strings a Integer.
                int nE = Integer.parseInt(numE);
                int mC = Integer.parseInt(maxC);

                // Se genera una lista de elementos para construir un cardsSet.
                ArrayList<String> elementsAbecedary = new ArrayList<>();
                elementsAbecedary.add("a");
                elementsAbecedary.add("b");
                elementsAbecedary.add("c");
                elementsAbecedary.add("d");
                elementsAbecedary.add("e");
                elementsAbecedary.add("f");
                elementsAbecedary.add("g");
                elementsAbecedary.add("h");
                elementsAbecedary.add("i");
                elementsAbecedary.add("j");
                elementsAbecedary.add("k");
                elementsAbecedary.add("l");
                elementsAbecedary.add("m");

                cardsSet = dobble.CardsSet(elementsAbecedary, nE, mC, 1234);
                System.out.println(cardsSet);

                if (cardsSet.contains(numE)) {
                    JOptionPane.showMessageDialog(this, "El usuario ingresado ya se encuentra registrado");
                } else {
                    JOptionPane.showMessageDialog(this, "Set de cartas creado con éxito");
                }

            } else if (e.getSource() == botonBack) {
                dispose();
                new VentanaConfigurar(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
