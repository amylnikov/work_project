
package ru.id_sys.schemas.idbank.esia._2015._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.ContactInfo;
import ru.id_sys.schemas.idbank.customer._2015._0.Customer;


/**
 * Запрос Центра регистрации
 * 
 * <p>Java class for AuthorityRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthorityRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthorityId"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OperatorSnils" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Customer" type="{http://www.id-sys.ru/schemas/idbank/customer/2015/0.01/}Customer"/&gt;
 *         &lt;element name="ContactInfo" type="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}ContactInfo" minOccurs="0"/&gt;
 *         &lt;element name="PasswordDeliveryType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="email"/&gt;
 *               &lt;enumeration value="mobile"/&gt;
 *               &lt;enumeration value="direct"/&gt;
 *               &lt;enumeration value="notRequired"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Address" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}AddressType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="addressReqEqualsHom" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorityRequest", propOrder = {
    "authorityId",
    "operatorSnils",
    "customer",
    "contactInfo",
    "passwordDeliveryType",
    "address",
    "addressReqEqualsHom"
})
public class AuthorityRequest {

    @XmlElement(name = "AuthorityId", required = true)
    protected String authorityId;
    @XmlElement(name = "OperatorSnils")
    protected String operatorSnils;
    @XmlElement(name = "Customer", required = true)
    protected Customer customer;
    @XmlElement(name = "ContactInfo")
    protected ContactInfo contactInfo;
    @XmlElement(name = "PasswordDeliveryType")
    protected String passwordDeliveryType;
    @XmlElement(name = "Address")
    protected List<AddressType> address;
    protected Boolean addressReqEqualsHom;

    /**
     * Gets the value of the authorityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * Sets the value of the authorityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityId(String value) {
        this.authorityId = value;
    }

    /**
     * Gets the value of the operatorSnils property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorSnils() {
        return operatorSnils;
    }

    /**
     * Sets the value of the operatorSnils property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorSnils(String value) {
        this.operatorSnils = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setContactInfo(ContactInfo value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the passwordDeliveryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswordDeliveryType() {
        return passwordDeliveryType;
    }

    /**
     * Sets the value of the passwordDeliveryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswordDeliveryType(String value) {
        this.passwordDeliveryType = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressType }
     * 
     * 
     */
    public List<AddressType> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressType>();
        }
        return this.address;
    }

    /**
     * Gets the value of the addressReqEqualsHom property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddressReqEqualsHom() {
        return addressReqEqualsHom;
    }

    /**
     * Sets the value of the addressReqEqualsHom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddressReqEqualsHom(Boolean value) {
        this.addressReqEqualsHom = value;
    }

}
