package ru.idsys.idbank.fns.innflchk.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс работы с множеством объектов InnFLRsData
 * @author a.mylnikov
 */
public class InnFLRss extends ForwardingSet<InnFLRsData> {
    private Set<InnFLRsData> delegate;

    public InnFLRss(Collection<InnFLRsData> requests){
        this.delegate = new HashSet<InnFLRsData>(requests);
    }

    public InnFLRss(){
        this.delegate = new HashSet<InnFLRsData>();
    }

    @Override
    protected Set<InnFLRsData> delegate() {
        return delegate;
    }

    /**
     * Метод возвращает множество объектов с добавленным документом который передается в параметре
     * @param document Параметр в котором методу передается добавляемое значение
     * @return Возвращается множество объектов с добавленным документом
     */
    public InnFLRss withAdded(InnFLRsData document){
        InnFLRss requests = new InnFLRss(this);
        requests.add(document);
        return requests;
    }

    /**
     * Метод возвращает множество объектов с удаленным документом который передается в параметре
     * @param document Параметр в котором методу передается удаляемое значение
     * @return Возвращается множество объектов с удаленным документом
     */
    public InnFLRss without(InnFLRqData document){
        InnFLRss requests = new InnFLRss(this);
        requests.remove(document);
        return requests;
    }

}
