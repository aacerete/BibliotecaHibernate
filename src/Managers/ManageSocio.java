package Managers;

import Objetos.Libro;
import Objetos.Socio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 46990527d on 24/01/17.
 */
public class ManageSocio {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageSocio MS = new ManageSocio();

      /* Add few employee records in database */
        Integer socio1 = MS.addSocio("Pau", "Fernandez", "27", "Av roma 15","665342133");
        Integer socio2 = MS.addSocio("Carlos", "Lopez", "65", "Provenza 45","662666014");
        Integer socio3 = MS.addSocio("Karl", "Marx", "36", "Lisboa 43","616731950");

      /* List down all the employees
        MS.listLibro();

       /* Delete an employee from the database
        MS.deleteLibro(libro2);

      /* List down new list of the employees
        MS.listLibro(); */
    }
    /* Method to CREATE an employee in the database */
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
                System.out.print(" Nombre: " + socio.getNombre());
                System.out.print("  Apellido: " + socio.getApellido());
                System.out.println("  Edad: " + socio.getEdad());
                System.out.print("  Direccion: " + socio.getDireccion());
                System.out.print("  Telefono: " + socio.getTelefono());
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