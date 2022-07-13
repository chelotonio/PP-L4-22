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

public class VentanaCardsSet extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<String> usuarios;
    ArrayList<ArrayList> cardsSet;
    Integer playerAmount = 0;
    ArrayList<Double> times = new ArrayList<>();
    Dobble dobble = new Dobble();
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
    public VentanaCardsSet(ArrayList<String> lista, ArrayList<ArrayList> baraja, Integer cantidad) {

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
                elementsAbecedary.add("A");
                elementsAbecedary.add("B");
                elementsAbecedary.add("C");
                elementsAbecedary.add("D");
                elementsAbecedary.add("E");
                elementsAbecedary.add("F");
                elementsAbecedary.add("G");
                elementsAbecedary.add("H");
                elementsAbecedary.add("I");
                elementsAbecedary.add("J");
                elementsAbecedary.add("K");
                elementsAbecedary.add("L");
                elementsAbecedary.add("M");

                cardsSet = dobble.CardsSet(elementsAbecedary, nE, mC, 1234);
                System.out.println(cardsSet);

                if (cardsSet.contains(numE)) {
                    JOptionPane.showMessageDialog(this, "El usuario ingresado ya se encuentra registrado");
                } else {
                    JOptionPane.showMessageDialog(this, "Set de cartas creado con éxito");
                }

            } else if (e.getSource() == botonBack) {
                dispose();
                System.out.println(cardsSet);
                new VentanaConfigurar(usuarios, cardsSet, playerAmount).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
