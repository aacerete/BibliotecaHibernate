package Managers;

import java.util.List;
import java.util.Iterator;

import Objetos.Libro;
import Objetos.Socio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by 46990527d on 24/01/17.
 */
public class Manager {

    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Manager M = new Manager();

      /* Add few employee records in database
        Integer libro1 = M.addLibro("Quijote", "5", "planeta", "1000","2010");
        Integer libro2 = M.addLibro("Programacion para inutiles", "3", "bruguera", "113","2014");
        Integer libro3 = M.addLibro("Manifiesto Comunista", "1", "Rojos league", "300","1950");
        Integer socio1 = M.addSocio("Pau", "Fernandez", "27", "Av roma 15","665342133");
        Integer socio2 = M.addSocio("Carlos", "Lopez", "65", "Provenza 45","662666014");
        Integer socio3 = M.addSocio("Karl", "Marx", "36", "Lisboa 43","616731950");
 */

      /* List down all the employees */
        M.listLibro();

       /* Delete an employee from the database
        M.deleteLibro(libro2);

      /* List down new list of the employees */
        M.listSocio();
    }
    /* Method to CREATE an employee in the database */
    public Integer addLibro(String titulo, String autor, String editorial, String paginas, boolean prestado){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer libroID = null;
        try{
            tx = session.beginTransaction();
            Libro libro = new Libro(titulo,autor ,editorial,paginas, prestado);
            libroID = (Integer) session.save(libro);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return libroID;
    }
    /* Method to  READ all the employees */
    public void listLibro( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List libros = session.createQuery("FROM Objetos.Libro").list();
            for (Iterator iterator =
                 libros.iterator(); iterator.hasNext();){
                Libro libro = (Libro) iterator.next();
                System.out.println(" ID: " + libro.getId());
                System.out.println();
                System.out.print(" Título: " + libro.getTitulo());
                System.out.println();
                System.out.print("  Autor: " + libro.getAutor());
                System.out.println();
                System.out.println("  Editorial: " + libro.getEditorial());
                System.out.print("  Paginas: " + libro.getPaginas());
                System.out.println();
                System.out.print("  Año de edición: " + libro.getAnoEdicion());
                System.out.println();
                System.out.println("    Prestado : " + libro.isPrestado());
                System.out.println("-------------------------------------------");
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    /* Method to DELETE an employee from the records */
    public void deleteLibro(Integer LibroID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Libro libro =
                    (Libro)session.get(Libro.class, LibroID);
            session.delete(libro);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Integer addSocio(String nombre, String apellido, String edad, String direccion, String telefono){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer socioID = null;
        try{
            tx = session.beginTransaction();
            Socio socio = new Socio(nombre,apellido,edad,direccion, telefono);
            socioID = (Integer) session.save(socio);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return socioID;
    }
    /* Method to  READ all the employees */
    public void listSocio( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List socios = session.createQuery("FROM Objetos.Socio").list();
            for (Iterator iterator =
                 socios.iterator(); iterator.hasNext();){
                Socio socio = (Socio) iterator.next();
                System.out.println(" ID: " + socio.getId());
                System.out.println();
                System.out.print(" Nombre: " + socio.getNombre());
                System.out.println();
                System.out.print("  Apellido: " + socio.getApellido());
                System.out.println();
                System.out.println("  Edad: " + socio.getEdad());
                System.out.print("  Direccion: " + socio.getDireccion());
                System.out.println();
                System.out.print("  Telefono: " + socio.getTelefono());
                System.out.println();
                System.out.println("--------------------------------------");
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    /* Method to DELETE an employee from the records */
    public void deleteSocio(Integer SocioID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Socio socio =
                    (Socio) session.get(Socio.class, SocioID);
            session.delete(socio);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}