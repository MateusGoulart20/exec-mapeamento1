package ifmt.cba.util;

import java.util.Comparator;

import ifmt.cba.vo.Pessoa;

public class ComparatorPessoaNome implements Comparator<Pessoa>{

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
    
}
