package main;

import java.util.ArrayList;

public class Dobble {

    private ArrayList<String> carta = new ArrayList<>();

    public ArrayList<ArrayList> CardsSet(ArrayList<String> Elements, int NumE, int MaxC, int Seed) {

        ArrayList<ArrayList> cardsSet = new ArrayList<>();
        ArrayList<String> card = new ArrayList<>();

        // Ciclo que genera la primera carta.
        for (int i = 1; i <= NumE; i++) {
            card.add(Elements.get(i - 1));
        }
        cardsSet.add(card);

        // Doble ciclo que genera las primeras n cartas.
        for (int j = 1; j <= NumE - 1; j++) {
            card = new ArrayList<String>();
            card.add(Elements.get(0));
            for (int k = 1; k <= NumE - 1; k++) {
                card.add(Elements.get(((NumE - 1) * j + ( k + 1 )) - 1));
            }
            cardsSet.add(card);
        }

        // Triple ciclo que genera las últimas n^2 cartas.
        for (int i = 1; i <= NumE - 1; i++) {
            for (int j = 1; j <= NumE - 1; j++) {
                card = new ArrayList<String>();
                card.add(Elements.get(i));
                for (int k = 1; k <= (NumE - 1); k++) {
                    card.add(Elements.get(((NumE - 1) + 2 + (NumE - 1) * (k-1) + (((i-1) * (k-1) + j - 1)%(NumE - 1))) - 1));
                }
                cardsSet.add(card);
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

    public ArrayList<String> cardsSetToString(ArrayList<ArrayList> cardsSet) {

        ArrayList<String> stringCardsSet = new ArrayList<>();

        for (int i = 0; i < cardsSet.size(); i++) {
            carta = cardsSet.get(i);
            String str = "";
            for (String elemento : carta) {
                str+= elemento+",";
            }
            stringCardsSet.add(str);
        }
        return stringCardsSet;
    }

}
