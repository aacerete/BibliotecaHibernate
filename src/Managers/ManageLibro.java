package Managers;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import Objetos.Libro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by 46990527d on 24/01/17.
 */
public class ManageLibro {

    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageLibro ML = new ManageLibro();

      /* Add few employee records in database */
        Integer libro1 = ML.addLibro("Quijote", "5", "planeta", "1000","2010");
        Integer libro2 = ML.addLibro("Programacion para inutiles", "3", "bruguera", "113","2014");
        Integer libro3 = ML.addLibro("Manifiesto Comunista", "1", "Rojos league", "300","1950");

      /* List down all the employees
        ML.listLibro();

       /* Delete an employee from the database
        ML.deleteLibro(libro2);

      /* List down new list of the employees
        ML.listLibro(); */
    }
    /* Method to CREATE an employee in the database */
    public Integer addLibro(String titulo, String unidades, String editorial, String paginas, String anoEdicion){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer libroID = null;
        try{
            tx = session.beginTransaction();
            Libro libro = new Libro(titulo,unidades,editorial,paginas, anoEdicion);
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
                System.out.print(" Título: " + libro.getTitulo());
                System.out.print("  Unidades: " + libro.getUnidades());
                System.out.println("  Editorial: " + libro.getEditorial());
                System.out.print("  Paginas: " + libro.getPaginas());
                System.out.print("  Año de edición: " + libro.getAnoEdicion());
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
}