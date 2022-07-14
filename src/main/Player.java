package main;

public class Player {

    private String player;

    public Player(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player='" + player + '\'' +
                '}';
    }
}
