package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;

public class AppGrupoProduto {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            GrupoProduto g;
            em.getTransaction().begin();

            g = new GrupoProduto("Carnes");
            em.persist(g);

            g = new GrupoProduto("Condimentos");
            em.persist(g);

            g = new GrupoProduto("Limpeza");
            em.persist(g);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
