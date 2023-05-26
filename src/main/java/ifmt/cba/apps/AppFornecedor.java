package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;

public class AppFornecedor {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            Fornecedor f;
            
            f = new Fornecedor("Sanclair","KOIRF","2546");
            em.persist(f);

            f = new Fornecedor("Katchoir","GHJU","2547");
            em.persist(f);

            f = new Fornecedor("Seraio","HYU","7844");
            em.persist(f);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}