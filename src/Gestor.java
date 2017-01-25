import Managers.ManageSocio;
import Objetos.Socio;

import java.util.Scanner;

/**
 * Created by 46990527d on 25/01/17.
 */
public class Gestor {

    public static void main(String[] args) {

        int option = 0;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Menu principal");
            System.out.println("---------------------------------------------------");

            System.out.println("1. Insertar datos ");
            System.out.println("2. Realizar prestamos ");
            System.out.println("3. Consultar datos");
            System.out.println("4. Actualizar datos");
            System.out.println("5. Eliminar datos");
            System.out.println("6. Filtrar prestamos\n");
            System.out.println("0. Salir\n");

            System.out.println();

            option = sc.nextInt();

            switch (option) {
                case 1:
                    menuDatos();
                    break;
                case 2:
                    System.out.println("Introduce el Id de la pelicula");
                    int ID = sc.nextInt();
                    verMovies(ID);
                    break;
                case 3:
                    verActor();
                    break;
                case 4:
                    System.out.println("Introduce el ID del actor");
                    ID = sc.nextInt();
                    selectPostgres.verMoviesActor(ID);
                    break;
                case 5:
                    System.out.println("Fin");
                    break;
            }
        } while (option != 5);
    }

    public static void menuDatos(){

        int option = 0;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Menu de Insercion");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Insertar Socio ");
            System.out.println("2. Insertar libro ");
            System.out.println("0. Volver");
            System.out.println();

            option = sc.nextInt();

            switch (option) {
                String s;

                case 1:
                    Socio socio = new Socio();
                    System.out.println("Introduce el nombre");
                    socio.setNombre(sc.next());
                    System.out.println("Introduce el apellido");
                    socio.setApellido(sc.next());
                    System.out.println("Introduce la edad");
                    socio.setEdad(sc.next());
                    System.out.println("Introduce la dirección");
                    socio.setDireccion(sc.next());
                    System.out.println("Introduce el teléfono");
                    socio.setTelefono(sc.next());

                    break;
                case 2:
                    System.out.println("Introduce el Id de la pelicula");
                    int ID = sc.nextInt();
                    verMovies(ID);
                    break;
                case 3:
                    verActor();
                    break;
                case 4:
                    System.out.println("Introduce el ID del actor");
                    ID = sc.nextInt();
                    selectPostgres.verMoviesActor(ID);
                    break;
                case 5:
                    System.out.println("Fin");
                    break;
            }
        } while (option != 5);
    }


    }


}
