package Objetos;

/**
 * Created by 46990527d on 24/01/17.
 */
public class Prestamo {

    private int id;
    private Libro idLibro;
    private Socio idSocio;
    private String fechaIni;
    private String fechaFin;

    //CONSTRUCTORES
    public Prestamo(Libro idLibro, Socio idSocio, String fechaIni, String fechaFin) {
        this.idLibro = idLibro;
        this.idSocio = idSocio;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public Prestamo(){}

    public Prestamo(int id){
        this.id = id;
    }

    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

    public Socio getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socio idSocio) {
        this.idSocio = idSocio;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }


    // METODOS GENERALES
    @Override
    public String toString() {
        return id+" - libro:"+ idLibro.getId()+" prestado a socio "+idSocio.getId()
                +"\n Prestamos realizado el "+fechaIni+" a devolver el "+fechaFin;
    }
}
