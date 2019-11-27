package ru.idsys.idbank.gisgmp.UI.model;

import java.util.Objects;

public class ChargesRsData {

    private Long id;
    //Поля доступные в таблицах в базе
    private String amountToPay;
    private String isRevoked;
    private String revokeDate;
    private String quittancePaymentStatus;
    private String needReRequest;
    //Поля присутствуют только в респонсе сервиса
    private String chargeData;

    public Long getId() {
        return id;
    }

    public ChargesRsData withId(Long id) {
        this.id = id;
        return this;
    }

    public String getAmountToPay() {
        return amountToPay;
    }

    public ChargesRsData withAmountToPay(String amountToPay) {
        this.amountToPay = amountToPay;
        return this;
    }

    public String getIsRevoked() {
        return isRevoked;
    }

    public ChargesRsData withIsRevoked(String isRevoked) {
        this.isRevoked = isRevoked;
        return this;
    }

    public String getRevokeDate() {
        return revokeDate;
    }

    public ChargesRsData withRevokeDate(String revokeDate) {
        this.revokeDate = revokeDate;
        return this;
    }

    public String getQuittancePaymentStatus() {
        return quittancePaymentStatus;
    }

    public ChargesRsData withQuittancePaymentStatus(String quittancePaymentStatus) {
        this.quittancePaymentStatus = quittancePaymentStatus;
        return this;
    }

    public String getNeedReRequest() {
        return needReRequest;
    }

    public ChargesRsData withNeedReRequest(String needReRequest) {
        this.needReRequest = needReRequest;
        return this;
    }

    public String getChargeData() {
        return chargeData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargesRsData that = (ChargesRsData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(amountToPay, that.amountToPay) &&
                Objects.equals(isRevoked, that.isRevoked) &&
                Objects.equals(revokeDate, that.revokeDate) &&
                Objects.equals(quittancePaymentStatus, that.quittancePaymentStatus) &&
                Objects.equals(chargeData, that.chargeData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountToPay, isRevoked, revokeDate, quittancePaymentStatus, chargeData);
    }

    public ChargesRsData withChargeData(String chargeData) {
        this.chargeData = chargeData;
        return this;
    }
}
