package Managers;

import Objetos.Libro;
import Objetos.Prestamo;
import Objetos.Socio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 46990527d on 25/01/17.
 */
public class ManagePrestamo {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManagePrestamo MP = new ManagePrestamo();

        Integer libro1 =
        Integer libro2 =
        Integer libro3 =

      /* Add few employee records in database */
        Integer prestamo1 = MP.addPrestamo("1", "2", "12/02/17", "20/02/17");
        Integer prestamo2 = MP.addPrestamo("Carlos", "Lopez", "65", "Provenza 45","662666014");
        Integer prestamo3 = MP.addPrestamo("Karl", "Marx", "36", "Lisboa 43","616731950");

      /* List down all the employees
        MP.listLibro();

       /* Delete an employee from the database
        MP.deleteLibro(libro2);

      /* List down new list of the employees
        MP.listLibro(); */
    }
    /* Method to CREATE an employee in the database */
    public Integer addPrestamo(Libro idLibro, Socio idSocio, String fechaIni, String fechaFin){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer prestamoID = null;
        try{
            tx = session.beginTransaction();
            Prestamo prestamo = new Prestamo(idLibro,idSocio,fechaIni,fechaFin);
            prestamoID = (Integer) session.save(prestamo);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return prestamoID;
    }
    /* Method to  READ all the employees */
    public void listPrestamo( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List prestamos = session.createQuery("FROM Objetos.Prestamo").list();
            for (Iterator iterator =
                 prestamos.iterator(); iterator.hasNext();){
                Prestamo prestamo = (Prestamo) iterator.next();
                System.out.print(" Id del prestamo: " + prestamo.getId());
                System.out.print("  Libro: " + prestamo.getIdLibro());
                System.out.println("  Socio: " + prestamo.getIdSocio());
                System.out.print("  Fecha de inicio: " + prestamo.getFechaIni());
                System.out.print("  Fecha fin: " + prestamo.getFechaFin());
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
    public void deletePrestamo(Integer PrestamoID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Prestamo prestamo =
                    (Prestamo) session.get(Prestamo.class, PrestamoID);
            session.delete(prestamo);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}