/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;

import Controller.Menu;
import Controller.GestorBD;

/**
 *
 * @author alber
 */
public class LibreriaMain {
    // Crear un objeto de la clase GestorBD

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        GestorBD gestor = new GestorBD();
        gestor.iniciar();
        boolean salir = false;

        try {
            while (!salir) {

                // Limpiar la pantalla
                System.out.print("\033[H\033[2J");

                // Crear un objeto de la clase Menu
                Menu menu = new Menu();

                // Llamar al método mostrarMenu
                menu.mostrarMenu();

                // Llamar al método elegirOpcion
                int opcion = menu.elegirOpcion();

                // Llamar al método ejecutarOpcion
                salir = menu.ejecutarOpcion(opcion);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
