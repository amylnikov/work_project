
package ru.id_sys.schemas.idbank.customer._2015._0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerDataType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomerDataType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Bankruptcy"/&gt;
 *     &lt;enumeration value="BankruptcyMessage"/&gt;
 *     &lt;enumeration value="BankruptcyReport"/&gt;
 *     &lt;enumeration value="SNILS_VALIDITY"/&gt;
 *     &lt;enumeration value="INN_MATCH"/&gt;
 *     &lt;enumeration value="ID_VALIDITY"/&gt;
 *     &lt;enumeration value="CHECKLIST"/&gt;
 *     &lt;enumeration value="ESIA_ACCOUNT"/&gt;
 *     &lt;enumeration value="FNS_GET_INN"/&gt;
 *     &lt;enumeration value="FNS_RESTRICTION"/&gt;
 *     &lt;enumeration value="OMS_MATCH"/&gt;
 *     &lt;enumeration value="FNS_INN_BY_PASSPORT"/&gt;
 *     &lt;enumeration value="FNS_RMSP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CustomerDataType")
@XmlEnum
public enum CustomerDataType {

    @XmlEnumValue("Bankruptcy")
    BANKRUPTCY("Bankruptcy"),
    @XmlEnumValue("BankruptcyMessage")
    BANKRUPTCY_MESSAGE("BankruptcyMessage"),
    @XmlEnumValue("BankruptcyReport")
    BANKRUPTCY_REPORT("BankruptcyReport"),
    SNILS_VALIDITY("SNILS_VALIDITY"),
    INN_MATCH("INN_MATCH"),
    ID_VALIDITY("ID_VALIDITY"),
    CHECKLIST("CHECKLIST"),
    ESIA_ACCOUNT("ESIA_ACCOUNT"),
    FNS_GET_INN("FNS_GET_INN"),
    FNS_RESTRICTION("FNS_RESTRICTION"),
    OMS_MATCH("OMS_MATCH"),
    FNS_INN_BY_PASSPORT("FNS_INN_BY_PASSPORT"),
    FNS_RMSP("FNS_RMSP");
    private final String value;

    CustomerDataType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CustomerDataType fromValue(String v) {
        for (CustomerDataType c: CustomerDataType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
