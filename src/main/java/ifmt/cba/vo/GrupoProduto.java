package ifmt.cba.vo;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table ( name = "grupo_produto")
public class GrupoProduto implements Serializable{
    public GrupoProduto(){}
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column ( length = 40 , nullable = false )
    private String nome;

    public GrupoProduto (String nome){
        this.nome = nome;
    }

    // getters and setters
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    
    
}
