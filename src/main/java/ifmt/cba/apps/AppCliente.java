package ifmt.cba.apps;

import jakarta.persistence.EntityManager;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;

public class AppCliente {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            Cliente c = new Cliente("Roberto","rg1","cpf1",(float)2.7);
            em.persist(c);
    
            c = new Cliente("Alex","rg2","cpf2",2000);
            em.persist(c);
            
            c = new Cliente("Vanessa","rg3","cpf3",4000);
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
    
}
