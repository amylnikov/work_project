package ru.idsys.idbank.fns.innflchk.model;

import java.util.Objects;

/**
 * Класс объекта «ответ на запрос проверки ИНН ФЛ»
 * @author a.mylnikov
 */

public class InnFLRsData {
    private Long id;
    //Блок Ответ
    private String answerType;
    private String resultMessage;
    private String answerDateTime;
    private String errorCode;
    private String errorDescription;

    public Long getId() {
        return id;
    }

    public InnFLRsData withId(Long id) {
        this.id = id;
        return this;
    }

    public String getAnswerType() {
        return answerType;
    }

    public InnFLRsData withAnswerType(String answerType) {
        this.answerType = answerType;
        return this;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public InnFLRsData withResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
        return this;
    }

    public String getAnswerDateTime() {
        return answerDateTime;
    }

    public InnFLRsData withAnswerDateTime(String answerDateTime) {
        this.answerDateTime = answerDateTime;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public InnFLRsData withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public InnFLRsData withErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnFLRsData that = (InnFLRsData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(answerType, that.answerType) &&
                Objects.equals(resultMessage, that.resultMessage) &&
                Objects.equals(answerDateTime, that.answerDateTime) &&
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(errorDescription, that.errorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerType, resultMessage, answerDateTime, errorCode, errorDescription);
    }
}
