
package ru.id_sys.schemas.idbank.common._2012._0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommonDocType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommonDocType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RegistrationCertificate"/&gt;
 *     &lt;enumeration value="RegistrationReject"/&gt;
 *     &lt;enumeration value="�������"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CommonDocType")
@XmlEnum
public enum CommonDocType {

    @XmlEnumValue("RegistrationCertificate")
    REGISTRATION_CERTIFICATE("RegistrationCertificate"),
    @XmlEnumValue("RegistrationReject")
    REGISTRATION_REJECT("RegistrationReject"),
    @XmlEnumValue("\u041f\u0435\u0440\u0441\u043e\u043d\u0430")
    �������("\u041f\u0435\u0440\u0441\u043e\u043d\u0430");
    private final String value;

    CommonDocType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommonDocType fromValue(String v) {
        for (CommonDocType c: CommonDocType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
