import Objetos.Libro;
import Objetos.Prestamo;
import Objetos.Socio;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

/**
 * Created by 46990527d on 25/01/17.
 */
public class DAO {

    private Session session;
    private Transaction transaction;

    // Metodos para anyadir información a la BBDD

    public  void añadirLibro(Libro libro) throws HibernateException {

        try  {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Guardamos el libro
            session.save(libro);
            transaction.commit();
        }

        catch (HibernateException e) {
            transaction.rollback();
            throw new HibernateException("Error al añadir el libro", e);
        }
        finally {
            session.close();
        }
    }

    public void añadirSocio(Socio socio) throws HibernateException {

        try {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Guardamos los socios
            session.save(socio);
            transaction.commit();
        }
        catch (HibernateException one) {
            transaction.rollback();
            throw new HibernateException("Error al añadir el socio", one);
        }

        finally {
            session.close();
        }
    }

    public void añadirPrestamo(Prestamo prestamo) throws HibernateException {

        try {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Guardamos los prestamos
            session.save(prestamo);
            transaction.commit();
        }
        catch (HibernateException one) {
            transaction.rollback();
            throw new HibernateException("Error afegint el prestec", one);
        }
        finally {
            session.close();
        }
    }

    // Metodos para modificar informacion de la BBDD

    public void modificarLibro(Libro libro) throws HibernateException {

        try  {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Guardamos el libro
            session.update(libro);
            transaction.commit();
        }

        catch (HibernateException e) {
            transaction.rollback();
            throw new HibernateException("Error actualizando el libro", e);
        }
        finally {
            session.close();
        }
    }

    public void modificarSocio(Socio socio) throws HibernateException {

        try  {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Guardamos el socio
            session.update(socio);
            transaction.commit();
        }

        catch (HibernateException e) {
            transaction.rollback();
            throw new HibernateException("Error actualizando el socio", e);
        }
        finally {
            session.close();
        }
    }

    // Métodos para obtener información de la BBDD

    public ArrayList<Libro> obtenerLibros() {

        // Con estas dos lineas hacemos la conexión a nuestra BBDD
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        // Obtenemos todos los libros
        Query query = session.createQuery("FROM Objetos.Libro ");
        return (ArrayList<Libro>) query.list();
    }

    public ArrayList<Socio> obtenirSocios() {

        // Con estas dos lineas hacemos la conexión a nuestra BBDD
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        // Obtenemos todos los socios
        Query query = session.createQuery("FROM Objetos.Socio ");
        return (ArrayList<Socio>) query.list();
    }

    public ArrayList<Prestamo> obtenerPrestamos() {

        // Con estas dos lineas hacemos la conexión a nuestra BBDD
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        // Obtenemos todos los prestamos
        Query query = session.createQuery("FROM Objetos.Prestamo ");
        return (ArrayList<Prestamo>) query.list();
    }

    // Métodos para eliminar información de la BBDD

    public boolean eliminarTotalLibros() {

        try {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Eliminamos todos los libros
            session.createQuery("DELETE FROM Objetos.Libro").executeUpdate();
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception one){
            return false;
        }
    }

    public boolean eliminarTotalSocios()  {

        try {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Eliminamos todos los socios
            session.createQuery("DELETE FROM Objetos.Socio").executeUpdate();
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception one){
            return false;
        }
    }

    public boolean eliminarTotalPrestamos() {

        try  {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Eliminamos todos los prestamos
            session.createQuery("DELETE FROM Objetos.Prestamo").executeUpdate();
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception one){
            return false;
        }
    }

    public boolean eliminarLibro(Libro libro) {

        try {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Eliminamos el libro
            session.delete(libro);
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception one){return false;}
    }

    public boolean eliminarSocio(Socio socio) {

        try {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Eliminamos el libro
            session.delete(socio);
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception one){return false;}
    }

    public boolean eliminarPrestamo(Prestamo prestamo) {

        try {
            // Con estas dos lineas hacemos la conexión a nuestra BBDD
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Eliminamos el libro
            session.delete(prestamo);
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception one){return false;}
    }
}