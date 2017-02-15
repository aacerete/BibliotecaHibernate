package Gestor;

import Managers.ManageLibro;
import Managers.ManagePrestamo;
import Managers.ManageSocio;
import Objetos.Libro;
import Objetos.Prestamo;
import Objetos.Socio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by aacerete on 15/02/17.
 */
public class Main {

    public static void main(String[] args) {

        //menu del gestor
        boolean fi = false;
        do {
            System.out.println("Menu Principal");
            System.out.println("---------------------------------------------------");

            System.out.println("1. Gestion de Libros ");
            System.out.println("2. Gestion de Socios");
            System.out.println("3. Listados");
            System.out.println("4. Realizar prestamo");
            System.out.println("5. Libros prestados");
            System.out.println("6. Libros con prestamo vencido");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();


            switch (op) {
                case 1:
                    gestionarLibro();
                    break;
                case 2:
                    gestionarSocio();
                    break;
                case 3:
                    listados();
                    break;
                case 4:
                    realizarPrestamo();
                    break;
                case 5:
                    listaLibros();
                    break;
                case 6:
                    listaPrestamosCaducados();
                    break;
                case 0:
                    fi = true;   //Finalitzar programa
                    break;
                default:
                    break;
            }
        } while (!fi);

        System.out.println("Saliendo...");
    }


    //Gestionar libros
    public static void gestionarLibro() {

        boolean salir = false;

        do {

            System.out.println("Menu de Libros");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Insertar libro ");
            System.out.println("2. Actualizar libros ");
            System.out.println("3. Eliminar libro");

            System.out.println("0. Volver\n");

            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();

            switch (opt) {

                case 1:
                    introduceLibro();
                    break;
                case 2:
                    actualizaLibroById();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    break;
            }

        } while (!salir);

    }

    public static void introduceLibro() {

        ManageLibro ML = new ManageLibro();

        System.out.println("Introduce el titulo");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();

        System.out.println("Introduce el  numero de ejemplares");
        sc = new Scanner(System.in);
        int numEjemplares = sc.nextInt();

        System.out.println("Introduce la editorial");
        sc = new Scanner(System.in);
        String editorial = sc.nextLine();

        System.out.println("Introduce el numero de paginas");
        sc = new Scanner(System.in);
        int numPaginas = sc.nextInt();

        System.out.println("Introduce el año de edicion");
        sc = new Scanner(System.in);
        int anyoEdicion = sc.nextInt();

        //Afegim el llibre al manager
        ML.addLibro(titulo, numEjemplares, editorial, numPaginas, anyoEdicion);

        System.out.println("Libro añadido correctamente");

    }

    public static void actualizaLibroById() {

        ManageLibro ML = new ManageLibro();
        int id;

        System.out.println("Introduce la id");
        Scanner sc2 = new Scanner(System.in);
        id = sc2.nextInt();

        System.out.println("Introduce el titulo");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();

        System.out.println("Introduce el  numero de ejemplares");
        sc = new Scanner(System.in);
        int numEjemplares = sc.nextInt();

        System.out.println("Introduce la editorial");
        sc = new Scanner(System.in);
        String editorial = sc.nextLine();

        System.out.println("Introduce el numero de paginas");
        sc = new Scanner(System.in);
        int numPaginas = sc.nextInt();

        System.out.println("Introduce el año de edicion");
        sc = new Scanner(System.in);
        int anyoEdicion = sc.nextInt();

        //actualitzem el llibre a partir de la id introduida
        ML.updateLibro(id, titulo, numEjemplares, editorial, numPaginas, anyoEdicion);
        System.out.println("Libro actualizado Correctamente");

    }

    public static void eliminarLibro() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la id");
        int idLibro = sc.nextInt();

        ManageLibro ML = new ManageLibro();
        ML.deleteLibro(idLibro);

