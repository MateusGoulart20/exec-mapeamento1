package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;

public class AppFornecedorProduto {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Fornecedor f;
            Produto p;
            Query query;

            // Detergente = Seraio
            //*
            em.getTransaction().begin();
            query = em.createQuery("SELECT p FROM Produto p WHERE nome = 'Detergente'");
            p = (Produto) query.getSingleResult();
            query = em.createQuery("SELECT f FROM Fornecedor f WHERE nome = 'Seraio'");
            f = (Fornecedor) query.getSingleResult();
            
            f.getProduto().add(p);
            p.getForncedores().add(f);
            
            em.persist(f);
            em.persist(p);
            //em.getTransaction().commit();
            //*/
            
            
            //Mostarda - Katchoir
            //* 
            //em.getTransaction().begin();
            query = em.createQuery("SELECT p FROM Produto p WHERE nome = 'Mostarda'");
            p = (Produto)query.getSingleResult();
            query = em.createQuery("SELECT f FROM Fornecedor f WHERE nome = 'Katchoir'");
            f = (Fornecedor)query.getSingleResult();
            
            f.getProduto().add(p);
            p.getForncedores().add(f);
            
            em.persist(f);
            em.persist(p);
            //em.getTransaction().commit();
            
            //*/
            // Filé de Tilápia - Sanclair
            //*
            //em.getTransaction().begin();
            query = em.createQuery("SELECT p FROM Produto p WHERE nome = 'Filé de Tilápia'");
            p = (Produto)query.getSingleResult();
            query = em.createQuery("SELECT f FROM Fornecedor f WHERE nome = 'Sanclair'");
            f = (Fornecedor)query.getSingleResult();
            
            f.getProduto().add(p);
            p.getForncedores().add(f);
            
            em.persist(f);
            em.persist(p);
            em.getTransaction().commit();
            //*/

            

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}