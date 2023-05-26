package ifmt.cba.consulta;

import java.util.List;


import ifmt.cba.util.ComparatorPessoaNome;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaC {
// Listar todos os clientes cadastrados, ordenados por nome (código, nome, quantidade de vendas que já foram realizadas para ele).
public static void main(String[] args) {
    try {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Query query;
        List<Cliente> c; 
        ComparatorPessoaNome c1 = new ComparatorPessoaNome();
        em.getTransaction().begin();
        
        query = em.createQuery("SELECT c FROM Cliente c");
        c = (List<Cliente>) query.getResultList();
        c.sort(c1);
        for (Cliente ci : c){
            System.out.println("Código:"+ci.getCodigo()+" Nome:"+ci.getNome()+" QtdVendas:"+ci.getVendas().size());
        }
        
        em.getTransaction().commit();
    } catch (Exception e) {
        System.out.println(e.toString());
    }
}
}
