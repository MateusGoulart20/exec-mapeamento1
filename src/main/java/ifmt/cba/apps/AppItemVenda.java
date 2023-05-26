package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Produto;

public class AppItemVenda {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Produto p;
            em.getTransaction().begin();
            
            ItemVenda ie = new ItemVenda(2,2,2);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome = 'Mostarda'").getSingleResult();
            ie.setProduto(p);
            em.persist(ie);
            
            ie = new ItemVenda(3,3,3);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome = 'Detergente'").getSingleResult();
            ie.setProduto(p);
            em.persist(ie);
            
            ie = new ItemVenda(5,5,5);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome = 'Filé de Tilápia'").getSingleResult();
            ie.setProduto(p);
            em.persist(ie);
            
            ie = new ItemVenda(7,7,7);
            p = (Produto)em.createQuery("SELECT p FROM Produto p WHERE nome = 'Filé de Tilápia'").getSingleResult();
            ie.setProduto(p);
            em.persist(ie);
            
            ie = new ItemVenda(11,11,11);
            ie.setProduto((Produto)em.createQuery("SELECT p FROM Produto p WHERE nome = 'Mostarda'").getSingleResult());
            em.persist(ie);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
