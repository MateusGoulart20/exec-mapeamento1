package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente extends PessoaFisica {
    public Cliente(){}    

    @Column ( length = 40 , nullable = false )
    private float limiteCredito;

    @OneToMany (fetch = FetchType.EAGER)
    private List<Venda> vendas;

    public Cliente (String nome, String rg, String cpf, float limiteCredito){
        super(nome, rg, cpf);
        this.limiteCredito = limiteCredito;
    }

    // getters and setters
    public List<Venda> getVendas() {return vendas;}
    public void setVendas(List<Venda> vendas) {this.vendas = vendas;}   
}
