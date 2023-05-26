package ifmt.cba.util;

import java.util.Comparator;

import ifmt.cba.vo.Venda;

public class ComparatorVendaData implements Comparator<Venda>{

    @Override
    public int compare(Venda o1, Venda o2) {
        return o1.getData().compareTo(o2.getData());
    }
    
}
