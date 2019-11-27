
package com.triasoft.dev.schemas.eis.eregistry.pppr._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ��� ����� ����������� ����
 * 
 * <p>Java class for AddressPrivatePersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressPrivatePersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="AddressRF" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}AddressPrivatePersonRFType"/&gt;
 *         &lt;element name="AddressForeign" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}AddressPrivatePersonForeignType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressPrivatePersonType", propOrder = {
    "addressRF",
    "addressForeign"
})
public class AddressPrivatePersonType {

    @XmlElement(name = "AddressRF")
    protected AddressPrivatePersonRFType addressRF;
    @XmlElement(name = "AddressForeign")
    protected AddressPrivatePersonForeignType addressForeign;

    /**
     * Gets the value of the addressRF property.
     * 
     * @return
     *     possible object is
     *     {@link AddressPrivatePersonRFType }
     *     
     */
    public AddressPrivatePersonRFType getAddressRF() {
        return addressRF;
    }

    /**
     * Sets the value of the addressRF property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressPrivatePersonRFType }
     *     
     */
    public void setAddressRF(AddressPrivatePersonRFType value) {
        this.addressRF = value;
    }

    /**
     * Gets the value of the addressForeign property.
     * 
     * @return
     *     possible object is
     *     {@link AddressPrivatePersonForeignType }
     *     
     */
    public AddressPrivatePersonForeignType getAddressForeign() {
        return addressForeign;
    }

    /**
     * Sets the value of the addressForeign property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressPrivatePersonForeignType }
     *     
     */
    public void setAddressForeign(AddressPrivatePersonForeignType value) {
        this.addressForeign = value;
    }

}
