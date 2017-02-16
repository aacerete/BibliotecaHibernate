package Managers;

import Objetos.Libro;
import Objetos.Prestamo;
import Objetos.Socio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 46990527d on 25/01/17.
 */
public class ManagePrestamo {

    private static SessionFactory factory;

    //añadir prestamos
    public Integer addPrestamos(int idLibro, int idSocio, Date fechaInicio, Date fechaFinal){

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        Integer IDprestamo = null;

        try{
            tx = session.beginTransaction();
            Prestamo prestamo = new Prestamo(idLibro,idSocio, fechaInicio, fechaFinal);
            IDprestamo = (Integer) session.save(prestamo);
            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();

        }finally {
            session.close();
        }
        return IDprestamo;
    }

    //listar prestamos
    public List listPrestamos( ){

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        List prestamos= null;

        try{
            tx = session.beginTransaction();
            prestamos = session.createQuery("FROM Prestamo").list();
            for (Iterator iterator =
                 prestamos.iterator(); iterator.hasNext(); ) {
                Prestamo prestamo = (Prestamo) iterator.next();

                System.out.print("Id : " + prestamo.getId()+"\n");
                System.out.print("Id Libro: " + prestamo.getIdLibro()+"\n");
                System.out.print("Id Socio: " + prestamo.getIdSocio()+"\n");
                System.out.println("Fecha Ini: " + prestamo.getFechaInicio());
                System.out.println("Fecha Fin: " + prestamo.getFechaFinal());
                System.out.println("--------------------------------------");

            }
            tx.commit();

        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();

        }finally {
            session.close();
        }
        return prestamos;
    }

    //actualizar prestamo
    public void updatePrestamo(Integer PrestamoID,int idLibro, int idSocio, Date fechaIni, Date fechaFi){

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Prestamo prestamo =
                    (Prestamo)session.get(Prestamo.class, PrestamoID);
            prestamo.setIdLibro(idLibro);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    //borrar prestamo
    public void deletePrestamo(Integer PrestamoID){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Prestamo prestamo =
                    (Prestamo)session.get(Prestamo.class, PrestamoID);
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