package ru.idsys.idbank.gisgmp.UI.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ChargesRs extends ForwardingSet<ChargesRsData> {
    private Set<ChargesRsData> delegate;

    public ChargesRs (Collection<ChargesRsData> charges) {
        this.delegate = new HashSet<ChargesRsData>(charges);
    }

    public ChargesRs () {
        this.delegate = new HashSet<ChargesRsData>();
    }

    @Override
    protected Set<ChargesRsData> delegate() {
        return delegate;
    }

    public ChargesRs withAdded(ChargesRsData charg){
        ChargesRs charges = new ChargesRs(this);
        charges.add(charg);
        return charges;
    }

    public ChargesRs without(ChargesRsData charg){
        ChargesRs charges = new ChargesRs(this);
        charges.remove(charg);
        return charges;
    }

}
