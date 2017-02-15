package Managers;

import Objetos.Libro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by aacerete on 15/02/17.
 */
public class ManageLibro {

    private static SessionFactory factory;


    public Integer addLibro(String titulo, int numEjemplares, String editorial, int numPaginas, int anyoEdicion) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer libroID = null;
        try{
            tx = session.beginTransaction();
            Libro libro = new Libro(titulo, numEjemplares, editorial, numPaginas, anyoEdicion);
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


    public List listLibros( ){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        List libros=null;
        try{
            tx = session.beginTransaction();
            libros = session.createQuery("FROM Libro").list();

            for (Iterator iterator = libros.iterator(); iterator.hasNext();){
                Libro libro = (Libro) iterator.next();
                System.out.print("ID: " + libro.getId()+"\n");
                System.out.print("Titulo: " + libro.getTitulo()+"\n");
                System.out.print("Ejemplares: " + libro.getNumEjemplares()+"\n");
                System.out.print("Editorial: " + libro.getEditorial()+"\n");
                System.out.print("Num. Paginas: " + libro.getNumPaginas()+"\n");
                System.out.println("Año Edicion: " + libro.getAnyoEdicion()+"\n");
                System.out.println();
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return libros;
    }


    public void updateLibro(Integer LibroID, String titulo, int numEjemplares, String editorial, int numPaginas, int anyoEdicion) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Libro libro =
                    (Libro)session.get(Libro.class, LibroID);
            libro.setTitulo( titulo );
            libro.setNumEjemplares( numEjemplares );
            libro.setEditorial( editorial );
            libro.setNumPaginas( numPaginas );
            libro.setAnyoEdicion( anyoEdicion );
            session.update(libro);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteLibro(Integer LibroID){
        factory = new Configuration().configure().buildSessionFactory();
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