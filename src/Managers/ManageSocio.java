package Managers;

import Objetos.Socio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by aacerete on 15/02/17.
 */
public class ManageSocio {

    private static SessionFactory factory;

    public Integer addSocios(String nombre, int edad, String direccion, int telefono){

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        Integer socioID = null;

        try{
            tx = session.beginTransaction();
            Socio socio = new Socio(nombre, edad, direccion, telefono);
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


    public List listSocios( ) {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        List socios = null;

        try {
            tx = session.beginTransaction();
            socios = session.createQuery("FROM Socio").list();

            for (Iterator iterator =
                 socios.iterator(); iterator.hasNext(); ) {
                Socio socio = (Socio) iterator.next();
                System.out.print("ID: " + socio.getId()+"\n");
                System.out.print("Nombre : " + socio.getNombre()+"\n");
                System.out.print("\tEdad : " + socio.getEdad()+"\n");
                System.out.print("\tDireccion : " + socio.getDireccion()+"\n");
                System.out.println("\tTelefono : " + socio.getTelefono()+"\n");
                System.out.println("--------------------------------------------");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return socios;
    }


    public void updateSocio(Integer SocioID,String nombre, int edad, String direccion, int telefono){

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Socio socio =
                    (Socio)session.get(Socio.class, SocioID);
            socio.setNombre( nombre );
            socio.setEdad( edad );
            socio.setDireccion( direccion );
            socio.setTelefono( telefono );
            session.update(socio);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public void deleteSocio(Integer SocioID){

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Socio socio =
                    (Socio)session.get(Socio.class, SocioID);
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