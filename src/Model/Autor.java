package Model;

public class Autor {
    
        private int idAutor;
        private String nombre;
        private String apellidos;
        private String nacionalidad;
    
        public Autor() {
        }
    
        public Autor(int idAutor, String nombre, String apellidos, String nacionalidad) {
            this.idAutor = idAutor;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.nacionalidad = nacionalidad;
        }
    
        public Autor(String nombre, String apellidos, String nacionalidad) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.nacionalidad = nacionalidad;
        }
    
        public int getIdAutor() {
            return idAutor;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public String getApellidos() {
            return apellidos;
        }
    
        public String getNacionalidad() {
            return nacionalidad;
        }
    
        public void setIdAutor(int idAutor) {
            this.idAutor = idAutor;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }
    
        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        @Override
        public String toString() {
            return "Autor{" + "idAutor=" + idAutor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nacionalidad=" + nacionalidad + '}';
        }




}
