
package ru.roskazna.xsd.organization;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.roskazna.xsd.common.AddressType;
import ru.roskazna.xsd.common.ContactInfoType;


/**
 * ������ �����, � ������� ������� ����� �����������
 * 
 * <p>Java class for BankType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Name" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CorrespondentBankAccount" type="{http://roskazna.ru/xsd/Common}AccountNumType" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="BIK"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;length value="9"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="SWIFT"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;length value="12"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Address" type="{http://roskazna.ru/xsd/Common}AddressType" minOccurs="0"/&gt;
 *         &lt;element name="Contacts" type="{http://roskazna.ru/xsd/Common}ContactInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankType", propOrder = {
    "name",
    "correspondentBankAccount",
    "bik",
    "swift",
    "address",
    "contacts"
})
public class BankType {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "CorrespondentBankAccount")
    protected String correspondentBankAccount;
    @XmlElement(name = "BIK")
    protected String bik;
    @XmlElement(name = "SWIFT")
    protected String swift;
    @XmlElement(name = "Address")
    protected AddressType address;
    @XmlElement(name = "Contacts")
    protected List<ContactInfoType> contacts;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the correspondentBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrespondentBankAccount() {
        return correspondentBankAccount;
    }

    /**
     * Sets the value of the correspondentBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrespondentBankAccount(String value) {
        this.correspondentBankAccount = value;
    }

    /**
     * Gets the value of the bik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIK() {
        return bik;
    }

    /**
     * Sets the value of the bik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIK(String value) {
        this.bik = value;
    }

    /**
     * Gets the value of the swift property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFT() {
        return swift;
    }

    /**
     * Sets the value of the swift property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFT(String value) {
        this.swift = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contacts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContacts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactInfoType }
     * 
     * 
     */
    public List<ContactInfoType> getContacts() {
        if (contacts == null) {
            contacts = new ArrayList<ContactInfoType>();
        }
        return this.contacts;
    }

}
