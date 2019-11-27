package ru.idsys.idbank.fns.innflchk.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс работы с множеством объектов InnFLRqData
 * @author a.mylnikov
 */

public class InnFLRqs extends ForwardingSet<InnFLRqData> {
    private Set<InnFLRqData> delegate;

    public InnFLRqs(Collection<InnFLRqData> requests){
        this.delegate = new HashSet<InnFLRqData>(requests);
    }

    public InnFLRqs(){
        this.delegate = new HashSet<InnFLRqData>();
    }

    @Override
    protected Set<InnFLRqData> delegate() {
        return delegate;
    }

    /**
     * Метод возвращает множество объектов с добавленным документом который передается в параметре
     * @param document Параметр в котором методу передается добавляемое значение
     * @return Возвращается множество объектов с добавленным документом
     */
    public InnFLRqs withAdded(InnFLRqData document){
        InnFLRqs requests = new InnFLRqs(this);
        requests.add(document);
        return requests;
    }

    /**
     * Метод возвращает множество объектов с удаленным документом который передается в параметре
     * @param document Параметр в котором методу передается удаляемое значение
     * @return Возвращается множество объектов с удаленным документом
     */
    public InnFLRqs without(InnFLRqData document){
        InnFLRqs requests = new InnFLRqs(this);
        requests.remove(document);
        return requests;
    }

}
