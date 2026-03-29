package Classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        ProdutoEletronico p1 = new ProdutoEletronico(10, "celular", 2000, 50, 12);
        Item i1 = new Item(20, 50, 200);

        p1 = (ProdutoEletronico) session.merge(p1);
        i1 = (Item) session.merge(i1);

        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}