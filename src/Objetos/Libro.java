package Objetos;

/**
 * Created by 46990527d on 24/01/17.
 */
public class Libro {

    private int id;
    private String titulo;
    private String unidades;
    private String editorial;
    private String paginas;
    private String anoEdicion;

    //CONSTRUCTOR
    public Libro(String titulo, String unidades, String editorial, String paginas, String anoEdicion) {

        this.titulo = titulo;
        this.unidades = unidades;
        this.editorial = editorial;
        this.paginas = paginas;
        this.anoEdicion = anoEdicion;
    }


    public Libro(){}

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

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
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



    // METODOS GENERALES
    @Override
    public String toString() {
        return id+" - "+titulo+ " de "+paginas+"pags. "
                +"\n Ed. "+editorial+" fueron editadas "+unidades+" en "+anoEdicion ;
    }
}
