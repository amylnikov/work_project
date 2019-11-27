
package com.triasoft.dev.schemas.eis.eregistry.pppr._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ��� �����������, ���������� ��������� 2.0
 * 
 * <p>Java class for PledgeNotificationToNotaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PledgeNotificationToNotaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}BankData" minOccurs="0"/&gt;
 *         &lt;element name="NotificationNotaryAddress" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}PledgeNotificationNotaryAddressType"/&gt;
 *         &lt;element name="NotificationData" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}PledgeNotificationDataType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="2.0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PledgeNotificationToNotaryType", propOrder = {
    "bankData",
    "notificationNotaryAddress",
    "notificationData"
})
public class PledgeNotificationToNotaryType {

    @XmlElement(name = "BankData")
    protected BankData bankData;
    @XmlElement(name = "NotificationNotaryAddress", required = true)
    protected PledgeNotificationNotaryAddressType notificationNotaryAddress;
    @XmlElement(name = "NotificationData", required = true)
    protected PledgeNotificationDataType notificationData;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * Gets the value of the bankData property.
     * 
     * @return
     *     possible object is
     *     {@link BankData }
     *     
     */
    public BankData getBankData() {
        return bankData;
    }

    /**
     * Sets the value of the bankData property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankData }
     *     
     */
    public void setBankData(BankData value) {
        this.bankData = value;
    }

    /**
     * Gets the value of the notificationNotaryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link PledgeNotificationNotaryAddressType }
     *     
     */
    public PledgeNotificationNotaryAddressType getNotificationNotaryAddress() {
        return notificationNotaryAddress;
    }

    /**
     * Sets the value of the notificationNotaryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link PledgeNotificationNotaryAddressType }
     *     
     */
    public void setNotificationNotaryAddress(PledgeNotificationNotaryAddressType value) {
        this.notificationNotaryAddress = value;
    }

    /**
     * Gets the value of the notificationData property.
     * 
     * @return
     *     possible object is
     *     {@link PledgeNotificationDataType }
     *     
     */
    public PledgeNotificationDataType getNotificationData() {
        return notificationData;
    }

    /**
     * Sets the value of the notificationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PledgeNotificationDataType }
     *     
     */
    public void setNotificationData(PledgeNotificationDataType value) {
        this.notificationData = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "2.0";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
