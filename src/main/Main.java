package main;

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

        Dobble dobble = new Dobble();
        Card card = new Card(arreglo);
        Player player = new Player("alo");

        DobbleGame dobbleGame;
        dobbleGame = new DobbleGame(dobble, player, "UserVsUser", 231);

        ArrayList<Card> aber = new ArrayList<>();
        Dobble dobblecs = new Dobble();
        aber = dobblecs.CardsSet(elements, 3, 4,3234);
        System.out.println(aber);


        ArrayList<ArrayList> cardsSetPrueba;
        ArrayList<String> stringCardsSet;

        // Lista global que almacena los usuarios registrados.
        ArrayList<String> usuarios = new ArrayList<>();
        ArrayList<ArrayList> cardsSet = new ArrayList<>();
        Integer playerAmount = 0;
        double tiempoJ1 = 0;
        double tiempoJ2 = 0;
        Integer turns = 1;

        new VentanaLobby(usuarios, cardsSet, playerAmount, turns, tiempoJ1, tiempoJ2).setVisible(true);

    }
}
