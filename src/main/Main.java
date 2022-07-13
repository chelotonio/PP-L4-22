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

        // Generación de listas de elementos:
        ArrayList<String> elementsNumbers = new ArrayList<>();
        elementsNumbers.add("1");
        elementsNumbers.add("2");
        elementsNumbers.add("3");
        elementsNumbers.add("4");
        elementsNumbers.add("5");
        elementsNumbers.add("6");
        elementsNumbers.add("7");
        elementsNumbers.add("8");
        elementsNumbers.add("9");
        elementsNumbers.add("10");
        elementsNumbers.add("11");
        elementsNumbers.add("12");
        elementsNumbers.add("13");

        cardsSetPrueba = dobble.CardsSet(elementsNumbers, 3, -1, 0);
        stringCardsSet = dobble.cardsSetToString(cardsSetPrueba);

        System.out.println(cardsSetPrueba);
        System.out.println(stringCardsSet);

        // Lista global que almacena los usuarios registrados.
        ArrayList<String> usuarios = new ArrayList<>();
        ArrayList<ArrayList> cardsSet = new ArrayList<>();
        Integer playerAmount = 0;
        double tiempoJ1 = 0;
        double tiempoJ2 = 0;
        Integer turns = 1;
        Integer whoTurn = 1;

        new VentanaLobby(usuarios, cardsSet, playerAmount, turns, tiempoJ1, tiempoJ2).setVisible(true);

    }
}
