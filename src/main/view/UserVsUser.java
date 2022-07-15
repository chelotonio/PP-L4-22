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
 * Clase UserVsUser
 * Clase que representa la ventana desde donde se pueden registrar los usuarios que iniciarán una partida.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/11
 */

public class UserVsUser extends JFrame implements ActionListener {

    // Atributos de la clase.
    ArrayList<Player> usuarios;
    ArrayList<Card> cardsSet;
    Integer playerAmount = 0;
    Integer turn = 0;
    Dobble dobble = new Dobble(cardsSet);
    Dobble setCartas = new Dobble(cardsSet);
    ArrayList<String> barajaString;
    String elementoCorrecto;
    double tiempoJ1 = 0;
    double tiempoJ2 = 0;
    Integer whoTurn = 1;
    long inicioEjecucion = System.nanoTime();

    private DobbleGame dobbleGame;
    private JTextField eComun;
    private JButton ingresarElemento;
    private JButton botonBack;
    private JLabel usuarioLabel;
    private JLabel turnL;
    DefaultListModel contenidoJl;
    DefaultListModel muestraParC;

    // Métodos de la clase.
    public UserVsUser(ArrayList<Player> lista, ArrayList<Card> baraja, Integer cantidad, Integer numTurn, Double t1, Double t2, DobbleGame dobbleGame) {

        super("User vs User");
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

        this.cardsSet = baraja;
        this.turn = numTurn;
        this.usuarios = lista;
        this.playerAmount = cantidad;
        this.tiempoJ1 = t1;
        this.tiempoJ2 = t2;
        this.dobbleGame = dobbleGame;

        barajaString = dobble.cardsSetToString(cardsSet);
        // Se randomiza la carta a escoger con un valor en el rango de las cartas.
        Integer n = cardsSet.size() - 2;
        Integer a = (int) Math.round(Math.random()*(n-0+1));
        Integer b = (int) Math.round(Math.random()*(n-0+1));

        Card ccc1 = cardsSet.get(a);
        Card ccc2 = cardsSet.get(b);

        ArrayList<String> cc1 = ccc1.getCarta();
        ArrayList<String> cc2 = ccc2.getCarta();

        String c1 = barajaString.get(a);
        String c2 = barajaString.get(b);

        elementoCorrecto = dobble.enComun(cc1, cc2);

        muestraParC.addElement(c1);
        muestraParC.addElement(c2);
        //
        if (turn % 2 == 1) {
            contenidoJl.addElement(usuarios.get(0));
        } else {
            contenidoJl.addElement(usuarios.get(1));
        }

        add(turnL);
        add(listaGraficaUsuarios);
        add(listaGraficaParCartas);
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
                var valorIngresado = eComun.getText();
                // if (valorIngresado.equals(elementoCorrecto))
                if (valorIngresado.equals(elementoCorrecto)) {
                    long finEjecución = System.nanoTime();
                    if(turn % 2 == 1) {
                        tiempoJ1 = tiempoJ1 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                    } else {
                        tiempoJ2 = tiempoJ2 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                    }
                    System.out.println(dobbleGame.getTurn());
                    // Si se completaron todos los turnos.
                    if (turn == playerAmount * 2) {
                        System.out.println("tiempo total j1:"+tiempoJ1);
                        System.out.println("tiempo total j2:"+tiempoJ2);
                        dispose();
                        new FinalResult(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);
                    } else {
                        dispose();
                        new TurnSet(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El elemento ingresado no es correcto, intente nuevamente");
                }

            } else if (e.getSource() == botonBack) {
                dispose();
                new VentanaLobby(usuarios, cardsSet, playerAmount, turn, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
