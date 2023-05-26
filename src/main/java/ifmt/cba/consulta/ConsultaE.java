package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.ComparatorPessoaNome;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaE {
    // Listar todos os vendedores cadastrados, ordenados por nome 
    // (código, nome, valor de comissão de cada venda que 
    //ele realizou (código da venda, valor total da venda, valor comissão na venda))

    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            List<Vendedor> vr; 
            ComparatorPessoaNome c1 = new ComparatorPessoaNome();
            em.getTransaction().begin();
            
            query = em.createQuery("SELECT vr FROM Vendedor vr");
            vr = (List<Vendedor>) query.getResultList();
            vr.sort(c1);
            
            for (Vendedor vri : vr){
                System.out.println("Código:"+vri.getCodigo()+" Nome:"+vri.getNome());
                for (Venda vi : vri.getVendas()){
                    System.out.println("\tCodigo: "+vi.getCodigo()+" Valor:"+vi.getValor()+" Preco de venda"+vri.getComissao(vi.getValor()));
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
