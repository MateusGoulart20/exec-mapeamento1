package ifmt.cba.vo;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table (name = "pessoa")
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {
    public Pessoa(){}
    public Pessoa(String nome){
        this.nome = nome;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column (length =  40, nullable = false)
    private String nome;
    
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    
}
