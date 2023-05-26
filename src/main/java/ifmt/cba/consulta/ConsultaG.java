package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.ComparatorPessoaNome;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaFisica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaG {
    // Listar todas as pessoas físicas cadastradas (código, nome, rg e cpf), ordenados pelo nome.
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            List<PessoaFisica> p; 
            ComparatorPessoaNome c1 = new ComparatorPessoaNome();
            em.getTransaction().begin();
            
            query = em.createQuery("SELECT p FROM PessoaFisica p");
            p = (List<PessoaFisica>) query.getResultList();
            p.sort(c1);
            for (PessoaFisica pi : p){
                System.out.println("Código:"+pi.getCodigo()+" Nome:"+pi.getNome()+" RG:"+pi.getRg()+" CPF:"+pi.getCpf());
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
