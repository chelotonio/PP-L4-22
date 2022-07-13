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

public class UserVsUser extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<String> usuarios;
    ArrayList<ArrayList> cardsSet;
    Integer playerAmount = 0;
    ArrayList<Double> times = new ArrayList<>();
    double tiempoJ1 = 0;
    double tiempoJ2 = 0;
    Integer whoTurn = 1;
    long inicioEjecucion = System.nanoTime();
    private JTextField eComun;
    private JButton ingresarElemento;
    private JButton botonBack;
    private JLabel usuarioLabel;
    private JLabel turn;
    DefaultListModel contenidoJlist;

    JList listaGraficaUsuarios;

    // Métodos de la clase.
    public UserVsUser(ArrayList<String> lista, ArrayList<ArrayList> baraja, Integer cantidad) {

        super("Dobble Game");
        setSize(400, 400);
        setLocationRelativeTo(null);

        usuarioLabel = new JLabel("Ingrese el elemento en común entre las dos cartas:");
        turn = new JLabel("Es tu turno,");
        eComun = new JTextField(5);
        ingresarElemento = new JButton("Ingresar");
        botonBack = new JButton("Volver");
        contenidoJlist = new DefaultListModel();
        var listaGraficaUsuarios = new JList(contenidoJlist);

        add(turn);
        add(listaGraficaUsuarios);
        add(usuarioLabel);
        add(eComun);
        add(ingresarElemento);
        add(botonBack);

        setLayout(new FlowLayout());

        ingresarElemento.addActionListener(this);
        botonBack.addActionListener(this);

        // Se repilica la lista ingresada por parametro a la lista vacía generada por la ventana.
        this.usuarios = lista;

        // Se actualiza la lista gráfica con los usuarios ya ingresados anteriormente.
        for(int i = 0; i < usuarios.size(); i++) {
            contenidoJlist.addElement(usuarios.get(i));
        }

        this.usuarios = lista;
        this.cardsSet = baraja;
        this.playerAmount = cantidad;
        // this.tiempoJ1 = times.;
        // this.tiempoJ2 = t2;
        // this.times = tiempos;
        // this.whoTurn = turn;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == ingresarElemento) {
                var nombre = eComun.getText();
                // if (eComun.equals(elementoComunCorrecto)) .
                if (usuarios.contains(nombre)) {
                    long finEjecución = System.nanoTime();
                    if(whoTurn == 1) {
                        tiempoJ1 = tiempoJ1 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                        System.out.println(tiempoJ1);
                    } else {
                        tiempoJ2 = tiempoJ2 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                        System.out.println(tiempoJ2);
                    }
                    // Si se completaron todos los turnos.
                    //if (Turns) {

                    //}
                    dispose();
                    new TurnSet(usuarios, cardsSet, playerAmount).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "El elemento ingresado no es correcto, intente nuevamente");
                }

            } else if (e.getSource() == botonBack) {
                dispose();
                new VentanaLobby(usuarios, cardsSet, playerAmount).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
