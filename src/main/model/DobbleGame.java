package main.model;

import java.util.ArrayList;

/**
 * Clase DobbleGame
 * Clase desde la cual se reciben todos los TDA, desde los cuales se construye una partida.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/14
 */

public class DobbleGame {


    private Dobble dobble;
    private int numPlayers;
    private String mode;
    private Integer seed;
    private ArrayList<Player> players;
    private int turn;

    // Constructor de DobbleGame.


    public DobbleGame(Dobble dobble, int numPlayers, String mode, Integer seed, ArrayList<Player> players, int turn) {
        this.dobble = dobble;
        this.numPlayers = numPlayers;
        this.mode = mode;
        this.seed = seed;
        this.players = players;
        this.turn = turn;
    }

    public Dobble getDobble() {
        return dobble;
    }

    public void setDobble(Dobble dobble) {
        this.dobble = dobble;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "DobbleGame{\n" +
                "dobble=" + dobble +
                ", \nnumPlayers=" + numPlayers +
                ", \nmode='" + mode + '\'' +
                ", \nseed=" + seed +
                ", \nplayers=" + players +
                ", \nturn=" + turn +
                '}';
    }

    public DobbleGame dobbleGameRegister(String user, DobbleGame dgi) {

        Player player = new Player(user);

        if (dgi.players.contains(player)) {
            System.out.println("El usuario ingresado ya está registrado.");
            return dgi;
        }
        System.out.println("¡Usuario ingresado con éxito!");
        dgi.players.add(player);
        return dgi;

    }
    public String whoseTurnIsIt (DobbleGame partida) {

        return "a";
    }

}

