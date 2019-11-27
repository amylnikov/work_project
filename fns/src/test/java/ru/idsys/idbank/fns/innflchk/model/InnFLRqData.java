package ru.idsys.idbank.fns.innflchk.model;

import java.util.Objects;

/**
 * Класс объекта «Запрос проверки ИНН ФЛ»
 * @author a.mylnikov
 */

public class InnFLRqData {
    private Long id;
    //Блок ИНН
    private String personInn;
    //Блок Установочные данные
    private String lastName;
    private String firstName;
    private String secondName;
    //Блок Сведения о ДУЛ
    private String dulDocId;
    private String docName;
    private String dulSerial;
    private String dulNumber;
    private String dulEmitentName;
    private String dulDeptCode;
    private String dulDate;
    //Статус
    private String docStatusId;

    public Long getId() {
        return id;
    }

    public InnFLRqData withId(Long id) {
        this.id = id;
        return this;
    }

    public String getPersonInn() {
        return personInn;
    }

    public InnFLRqData withPersonInn(String personInn) {
        this.personInn = personInn;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public InnFLRqData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public InnFLRqData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSecondName() {
        return secondName;
    }

    public InnFLRqData withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public String getDulDocId() {
        return dulDocId;
    }

    public InnFLRqData withDulDocId(String dulDocId) {
        this.dulDocId = dulDocId;
        return this;
    }

    public String getDocName() {
        return docName;
    }

    public InnFLRqData withDocName(String docName) {
        this.docName = docName;
        return this;
    }

    public String getDulSerial() {
        return dulSerial;
    }

    public InnFLRqData withDulSerial(String dulSerial) {
        this.dulSerial = dulSerial;
        return this;
    }

    public String getDulNumber() {
        return dulNumber;
    }

    public InnFLRqData withDulNumber(String dulNumber) {
        this.dulNumber = dulNumber;
        return this;
    }

    public String getDulEmitentName() {
        return dulEmitentName;
    }

    public InnFLRqData withDulEmitentName(String dulEmitentName) {
        this.dulEmitentName = dulEmitentName;
        return this;
    }

    public String getDulDeptCode() {
        return dulDeptCode;
    }

    public InnFLRqData withDulDeptCode(String dulDeptCode) {
        this.dulDeptCode = dulDeptCode;
        return this;
    }

    public String getDulDate() {
        return dulDate;
    }

    public InnFLRqData withDulDate(String dulDate) {
        this.dulDate = dulDate;
        return this;
    }

    public String getDocStatusId() {
        return docStatusId;
    }

    public InnFLRqData withDocStatusId(String docStatusId) {
        this.docStatusId = docStatusId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnFLRqData that = (InnFLRqData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(personInn, that.personInn) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(dulDocId, that.dulDocId) &&
                Objects.equals(docName, that.docName) &&
                Objects.equals(dulSerial, that.dulSerial) &&
                Objects.equals(dulNumber, that.dulNumber) &&
                Objects.equals(dulEmitentName, that.dulEmitentName) &&
                Objects.equals(dulDeptCode, that.dulDeptCode) &&
                Objects.equals(dulDate, that.dulDate) &&
                Objects.equals(docStatusId, that.docStatusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personInn, lastName, firstName, secondName, dulDocId, docName, dulSerial, dulNumber, dulEmitentName, dulDeptCode, dulDate, docStatusId);
    }
}
