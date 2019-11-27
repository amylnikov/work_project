
package ru.roskazna.xsd.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressKindType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressKindType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Zip"/&gt;
 *     &lt;enumeration value="Country"/&gt;
 *     &lt;enumeration value="Region"/&gt;
 *     &lt;enumeration value="State"/&gt;
 *     &lt;enumeration value="Town"/&gt;
 *     &lt;enumeration value="City"/&gt;
 *     &lt;enumeration value="Street"/&gt;
 *     &lt;enumeration value="House"/&gt;
 *     &lt;enumeration value="Building"/&gt;
 *     &lt;enumeration value="Flat"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AddressKindType")
@XmlEnum
public enum AddressKindType {

    @XmlEnumValue("Zip")
    ZIP("Zip"),
    @XmlEnumValue("Country")
    COUNTRY("Country"),
    @XmlEnumValue("Region")
    REGION("Region"),
    @XmlEnumValue("State")
    STATE("State"),
    @XmlEnumValue("Town")
    TOWN("Town"),
    @XmlEnumValue("City")
    CITY("City"),
    @XmlEnumValue("Street")
    STREET("Street"),
    @XmlEnumValue("House")
    HOUSE("House"),
    @XmlEnumValue("Building")
    BUILDING("Building"),
    @XmlEnumValue("Flat")
    FLAT("Flat");
    private final String value;

    AddressKindType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressKindType fromValue(String v) {
        for (AddressKindType c: AddressKindType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
