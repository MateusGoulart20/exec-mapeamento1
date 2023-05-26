package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;

public class AppVenda {
    public static void main(String[] args) {
        try {
            //ItemVenda ie;
            Venda v;
            
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            em.getTransaction().begin();
            v = new Venda(1);
            em.persist(v);
            em.getTransaction().commit();

            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
