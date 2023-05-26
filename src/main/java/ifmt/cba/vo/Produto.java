package ifmt.cba.vo;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table ( name = "produto")
public class Produto implements Serializable{
    public Produto(){}

    @Id
    @GeneratedValue ( strategy = GenerationType.SEQUENCE)
    private int codigo ;

    @Column ( length = 40 , nullable = false )
    private String nome ;

    @Column ( length = 5 , nullable =  false )
    private float preco_venda ;

    @ManyToOne (fetch = FetchType.LAZY)
    private GrupoProduto grupo_produto ; 

    @ManyToMany (fetch = FetchType.LAZY)
    private List<Fornecedor> forncedores;

    public Produto (String nome, float preco_venda){
        this.nome = nome;
        this.preco_venda = preco_venda;
    }
    // getter and setters
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public float getPreco_venda() {return preco_venda;}
    public void setPreco_venda(float preco_venda) {this.preco_venda = preco_venda;}

    public GrupoProduto getGrupo_produto() {return grupo_produto;}
    public void setGrupo_produto(GrupoProduto grupo_produto) {this.grupo_produto = grupo_produto;}
    
    public List<Fornecedor> getForncedores() {return forncedores;}
    public void setForncedores(List<Fornecedor> forncedores) {this.forncedores = forncedores;}   
}
