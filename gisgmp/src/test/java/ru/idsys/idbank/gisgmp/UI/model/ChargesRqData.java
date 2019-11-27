package ru.idsys.idbank.gisgmp.UI.model;

import java.util.Objects;

/**
 * Класс объекта Начисление
 * Содержит поля документа Запрос экспорта начислений
 * @author a.mylnikov
 */

public class ChargesRqData {

    private Long id;
    //Поля доступные для заполнения на вкладке "Запрос экспорта начислений"
    private String dataRequestType;
    private String startDateTime;
    private String endDateTime;
    private String qtObjInPortion;
    //Поля доступные для заполнения на вкладке "ЕСИА"
    private String idAccountEsia;
    private String idSessionEsia;
    private String DateTimeSessionOpen;
    private String userType;
    private String snils;
    private String inn;
    private String dulType;
    private String dulSeria;
    private String dulNumber;
    //Поля доступные для заполнения на вкладке "Запрашиваемые УИН"
    private String supplierBillId;
    //Поля доступные для заполнения на вкладке "Запрашиваемые плательщики"
    private String payerIdentifier;
    //Поля доступные для заполнения на вкладке "Запрашиваемые заявки"
    private String applicationId;


    public Long getId(){return  id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargesRqData that = (ChargesRqData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataRequestType, that.dataRequestType) &&
                Objects.equals(startDateTime, that.startDateTime) &&
                Objects.equals(endDateTime, that.endDateTime) &&
                Objects.equals(qtObjInPortion, that.qtObjInPortion) &&
                Objects.equals(idAccountEsia, that.idAccountEsia) &&
                Objects.equals(idSessionEsia, that.idSessionEsia) &&
                Objects.equals(DateTimeSessionOpen, that.DateTimeSessionOpen) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(snils, that.snils) &&
                Objects.equals(inn, that.inn) &&
                Objects.equals(dulType, that.dulType) &&
                Objects.equals(dulSeria, that.dulSeria) &&
                Objects.equals(dulNumber, that.dulNumber) &&
                Objects.equals(supplierBillId, that.supplierBillId) &&
                Objects.equals(payerIdentifier, that.payerIdentifier) &&
                Objects.equals(applicationId, that.applicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataRequestType, startDateTime, endDateTime, qtObjInPortion, idAccountEsia, idSessionEsia, DateTimeSessionOpen, userType, snils, inn, dulType, dulSeria, dulNumber, supplierBillId, payerIdentifier, applicationId);
    }

    public ChargesRqData withId(Long id){
        this.id = id;
        return this;
    }

    public String getDataRequestType() {
        return dataRequestType;
    }

    public ChargesRqData withDataRequestType(String dataRequestType) {
        this.dataRequestType = dataRequestType;
        return this;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public ChargesRqData withStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public ChargesRqData withEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    public String getQtObjInPortion() {
        return qtObjInPortion;
    }

    public ChargesRqData withQtObjInPortion(String qtObjInPortion) {
        this.qtObjInPortion = qtObjInPortion;
        return this;
    }

    public String getIdAccountEsia() {
        return idAccountEsia;
    }

    public ChargesRqData withIdAccountEsia(String idAccountEsia) {
        this.idAccountEsia = idAccountEsia;
        return this;
    }

    public String getIdSessionEsia() {
        return idSessionEsia;
    }

    public ChargesRqData withIdSessionEsia(String idSessionEsia) {
        this.idSessionEsia = idSessionEsia;
        return this;
    }

    public String getDateTimeSessionOpen() {
        return DateTimeSessionOpen;
    }

    public ChargesRqData withDateTimeSessionOpen(String dateTimeSessionOpen) {
        DateTimeSessionOpen = dateTimeSessionOpen;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public ChargesRqData withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    public String getSnils() {
        return snils;
    }

    public ChargesRqData withSnils(String snils) {
        this.snils = snils;
        return this;
    }

    public String getInn() {
        return inn;
    }

    public ChargesRqData withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public String getDulType() {
        return dulType;
    }

    public ChargesRqData withDulType(String dulType) {
        this.dulType = dulType;
        return this;
    }

    public String getDulSeria() {
        return dulSeria;
    }

    public ChargesRqData withDulSeria(String dulSeria) {
        this.dulSeria = dulSeria;
        return this;
    }

    public String getDulNumber() {
        return dulNumber;
    }

    public ChargesRqData withDulNumber(String dulNumber) {
        this.dulNumber = dulNumber;
        return this;
    }

    public String getSupplierBillId() {
        return supplierBillId;
    }

    public ChargesRqData withSupplierBillId(String supplierBillId) {
        this.supplierBillId = supplierBillId;
        return this;
    }

    public String getPayerIdentifier() {
        return payerIdentifier;
    }

    public ChargesRqData withPayerIdentifier(String payerIdentifier) {
        this.payerIdentifier = payerIdentifier;
        return this;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public ChargesRqData withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

}
