package ifmt.cba.consulta;


import java.util.List;

import ifmt.cba.util.ComparatorPessoaNome;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaF {
    // Listar todas as pessoas cadastradas (código e nome), ordenados pelo nome.
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            List<Pessoa> p; 
            ComparatorPessoaNome c1 = new ComparatorPessoaNome();
            em.getTransaction().begin();
            
            query = em.createQuery("SELECT p FROM Pessoa p");
            p = (List<Pessoa>) query.getResultList();
            p.sort(c1);
            for (Pessoa pi : p){
                System.out.println("Código:"+pi.getCodigo()+" Nome:"+pi.getNome());
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
