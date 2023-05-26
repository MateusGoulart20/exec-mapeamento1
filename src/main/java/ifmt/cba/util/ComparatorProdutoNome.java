package ifmt.cba.util;

import java.util.Comparator;

import ifmt.cba.vo.Produto;

public class ComparatorProdutoNome implements Comparator<Produto>{
    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
