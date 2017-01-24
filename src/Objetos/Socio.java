package Objetos;

/**
 * Created by 46990527d on 24/01/17.
 */
public class Socio {

    private Integer id;
    String nombre;
    String apellido;
    String edad;
    String direccion;
    String telefono;

    public Socio(String nombre, String apellido, String edad, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Socio(){}

    public Socio(int id){
        this.id = id;
    }


    //GETTERS & SETTERS
    public int getId() { return id; }

    public void setId(int id) { this.id = id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    // METODOS GENERALES
    @Override
    public String toString() {
        return id+" - "+nombre+ " "+apellido+" de "+edad+" años "
                +"\n vive en "+direccion+" con tlfn. "+telefono;
    }
}
