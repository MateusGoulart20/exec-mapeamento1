package ifmt.cba.vo;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "fornecedor")
public class Fornecedor extends PessoaJuridica{
    public Fornecedor(){}


    @ManyToMany ( fetch = FetchType.LAZY)
    private List<Produto> produto;

    
    public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj){
        super(nomeFantasia, razaoSocial, cnpj);
    }

    // getters and setters
    public List<Produto> getProduto() {return produto;}
    public void setProduto(List<Produto> produto) {this.produto = produto;}    
}
