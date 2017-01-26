package Objetos;

import java.io.Serializable;

/**
 * Created by 46990527d on 24/01/17.
 */
public class Libro implements Serializable {

    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private String paginas;
    private String anoEdicion;
    private boolean prestado;

    //CONSTRUCTOR
    public Libro(String titulo, String autor, String editorial, String paginas, String anoEdicion, boolean prestado) {

        this.titulo = titulo;
        this.editorial = editorial;
        this.paginas = paginas;
        this.anoEdicion = anoEdicion;
        this.prestado = false;
    }

    public Libro(){}

    public Libro(String titulo, String autor, String editorial, String paginas, boolean prestado){}

    public Libro(int id){
        this.id = id;
    }



    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getAnoEdicion() {
        return anoEdicion;
    }

    public void setAnoEdicion(String anoEdicion) {
        this.anoEdicion = anoEdicion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", paginas='" + paginas + '\'' +
                ", anoEdicion='" + anoEdicion + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
