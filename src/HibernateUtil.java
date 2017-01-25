import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 46990527d on 25/01/17.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (HibernateException one) {
            System.err.println("Error en la SessionFactory: " + one);
            throw new ExceptionInInitializerError(one);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


