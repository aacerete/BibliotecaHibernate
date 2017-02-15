package Objetos;

import java.util.Date;

/**
 * Created by 46990527d on 24/01/17.
 */
public class Prestamo {

    private int id;
    private int idLibro;
    private int idSocio;
    private Date fechaInicio;
    private Date fechaFinal;

    public Prestamo() {
    }

    public Prestamo(int idLibro, int idSocio, Date fechaInicio, Date fechaFinal) {
        this.idLibro = idLibro;
        this.idSocio = idSocio;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Prestamo(int id, int idLibro, int idSocio, Date fechaInicio, Date fechaFinal) {
        this.id=id;
        this.idLibro = idLibro;
        this.idSocio = idSocio;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", idLibro=" + idLibro +
                ", idSocio=" + idSocio +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                '}';
    }
}