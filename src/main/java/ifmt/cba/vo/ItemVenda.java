package ifmt.cba.vo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table ( name = "item_venda")
public class ItemVenda implements Serializable {
    public ItemVenda(){}

    @Id
    @GeneratedValue ( strategy = GenerationType.SEQUENCE)
    private int codigo ;

    @Column ( length = 40 , nullable = false )
    private int quantidade ;

    @Column ( length = 40 , nullable = false )
    private float preco_venda ;

    @Column ( length = 40 , nullable = false )
    private float per_desconto ;

    @ManyToOne( fetch = FetchType.EAGER)
    private Produto produto ;

    public ItemVenda (int quantidade, float preco_venda, float per_desconto){
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.per_desconto = per_desconto;
    }
    // getters and setters
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public float getPreco_venda() {return preco_venda;}
    public void setPreco_venda(float preco_venda) {this.preco_venda = preco_venda;}

    public float getPer_desconto() {return per_desconto;}
    public void setPer_desconto(float per_desconto) {this.per_desconto = per_desconto;}
    
    public Produto getProduto() {return produto;}
    public void setProduto(Produto produto) {this.produto = produto;}  

    public float getTotal(){return this.getQuantidade()*this.getPreco_venda()*(1-(this.getPer_desconto()/100));}
}
