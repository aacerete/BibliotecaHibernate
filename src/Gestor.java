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

            System.out.println("Menu Principal");
            System.out.println("---------------------------------------------------");

            System.out.println("1. Prestamos ");
            System.out.println("2. Libros");
            System.out.println("3. Socios");
            System.out.println("0. Salir\n");
            System.out.println(" Escoja opcion: ");

            option = sc.nextInt();

            switch (option) {

                case 1:

                    while (option != 4) {


                        System.out.println("Menu de Prestamos");
                        System.out.println("---------------------------------------------------");
                        System.out.println("1. Realizar prestamo ");
                        System.out.println("2. Consultar prestamos ");
                        System.out.println("3. Eliminar prestamo");
                        System.out.println("4. Volver\n");
                        System.out.println(" Escoja opcion: ");

                        option = sc.nextInt();

                        switch (option) {

                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }

                    }


                    break;

                case 2:

                    while (option != 5) {

                        System.out.println("Menu de Libros");
                        System.out.println("---------------------------------------------------");
                        System.out.println("1. Insertar libro ");
                        System.out.println("2. Consultar libros ");
                        System.out.println("3. Modificar libro");
                        System.out.println("4. Eliminar libro");
                        System.out.println("5. Volver\n");
                        System.out.println(" Escoja opcion: ");

                        option = sc.nextInt();

                        switch (option) {

                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }

                    }
                    //   verMovies(ID);
                    break;

                case 3:

                    while (option != 5) {

                        System.out.println("Menu de socios");
                        System.out.println("---------------------------------------------------");
                        System.out.println("1. Insertar socio ");
                        System.out.println("2. Consultar socios ");
                        System.out.println("3. Modificar socio");
                        System.out.println("4. Eliminar socio");
                        System.out.println("5. Volver\n");
                        System.out.println(" Escoja opcion: ");

                        option = sc.nextInt();
                        switch (option) {

                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    }
                    break;

                case 0:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("entrada incorrecta");

            }

        } while (option != 5);
    }

    public static void menuPrestamo() {

        int option = 0;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Menu de Prestamos");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Realizar prestamo ");
            System.out.println("2. Consultar prestamos ");
            System.out.println("3. Eliminar prestamo");
            System.out.println("0. Volver");
            System.out.println();

            option = sc.nextInt();

            switch (option) {
                //  String s;

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
                    //   verMovies(ID);
                    break;
                case 3:
                    //    verActor();
                    break;
                case 4:
                    System.out.println("Introduce el ID del actor");
                    ID = sc.nextInt();
                    //      selectPostgres.verMoviesActor(ID);
                    break;
                case 5:
                    System.out.println("Fin");
                    break;
            }
        } while (option != 5);
    }


}



