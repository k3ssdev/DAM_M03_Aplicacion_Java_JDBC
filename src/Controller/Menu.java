package Controller;


public class Menu {

    public void mostrarMenu() {
        
     
        

        System.out.println("+=======================================+");
        System.out.println("|             ==== MENÚ ====            |");
        System.out.println("+=======================================+");
        System.out.println("| 1. Restablecer base de datos          |");
        System.out.println("| 2. Mostrar autores                    |");
        System.out.println("| 3. Mostrar libros                     |");
        System.out.println("| 4. Modificar autor                    |");
        System.out.println("| 5. Borrar libro                       |");
        System.out.println("| 6. Salir                              |");
        System.out.println("+=======================================+");
        
        System.out.println();

    }

    // Metodo para elegir una opcion del menu
    public int elegirOpcion() {


        // Llamar al metodo pideEntero
        int opcion = Teclado.pideEntero("Elige una opcion: ");

        // Devolver la opcion elegida
        return opcion;

    }

    // metodo con el switch-case
    public boolean ejecutarOpcion(int opcion) {

        boolean salir = false;

        // Crear un objeto de la clase GestorBD
        GestorBD gestor = new GestorBD();

        // Crear un objeto de la clase Teclado
        Teclado teclado = new Teclado();

        switch (opcion) {

            case 1:
                // Llamar al metodo restablecerBD
                gestor.restablecerBD();
                teclado.pausa();
                break;

            case 2:
                // Llamar al metodo mostrarAutores
                gestor.mostrarAutores();
                teclado.pausa();
                break;

            case 3:
                // Llamar al metodo mostrarLibros
                gestor.mostrarLibros();
                teclado.pausa();
                break;

            case 4:
                // Llamar al metodo modificarAutor
                gestor.modificarAutor();
                teclado.pausa();
                break;

            case 5:
                // Llamar al metodo borrarLibro
                gestor.borrarLibro();
                teclado.pausa();
                break;

            case 6:
                // Salir
                System.out.println("Saliendo...");
                System.out.println();
                salir = true;
                break;

            default:
                // Mensaje de error
                System.out.println("Error: opcion no valida");
                break;

        }
        return salir;

    }

}
