package ifmt.cba.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "venda")
public class Venda implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int codigo ;

    @Column ( length = 40 , nullable = false )
    private Calendar data;

    @OneToMany ( fetch = FetchType.LAZY)
    private List<ItemVenda> itens;

    @ManyToOne ( fetch = FetchType.EAGER)
    private Vendedor vendedor;

    @ManyToOne ( fetch = FetchType.EAGER)
    private Cliente cliente;

    public Venda (){
        
    }
    public Venda(int a){
        this.data = Calendar.getInstance();
    }
    // getters and setters
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public Calendar getData() {return data;}
    public void setData(Calendar data) {this.data = data;}

    public List<ItemVenda> getItens() {return itens;}
    public void setItens(List<ItemVenda> itens) {this.itens = itens;}

    public Vendedor getVendedor() {return vendedor;}
    public void setVendedor(Vendedor vendedor) {this.vendedor = vendedor;}
    
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public float getValor(){
        float valor = 0;
        for(ItemVenda iei : this.getItens()){
            valor += iei.getTotal();
        }
        return valor;
    }
}
