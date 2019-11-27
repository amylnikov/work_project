
package ru.roskazna.xsd.organization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Данные КФО для Страницы Оплаты
 * 
 * <p>Java class for KFOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KFOType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://roskazna.ru/xsd/Organization}OrganizationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KFOStatus"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="KFORequisites" type="{http://roskazna.ru/xsd/Organization}BankType"/&gt;
 *         &lt;element name="dboSiteURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;element name="certificate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KFOType", propOrder = {
    "kfoStatus",
    "kfoRequisites",
    "dboSiteURL",
    "certificate"
})
public class KFOType
    extends OrganizationType
{

    @XmlElement(name = "KFOStatus", required = true)
    protected String kfoStatus;
    @XmlElement(name = "KFORequisites", required = true)
    protected BankType kfoRequisites;
    @XmlSchemaType(name = "anyURI")
    protected String dboSiteURL;
    protected String certificate;

    /**
     * Gets the value of the kfoStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKFOStatus() {
        return kfoStatus;
    }

    /**
     * Sets the value of the kfoStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKFOStatus(String value) {
        this.kfoStatus = value;
    }

    /**
     * Gets the value of the kfoRequisites property.
     * 
     * @return
     *     possible object is
     *     {@link BankType }
     *     
     */
    public BankType getKFORequisites() {
        return kfoRequisites;
    }

    /**
     * Sets the value of the kfoRequisites property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankType }
     *     
     */
    public void setKFORequisites(BankType value) {
        this.kfoRequisites = value;
    }

    /**
     * Gets the value of the dboSiteURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDboSiteURL() {
        return dboSiteURL;
    }

    /**
     * Sets the value of the dboSiteURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDboSiteURL(String value) {
        this.dboSiteURL = value;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificate(String value) {
        this.certificate = value;
    }

}
