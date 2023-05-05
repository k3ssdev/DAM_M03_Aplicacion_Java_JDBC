package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Autor;
import Model.Libro;

/**
 * Clase que gestiona la base de datos
 * 
 * @version 1.0
 */

public class GestorBD {

    private static String datosConexion = "jdbc:mysql://localhost:3306/";
    private static String baseDatos = "libreria";
    private static String usuario = "root";
    private static String password = "";
    private Connection con;

    public void iniciar() {
        try {
            con = DriverManager.getConnection(datosConexion, usuario, password);

            // Llamar al metodo crearBD
            crearBD();

            // Llamar al metodo crearTablas
            crearTablas();

            // Cerrar la conexion
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
    }

    public void conectar() {
        try {
            con = DriverManager.getConnection(datosConexion + baseDatos, usuario, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
    }

    private void crearBD() {

        try {
            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Crear la base de datos
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + baseDatos);

            // Seleccionar la base de datos
            st.executeUpdate("USE " + baseDatos);

            // Cerrar conexión y recursos
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos");
        }
    }

    private void crearTablas() {
        try {
            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Crear tabla autores
            st.executeUpdate("CREATE TABLE IF NOT EXISTS autores ("
                    + "id INT NOT NULL AUTO_INCREMENT,"
                    + "nombre VARCHAR(50) NOT NULL,"
                    + "apellidos VARCHAR(50) NOT NULL,"
                    + "nacionalidad VARCHAR(50) NOT NULL,"
                    + "PRIMARY KEY (id))");

            // Crear tabla libros
            st.executeUpdate("CREATE TABLE IF NOT EXISTS libros ("
                    + "id INT NOT NULL AUTO_INCREMENT,"
                    + "titulo VARCHAR(50) NOT NULL,"
                    + "id_autor INT NOT NULL,"
                    + "pais VARCHAR(50) NOT NULL,"
                    + "paginas INT NOT NULL,"
                    + "genero VARCHAR(50) NOT NULL,"
                    + "PRIMARY KEY (id),"
                    + "FOREIGN KEY (id_autor) REFERENCES autores(id))");

            // Insertar datos en la tabla autores si esta vacia
            ResultSet rs = st.executeQuery("SELECT * FROM autores");

            // comprobar si rs esta vacio
            if (!rs.next()) {
                // Insertar datos en la tabla autores
                st.executeUpdate("INSERT INTO autores (nombre, apellidos, nacionalidad) VALUES"
                        + "('Isaac', 'Asimov', 'Estadounidense'),"
                        + "('Arthur C.', 'Clarke', 'Britanico'),"
                        + "('Frank', 'Herbert', 'Estadounidense'),"
                        + "('George R. R.', 'Martin', 'Estadounidense'),"
                        + "('J. R. R.', 'Tolkien', 'Britanico')");
            }

            // Insertar datos en la tabla libros si esta vacia
            rs = st.executeQuery("SELECT * FROM libros");

            // comprobar si rs esta vacio
            if (!rs.next()) {
                // Insertar datos en la tabla libros
                st.executeUpdate("INSERT INTO libros (titulo, id_autor, pais,paginas, genero) VALUES"
                        + "('Fundacion', 1, 'EEUU', 255, 'Ciencia Ficcion'),"
                        + "('El fin de la eternidad', 1, 'EEUU', 188, 'Ciencia Ficcion'),"
                        + "('2001: Una odisea espacial', 2, 'Reino Unido', 224, 'Ciencia Ficcion'),"
                        + "('Dune', 3, 'EEUU', 412, 'Ciencia Ficcion'),"
                        + "('Cancion de hielo y fuego', 4, 'EEUU', 694, 'Fantasia'),"
                        + "('El señor de los anillos', 5, 'Reino Unido', 1137, 'Fantasia')");
            }

            // Cerrar conexión y recursos
            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al crear las tablas");
        }
    }

    public void restablecerBD() {

        try {
            // Limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Conectar con la base de datos
            conectar();

            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Borrar tabla libros
            st.executeUpdate("DROP TABLE IF EXISTS libros");

            // Borrar tabla autores
            st.executeUpdate("DROP TABLE IF EXISTS autores");

            // Llamar al metodo crearTablas
            crearTablas();

            // Mostrar mensaje de exito
            System.out.println("Base de datos restablecida correctamente");
            System.out.println();

            // Cerrar conexión y recursos
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al restablecer la base de datos");
        }
    }

    public void mostrarAutores() {

        try {
            // Limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Conectar con la base de datos
            conectar();

            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Crear objeto de la clase ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM autores");

            // Mostrar la cabecera de la tabla
            System.out.println("+------+----------------------+----------------------+----------------------+");
            System.out.println("|  ID  |        NOMBRE        |       APELLIDOS      |     NACIONALIDAD     |");
            System.out.println("+------+----------------------+----------------------+----------------------+");
            // Recorrer el ResultSet y mostrar los datos
            while (rs.next()) {

                System.out.format("| %4d | %-20s | %-20s | %-20s |%n",
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"),
                        rs.getString("nacionalidad"));
            }
            // Mostrar la línea de separación entre la cabecera y los datos
            System.out.println("+------+----------------------+----------------------+----------------------+");
            System.out.println();

            // Cerrar conexión y recursos
            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al mostrar los autores");
        }
    }

    public void mostrarLibros() {
        try {
            // Limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Conectar con la base de datos
            conectar();

            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Crear objeto de la clase ResultSet
            ResultSet rs = st.executeQuery("SELECT * FROM libros");

            // Crear un ArrayList para almacenar los libros
            ArrayList<Libro> libros = new ArrayList<>();

            // Recorrer el ResultSet y crear una instancia de la clase Libro para cada fila
            while (rs.next()) {
                // Obtener el autor correspondiente
                int idAutor = rs.getInt("id_autor");
                Autor autor = obtenerAutor(idAutor);

                // Crear una instancia de la clase Libro
                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(autor);
                libro.setpais(rs.getString("pais"));
                libro.setGenero(rs.getString("genero"));

                // Agregar el libro al ArrayList
                libros.add(libro);
            }

            // Mostrar la cabecera de la tabla
            System.out.println(
                    "+------+------------------------------------+-----------------------------------+----------------------+----------------------+");
            System.out.println(
                    "|  ID  |               TITULO               |              AUTOR                |         PAIS         |        GENERO        |");
            System.out.println(
                    "+------+------------------------------------+-----------------------------------+----------------------+----------------------+");

            // Recorrer el ArrayList y mostrar los datos
            for (Libro libro : libros) {
                System.out.format("| %4d | %-34s | %-33s | %-20s | %-20s |%n", libro.getIdLibro(), libro.getTitulo(),
                        libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos(), libro.getpais(),
                        libro.getGenero());
            }

            // Mostrar linea que cierra la tabla
            System.out.println(
                    "+------+------------------------------------+-----------------------------------+----------------------+----------------------+");
            System.out.println();

            // Cerrar conexión y recursos
            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al mostrar los libros");
        }
    }

    // Método para obtener un objeto Autor a partir de su ID
    private Autor obtenerAutor(int idAutor) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM autores WHERE id = ?");
        ps.setInt(1, idAutor);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Autor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"),
                    rs.getString("nacionalidad"));
        } else {
            return null;
        }
    }

    public void modificarAutor() {
        try {
            // Limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Conectar con la base de datos
            conectar();

            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Llamar al metodo mostrarAutores
            mostrarAutores();

            // Pedir al usuario que introduzca el id del autor a modificar
            String id = Integer.toString(Teclado.pideEntero("Introduce el id del autor a modificar: "));

            // Pedir al usuario que introduzca el nuevo nombre del autor
            String nombre = Teclado.pideString("Introduce el nuevo nombre del autor: ");

            // Pedir al usuario que introduzca los nuevos apellidos del autor
            String apellidos = Teclado.pideString("Introduce los nuevos apellidos del autor: ");

            // Pedir al usuario que introduzca la nueva nacionalidad del autor
            String nacionalidad = Teclado.pideString("Introduce la nueva nacionalidad del autor: ");

            // Modificar el autor
            st.executeUpdate("UPDATE autores SET nombre = '" + nombre + "', apellidos = '" + apellidos
                    + "', nacionalidad = '" + nacionalidad + "' WHERE id = " + id);

            // Cerrar conexión y recursos
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al modificar el autor");

        }

    }

    public void borrarLibro() {

        try {
            // Limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Conectar con la base de datos
            conectar();

            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Llamar al metodo mostrarLibros
            mostrarLibros();

            // Pedir al usuario que introduzca el id del libro a borrar
            int id = Teclado.pideEntero("Introduce el id del libro a borrar: ");

            // Borrar el libro
            st.executeUpdate("DELETE FROM libros WHERE id = " + id);

            // Cerrar conexión y recursos
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al borrar el libro");
        }
    }

    public void modificarLibro() {

        try {
            // Limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Conectar con la base de datos
            conectar();

            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Llamar al metodo mostrarLibros
            mostrarLibros();

            // Pedir al usuario que introduzca el id del libro a modificar
            int id = Teclado.pideEntero("Introduce el id del libro a modificar: ");

            // Pedir al usuario que introduzca el nuevo titulo del libro
            String titulo = Teclado.pideString("Introduce el nuevo titulo del libro: ");

            // Pedir al usuario que introduzca el nuevo id del autor del libro
            mostrarAutores();
            int id_autor = Teclado.pideEntero("Introduce el nuevo id del autor del libro: ");

            // Pedir al usuario que introduzca la nueva editorial del libro

            String pais = Teclado.pideString("Introduce el nuevo pais del libro:");

            // Pedir al usuario que introduzca la nueva fecha de publicacion del libro
            String genero = Teclado.pideString("Introduce el nuevo genero del libro: ");

            // Modificar el libro
            st.executeUpdate("UPDATE libros SET titulo = '" + titulo + "', id_autor = '" + id_autor + "', pais = '"
                    + pais + "', genero = '" + genero + "' WHERE id = " + id);

            // Cerrar conexión y recursos
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al modificar el libro");
        }
    }

    public void insertarAutor() {

        try {
            // Limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Crear objeto de la clase Statement
            Statement st = con.createStatement();

            // Pedir al usuario que introduzca el nombre del autor
            System.out.println("Introduce el nombre del autor");
            String nombre = System.console().readLine();

            // Pedir al usuario que introduzca los apellidos del autor
            System.out.println("Introduce los apellidos del autor");
            String apellidos = System.console().readLine();

            // Pedir al usuario que introduzca la nacionalidad del autor
            System.out.println("Introduce la nacionalidad del autor");
            String nacionalidad = System.console().readLine();

            // Insertar el autor
            st.executeUpdate("INSERT INTO autores (nombre, apellidos, nacionalidad) VALUES ('" + nombre + "', '"
                    + apellidos + "', '" + nacionalidad + "')");
            
            // Cerrar conexión y recursos
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar el autor");
        }
    }

}