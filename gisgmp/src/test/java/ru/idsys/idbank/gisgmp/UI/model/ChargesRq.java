package ru.idsys.idbank.gisgmp.UI.model;

import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс который позволяет формировать список с сигнатурами данных для последующего использования при проверках
 * @author a.mylnikov
 */
public class ChargesRq extends ForwardingSet<ChargesRqData> {

    private Set<ChargesRqData> delegate;

    public ChargesRq (Collection<ChargesRqData> charges) {
        this.delegate = new HashSet<ChargesRqData>(charges);
    }

    public ChargesRq () {
        this.delegate = new HashSet<ChargesRqData>();
    }

    @Override
    protected Set<ChargesRqData> delegate() {
        return delegate;
    }

    public ChargesRq withAdded(ChargesRqData charg){
        ChargesRq charges = new ChargesRq(this);
        charges.add(charg);
        return charges;
    }

    public ChargesRq without(ChargesRqData charg){
        ChargesRq charges = new ChargesRq(this);
        charges.remove(charg);
        return charges;
    }

}
