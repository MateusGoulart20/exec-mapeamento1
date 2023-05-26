package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "vendedor")
public class Vendedor extends PessoaFisica {
    public Vendedor(){}

    @Column ( length = 40 , nullable = false )
    private float per_comissao ;

    @OneToMany (fetch = FetchType.LAZY)
    private List<Venda>  vendas;

    public Vendedor(String nome, String rg, String cpf, float per_comissao){
        super(nome, rg, cpf);
        this.per_comissao = per_comissao;
    }
    
    // getters and setters        
    public float getPer_comissao() {return per_comissao;}
    public void setPer_comissao(float per_comissao) {this.per_comissao = per_comissao;}

    public List<Venda> getVendas() {return vendas;}
    public void setVendas(List<Venda> vendas) {this.vendas = vendas;}   

    public float getComissao(float t){return t*(this.getPer_comissao()/100);}
}
