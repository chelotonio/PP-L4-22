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

        // Lista global que almacena los usuarios registrados.
        ArrayList<String> usuarios = new ArrayList<>();

        new VentanaLobby(usuarios).setVisible(true);

    }
}
