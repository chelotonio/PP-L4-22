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

        ArrayList<String> arreglo = new ArrayList<>();

        Dobble dobble = new Dobble();
        Card card = new Card(arreglo);

        ArrayList<ArrayList> cardsSetPrueba;
        ArrayList<String> stringCardsSet;

        ArrayList<String> elementsNumbers1 = new ArrayList<>();
        elementsNumbers1.add("z");
        elementsNumbers1.add("b");
        elementsNumbers1.add("c");

        ArrayList<String> elementsNumbers2 = new ArrayList<>();
        elementsNumbers2.add("z");
        elementsNumbers2.add("b");
        elementsNumbers2.add("g");

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
