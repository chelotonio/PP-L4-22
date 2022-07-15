package main;

import main.model.Card;
import main.model.Dobble;
import main.model.DobbleGame;
import main.model.Player;
import main.view.VentanaLobby;

import java.util.ArrayList;

/**
 * Clase Main
 * Clase desde la cual se inician las operaciones correspondientes a todas las clases existentes.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/11
 */

public class Main {
    public static void main(String[] args) {

        ArrayList<String> elements = new ArrayList<>();

        elements.add("a");
        elements.add("b");
        elements.add("c");
        elements.add("d");
        elements.add("e");
        elements.add("f");
        elements.add("g");
        elements.add("h");
        elements.add("i");
        elements.add("j");
        elements.add("k");
        elements.add("l");
        elements.add("m");

        ArrayList<String> arreglo = new ArrayList<>();

        ArrayList<Card> baraja = new ArrayList<>();

        // Se inicializa set Dobble.
        Dobble dobble = new Dobble(baraja);
        Dobble setCartas;

        baraja = dobble.CardsSet(elements, 3, 4,3234);
        System.out.println(baraja);

        Card card = new Card(arreglo);
        Player player = new Player("Pedro");
        setCartas = new Dobble(baraja);

        DobbleGame dobbleGame;

        ArrayList<ArrayList> cardsSetPrueba;
        ArrayList<String> stringCardsSet;

        // Lista global que almacena los usuarios registrados.
        ArrayList<Player> usuarios = new ArrayList<>();
        ArrayList<Card> cardsSet = new ArrayList<>();
        Integer playerAmount = 0;
        double tiempoJ1 = 0;
        double tiempoJ2 = 0;
        Integer turns = 1;

        dobbleGame = new DobbleGame(setCartas, playerAmount, "UserVsUser", 231, usuarios, turns);
        System.out.println(dobbleGame);

        new VentanaLobby(usuarios, cardsSet, playerAmount, turns, tiempoJ1, tiempoJ2, dobbleGame).setVisible(true);

    }
}
