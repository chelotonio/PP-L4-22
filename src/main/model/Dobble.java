package main.model;

import java.util.ArrayList;
import java.util.Objects;

public class Dobble {

    private Card carta;
    private ArrayList<Card> cartas;

    public Dobble(ArrayList<Card> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Card> CardsSet(ArrayList<String> Elements, int NumE, int MaxC, int Seed) {

        ArrayList<Card> cardsSet = new ArrayList<>();
        ArrayList<String> card = new ArrayList<>();
        Card cartaAux = new Card(card);

        // Ciclo que genera la primera carta.
        for (int i = 1; i <= NumE; i++) {
            cartaAux.agregarCarta(Elements.get(i - 1));
        }
        cardsSet.add(cartaAux);

        // Doble ciclo que genera las primeras n cartas.
        for (int j = 1; j <= NumE - 1; j++) {
            card = new ArrayList<String>();
            cartaAux = new Card(card);
            cartaAux.agregarCarta(Elements.get(0));
            for (int k = 1; k <= NumE - 1; k++) {
                cartaAux.agregarCarta(Elements.get(((NumE - 1) * j + ( k + 1 )) - 1));
            }
            cardsSet.add(cartaAux);
        }

        // Triple ciclo que genera las últimas n^2 cartas.
        for (int i = 1; i <= NumE - 1; i++) {
            for (int j = 1; j <= NumE - 1; j++) {
                card = new ArrayList<String>();
                cartaAux = new Card(card);
                cartaAux.agregarCarta(Elements.get(i));
                for (int k = 1; k <= (NumE - 1); k++) {
                    cartaAux.agregarCarta(Elements.get(((NumE - 1) + 2 + (NumE - 1) * (k-1) + (((i-1) * (k-1) + j - 1)%(NumE - 1))) - 1));
                }
                cardsSet.add(cartaAux);
            }
        }

        // Si el parametro MaxC es distinto de -1, se eliminan los elementos sobrantes.
        if (MaxC != -1) {
            int max = ((NumE - 1) * (NumE - 1)) + (NumE - 1) + 1;
            for (int i = 0; i < max - MaxC; i++) {
                cardsSet.remove(max - i - 1);
            }
        }

        return cardsSet;
    }

    public ArrayList<Card> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Card> cartas) {
        this.cartas = cartas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dobble dobble = (Dobble) o;
        return Objects.equals(getCartas(), dobble.getCartas());
    }

    @Override
    public String toString() {
        return "Dobble{" +
                "cartas=" + cartas +
                '}';
    }

    public String enComun(ArrayList<String> c1, ArrayList<String> c2) {

        for(int i = 0; i < c1.size(); i++) {
            for (int j = 0; j < c1.size(); j++) {
                if (c1.get(i) == c2.get(j)) {
                    return c1.get(i);
                }
            }
        }
        return "s";
    }

    public ArrayList<String> cardsSetToString(ArrayList<Card> cardsSet) {

        ArrayList<String> stringCardsSet = new ArrayList<>();

        for (int i = 0; i < cardsSet.size(); i++) {
            this.carta = cardsSet.get(i);
            ArrayList<String> cartaString = carta.getCarta();
            String str = "";
            for (String elemento : cartaString) {
                str+= elemento+",";
            }
            stringCardsSet.add(str);
        }
        return stringCardsSet;
    }

}
