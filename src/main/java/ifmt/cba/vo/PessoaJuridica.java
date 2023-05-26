package ifmt.cba.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "pessoa_juridica")
public abstract class PessoaJuridica extends Pessoa {
    public PessoaJuridica (){}
    
    @Column (length =  40, nullable = false)
    private String razaoSocial;

    @Column (length =  40, nullable = false)
    private String cnpj;

    public PessoaJuridica(String nomeFantasia, String razaoSocial, String cnpj ){
        super(nomeFantasia);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getRazao_social() {return razaoSocial;}
    public void setRazao_social(String razaoSocial) {this.razaoSocial = razaoSocial;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getNomeFantasia() {return getNome();}
    public void setNomeFantasia(String nomeFantasia) {setNome(nomeFantasia);}

    
}
