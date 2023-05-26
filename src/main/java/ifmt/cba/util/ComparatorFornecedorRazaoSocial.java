package ifmt.cba.util;

import java.util.Comparator;

import ifmt.cba.vo.Fornecedor;

public class ComparatorFornecedorRazaoSocial implements Comparator<Fornecedor>{

    @Override
    public int compare(Fornecedor o1, Fornecedor o2) {
        return o1.getRazao_social().compareTo(o2.getRazao_social());
    }
    
}
