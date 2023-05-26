package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.ComparatorFornecedorRazaoSocial;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaA {
// Listar todos os fornecedores cadastrados, ordenados por razão social (código e nome)
// e os produtos que ele fornece (código, nome do produto);
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            List<Fornecedor>  f; 
            ComparatorFornecedorRazaoSocial c1 = new ComparatorFornecedorRazaoSocial();
            em.getTransaction().begin();
            query = em.createQuery("SELECT f FROM Fornecedor f ORDER BY f");
            f = (List<Fornecedor>) query.getResultList();
            f.sort(c1);
            System.out.println(f);
            for (Fornecedor fi : f){
                System.out.println("Código:"+fi.getCodigo()+" Nome:"+fi.getNomeFantasia());
                for (Produto pi : fi.getProduto()){
                    System.out.println("\tCódigo:"+pi.getCodigo()+" Nome:"+pi.getNome());
                }
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
