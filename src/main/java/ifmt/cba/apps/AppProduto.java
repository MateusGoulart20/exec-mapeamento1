package ifmt.cba.apps;

import jakarta.persistence.EntityManager;

import jakarta.persistence.Query;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import ifmt.cba.vo.Produto;

public class AppProduto {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            Produto product;
            Query query;
            GrupoProduto gp;
            // criando produto detergente associado ccom o grupo Limpeza
            product = new Produto("Detergente",(float)2.8);
            
            query = em.createQuery("SELECT g FROM GrupoProduto g WHERE nome = 'Limpeza'");
            gp = (GrupoProduto)query.getSingleResult();
            product.setGrupo_produto(gp);

            em.persist(product);

            product = new Produto("Mostarda", (float)4.5);
            
            query = em.createQuery("SELECT g FROM GrupoProduto g WHERE nome = 'Condimentos'");
            gp = (GrupoProduto)query.getSingleResult();
            product.setGrupo_produto(gp);
            
            em.persist(product);

            product = new Produto("Filé de Tilápia", (float)90.5);
            
            query = em.createQuery("SELECT g FROM GrupoProduto g WHERE nome = 'Carnes'");
            gp = (GrupoProduto)query.getSingleResult();
            product.setGrupo_produto(gp);
            
            em.persist(product);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
