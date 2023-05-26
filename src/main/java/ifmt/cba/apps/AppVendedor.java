package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Vendedor;

public class AppVendedor {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            Vendedor v = new Vendedor("Inacio","rga","cpfa", (float)0.2);
            em.persist(v);

            v = new Vendedor("Ana Clara","rgb","cpfb", (float)0.1);
            em.persist(v);

            v = new Vendedor("Geruscleusa","rgc","cpfc", (float)0.4);
            em.persist(v);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
