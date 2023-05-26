package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.ComparatorProdutoNome;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaB {
    // Listar todos os produtos cadastrados, ordenados por nome 
    //(código, nome, preço de venda, nome do grupo de produto e seus fornecedores (código e razão social));
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            List<Produto> p; 
            ComparatorProdutoNome c1 = new ComparatorProdutoNome();
            em.getTransaction().begin();
            query = em.createQuery("SELECT p FROM Produto p");
            p = (List<Produto>) query.getResultList();
            p.sort(c1);
            System.out.println(p);
            for (Produto pi : p){
                System.out.println("Código:"+pi.getCodigo()+" Nome:"+pi.getNome()+" Preco Venda:"+pi.getPreco_venda()+" GrupProduto:"+pi.getGrupo_produto().getNome()+" Fornecedores:");
                for (Fornecedor fi : pi.getForncedores()){
                    System.out.println("\tCódigo:"+fi.getCodigo()+" Nome:"+fi.getNome());
                }
                System.out.println();
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