        System.out.println("Libro eliminado correctamente");

    }

    public static void gestionarSocio() {

        boolean sor = false;

        do {

            System.out.println("Menu de Socios");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Insertar socio ");
            System.out.println("2. Actualizar socio ");
            System.out.println("3. Eliminar socio");

            System.out.println("0. Volver\n");

            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();


            switch (opcion) {
                case 0:
                    sor = true;
                    break;
                case 1:
                    IntroduceSocio();
                    break;
                case 2:
                    ActualizaSocioById();
                    break;
                case 3:
                    eliminarSocio();
                    break;
                default:
                    break;
            }

        } while (!sor);
    }


    public static void IntroduceSocio() {

        ManageSocio MS = new ManageSocio();

        System.out.println("Introduce el nombre ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();

        System.out.println("Introduce la edad");
        sc = new Scanner(System.in);
        int edad = sc.nextInt();

        System.out.println("Introduce la direccion");
        sc = new Scanner(System.in);
        String direccion = sc.nextLine();

        System.out.println("Introduce el telefono");
        sc = new Scanner(System.in);
        int telefono = sc.nextInt();

        MS.addSocios(nombre, edad, direccion, telefono);
        System.out.println("Socio añadido correctamente");

    }

    public static void ActualizaSocioById() {

        int id;
        System.out.println("Introduce la id");
        Scanner sc2 = new Scanner(System.in);
        id = sc2.nextInt();
        ManageSocio MS = new ManageSocio();

        System.out.println("Introduce el nombre ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();

        System.out.println("Introduce la edad");
        sc = new Scanner(System.in);
        int edad = sc.nextInt();

        System.out.println("Introduce la direccion");
        sc = new Scanner(System.in);
        String direccion = sc.nextLine();

        System.out.println("Introduce el telefono");
        sc = new Scanner(System.in);
        int telefono = sc.nextInt();

        MS.updateSocio(id, nombre, edad, direccion, telefono);
        System.out.println("Socio actualizado correctamente");

    }


    public static void eliminarSocio() {

        System.out.println("Introduce la id");

        Scanner sc = new Scanner(System.in);
        int idSocio = sc.nextInt();
        ManageSocio MS = new ManageSocio();

        MS.deleteSocio(idSocio);
        System.out.println("Socio eliminado correctamente");

    }


    public static void listados() {

        boolean sor = false;

        do {

            System.out.println("Menu de listados");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Listar libros ");
            System.out.println("2. Listar socios ");
            System.out.println("3. Listar prestamos");
            System.out.println("0. Volver\n");

            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();

            switch (opcion) {
                case 0://salir
                    sor = true;
                    break;
                case 1:
                    listaLibros();
                    break;
                case 2:
                    listaSocios();
                    break;
                case 3:
                    listaPrestamos();
                    break;
                default:
                    break;
            }

        } while (!sor);
    }


    public static void listaLibros()    {
        ManageLibro ML = new ManageLibro();
        ML.listLibros();
    }

    public static void listaSocios() {
        ManageSocio MS = new ManageSocio();
        MS.listSocios();
    }

    public static void listaPrestamos(){

        ManagePrestamo MP = new ManagePrestamo();
        MP.listPrestamos();
    }

    public static void realizarPrestamo() {

        ManagePrestamo MP = new ManagePrestamo();

        System.out.println("Introduce la id del libro");
        Scanner sc = new Scanner(System.in);
        int idLibro = sc.nextInt();

        System.out.println("Introduce la id del Socio");
        sc = new Scanner(System.in);
        int idSocio = sc.nextInt();

        System.out.println("Introduce la fecha de Inicio");
        sc = new Scanner(System.in);
        String fechaIni = sc.nextLine();

        System.out.println("Introduce la fecha Final");
        sc = new Scanner(System.in);
        String fechaFin = sc.nextLine();
        Date fechaInicio= getDate(fechaIni);
        Date fechaFinal= getDate(fechaFin);

        MP.addPrestamos(idLibro, idSocio, fechaInicio, fechaFinal);

        System.out.println("Prestamo realizado correctamente");
        System.out.println();

    }


    public static Date getDate(String fechaString)    {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {

            date = simpleDateFormat.parse(fechaString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }




    public static void listaPrestamosCaducados()    {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date =  new Date();
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);

        simpleDateFormat.format(date);


        ManagePrestamo MP = new ManagePrestamo();
        List prestamos = MP.listPrestamos();

        for (Iterator iterator = prestamos.iterator(); iterator.hasNext(); ) {
            Prestamo prestamo = (Prestamo) iterator.next();

            if (prestamo.getFechaFinal().before(date)){

                System.out.print("ID : " + prestamo.getId());
                System.out.print("ID Libro: " + prestamo.getIdLibro());
                System.out.print("ID Socio: " + prestamo.getIdSocio());
                System.out.println("Fecha Inicio: " + prestamo.getFechaInicio());
                System.out.println("Fecha Final: " + prestamo.getFechaFinal());
                System.out.println();
            }
        }
    }

}