package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.ComparatorVendaData;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ConsultaD {
    // Listar todas as vendas cadastradas, ordenadas por data da venda 
    // (código, data da venda, valor total da venda) 
    // e seus itens (código, quantidade, preço venda, percentual de desconto)
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            Query query;
            List<Venda> v; 
            ComparatorVendaData c1 = new ComparatorVendaData();
            em.getTransaction().begin();
            
            query = em.createQuery("SELECT v FROM Venda v");
            v = (List<Venda>) query.getResultList();
            v.sort(c1);
            
            for (Venda vi : v){
                System.out.println("Código:"+vi.getCodigo()+" Data:"+vi.getData()+"Total da compra:"+vi.getValor());
                for (ItemVenda iei : vi.getItens()){
                    System.out.println("\tCodigo: "+iei.getCodigo()+" Quantidade:"+iei.getQuantidade()+" Preco de venda:"+iei.getPreco_venda()+" Desconto:"+iei.getPer_desconto());
                }
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
