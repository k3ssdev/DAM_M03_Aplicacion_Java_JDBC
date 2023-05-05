package Model;


public class Libro {

    private int idLibro;
    private String titulo;
    private Autor autor;
    private String pais;
    private String genero;

    public Libro() {
    }

    public Libro(int idLibro, String titulo, Autor autor, String pais, String genero) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.pais = pais;
        this.genero = genero;
    }

    public Libro(String titulo, Autor autor, String pais, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.pais = pais;
        this.genero = genero;
    }

    

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getpais() {
        return pais;
    }


    public String getGenero () {
        return genero;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setpais(String pais) {
        this.pais = pais;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", pais=" + pais + ", genero=" + genero + '}';
    }

}