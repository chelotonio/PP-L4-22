package main;
import main.view.VentanaLobby;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> usuarios = new ArrayList<>();

        new VentanaLobby(usuarios).setVisible(true);

    }
}
