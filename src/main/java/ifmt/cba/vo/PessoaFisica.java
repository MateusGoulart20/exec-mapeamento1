package ifmt.cba.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "pessoa_fisica")
public abstract class PessoaFisica extends Pessoa {
    public PessoaFisica(){}
    
    @Column (length =  40, nullable = false)
    private String rg;

    @Column (length =  40, nullable = false)
    private String cpf;
    
    public PessoaFisica(String nome, String rg, String cpf){
        super(nome);
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getRg() {return rg;}
    public void setRg(String rg) {this.rg = rg;}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    
}
