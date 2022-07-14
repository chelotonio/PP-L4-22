package main;

import java.util.ArrayList;
import java.util.Objects;

public class Card {
    private ArrayList<String> carta;
    public Card(ArrayList<String> carta) {
        this.carta = carta;
    }
    public ArrayList<String> getCarta() {
        return carta;
    }
    public void setCarta(ArrayList<String> carta) {
        this.carta = carta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(getCarta(), card.getCarta());
    }
    @Override
    public String toString() {
        return "Card{" +
                "carta=" + carta +
                '}';
    }

    public Card agregarCarta(String string) {
        this.carta.add(string);
        Card card = new Card(carta);
        return card;
    }

}
