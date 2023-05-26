package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.ComparatorPessoaNome;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaH {
    // Listar todas as pessoas jurídicas cadastradas (código, nome fantasia e cnpj), ordenados pelo nome fantasia.
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            List<PessoaJuridica> p; 
            ComparatorPessoaNome c1 = new ComparatorPessoaNome();
            em.getTransaction().begin();
            
            query = em.createQuery("SELECT p FROM Pessoa p");
            p = (List<PessoaJuridica>) query.getResultList();
            p.sort(c1);
            for (PessoaJuridica pi : p){
                System.out.println("Código:"+pi.getCodigo()+" Nome:"+pi.getNomeFantasia()+" CNPJ:"+pi.getCnpj());
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
