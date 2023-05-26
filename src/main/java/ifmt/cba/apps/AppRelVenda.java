package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


public class AppRelVenda {
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            Venda v; ItemVenda ie; Cliente c; Vendedor vr;
            em.getTransaction().begin();
            // first
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo = 1");
            v = (Venda) query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo = 1");
            ie = (ItemVenda) query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Roberto'");
            c = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Inacio'");
            vr = (Vendedor) query.getSingleResult();

            v.getItens().add(ie);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVendas().add(v);
            vr.getVendas().add(v);

            em.persist(v);
            em.persist(ie);
            em.persist(c);
            em.persist(vr);
            // second
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo = 2");
            v = (Venda) query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo = 2");
            ie = (ItemVenda) query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Alex'");
            c = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Ana Clara'");
            vr = (Vendedor) query.getSingleResult();

            v.getItens().add(ie);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVendas().add(v);
            vr.getVendas().add(v);

            em.persist(v);
            em.persist(ie);
            em.persist(c);
            em.persist(vr);
            // 3°
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo = 3");
            v = (Venda) query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo = 3");
            ie = (ItemVenda) query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Vanessa'");
            c = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Geruscleusa'");
            vr = (Vendedor) query.getSingleResult();

            v.getItens().add(ie);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVendas().add(v);
            vr.getVendas().add(v);

            em.persist(v);
            em.persist(ie);
            em.persist(c);
            em.persist(vr);
            //4°
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo = 4");
            v = (Venda) query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo = 4");
            ie = (ItemVenda) query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Vanessa'");
            c = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Ana Clara'");
            vr = (Vendedor) query.getSingleResult();

            v.getItens().add(ie);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVendas().add(v);
            vr.getVendas().add(v);

            em.persist(v);
            em.persist(ie);
            em.persist(c);
            em.persist(vr);
            // 5°
            query = em.createQuery("SELECT v FROM Venda v WHERE codigo = 5");
            v = (Venda) query.getSingleResult();
            query = em.createQuery("SELECT ie FROM ItemVenda ie WHERE codigo = 5");
            ie = (ItemVenda) query.getSingleResult();
            query = em.createQuery("SELECT c FROM Cliente c WHERE nome = 'Roberto'");
            c = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT vr FROM Vendedor vr WHERE nome = 'Geruscleusa'");
            vr = (Vendedor) query.getSingleResult();

            v.getItens().add(ie);
            v.setCliente(c);
            v.setVendedor(vr);
            c.getVendas().add(v);
            vr.getVendas().add(v);

            em.persist(v);
            em.persist(ie);
            em.persist(c);
            em.persist(vr);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}



            

