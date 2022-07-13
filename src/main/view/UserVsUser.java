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

public class UserVsUser extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<String> usuarios;
    ArrayList<ArrayList> cardsSet;
    Integer playerAmount = 0;
    Integer turn = 0;
    Dobble dobble = new Dobble();
    double tiempoJ1 = 0;
    double tiempoJ2 = 0;
    Integer whoTurn = 1;
    long inicioEjecucion = System.nanoTime();
    private JTextField eComun;
    private JButton ingresarElemento;
    private JButton botonBack;
    private JLabel usuarioLabel;
    private JLabel turnL;
    DefaultListModel contenidoJl;
    DefaultListModel muestraParC;

    // Métodos de la clase.
    public UserVsUser(ArrayList<String> lista, ArrayList<ArrayList> baraja, Integer cantidad, Integer numTurn, Double t1, Double t2) {

        super("Dobble Game");
        setSize(400, 400);
        setLocationRelativeTo(null);

        usuarioLabel = new JLabel("Ingrese el elemento en común entre las dos cartas:");
        turnL = new JLabel("Es tu turno,");
        eComun = new JTextField(5);
        ingresarElemento = new JButton("Ingresar");
        botonBack = new JButton("Volver");
        contenidoJl = new DefaultListModel();
        muestraParC = new DefaultListModel();
        var listaGraficaUsuarios = new JList(contenidoJl);
        var listaGraficaParCartas = new JList(muestraParC);

        ArrayList<String> barajaString;

        this.cardsSet = baraja;
        this.turn = numTurn;
        this.usuarios = lista;
        this.playerAmount = cantidad;
        this.tiempoJ1 = t1;
        this.tiempoJ2 = t2;
        /*
        barajaString = dobble.cardsSetToString(cardsSet);
        // Se randomiza la carta a escoger con un valor en el rango de las cartas.
        Integer n = cardsSet.size();
        int a = (int) Math.round(Math.random()*(n+1));
        int b = (int) Math.round(Math.random()*(n+1));

        String c1 = barajaString.get(a);
        String c2 = barajaString.get(b);

        muestraParC.addElement(c1);
        muestraParC.addElement(c2);
        */
        if (turn % 2 == 1) {
            contenidoJl.addElement(usuarios.get(0));
        } else {
            contenidoJl.addElement(usuarios.get(1));
        }

        add(turnL);
        add(listaGraficaUsuarios);
        //add(listaGraficaParCartas);
        add(usuarioLabel);
        add(eComun);
        add(ingresarElemento);

        setLayout(new FlowLayout());

        ingresarElemento.addActionListener(this);
        botonBack.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == ingresarElemento) {
                var nombre = eComun.getText();
                // if (eComun.equals(elementoComunCorrecto)) .
                if (usuarios.contains(nombre)) {
                    long finEjecución = System.nanoTime();
                    if(turn % 2 == 1) {
                        tiempoJ1 = tiempoJ1 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                        System.out.println(tiempoJ1);
                    } else {
                        tiempoJ2 = tiempoJ2 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                        System.out.println(tiempoJ2);
                    }
                    System.out.println(turn);
                    // Si se completaron todos los turnos.
                    if (turn == playerAmount * 3) {
                        System.out.println("tiempo total j1:"+tiempoJ1);
                        System.out.println("tiempo total j2:"+tiempoJ2);
                        dispose();
                        new FinalResult(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2).setVisible(true);
                    } else {
                        dispose();
                        new TurnSet(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El elemento ingresado no es correcto, intente nuevamente");
                }

            } else if (e.getSource() == botonBack) {
                dispose();
                new VentanaLobby(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
