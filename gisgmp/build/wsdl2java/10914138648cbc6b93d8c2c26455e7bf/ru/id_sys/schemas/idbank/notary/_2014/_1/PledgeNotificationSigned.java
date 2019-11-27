
package ru.id_sys.schemas.idbank.notary._2014._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.triasoft.dev.schemas.eis.eregistry.pppr._2.PledgeNotificationToNotaryType;


/**
 * ����������� � ������ ��������� ��������� � ��
 * 
 * <p>Java class for PledgeNotificationSigned complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PledgeNotificationSigned"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}PledgeNotificationToNotary"/&gt;
 *         &lt;element name="Signature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PledgeNotificationSigned", propOrder = {
    "pledgeNotificationToNotary",
    "signature"
})
public class PledgeNotificationSigned {

    @XmlElement(name = "PledgeNotificationToNotary", namespace = "http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0", required = true)
    protected PledgeNotificationToNotaryType pledgeNotificationToNotary;
    @XmlElement(name = "Signature")
    protected byte[] signature;

    /**
     * Gets the value of the pledgeNotificationToNotary property.
     * 
     * @return
     *     possible object is
     *     {@link PledgeNotificationToNotaryType }
     *     
     */
    public PledgeNotificationToNotaryType getPledgeNotificationToNotary() {
        return pledgeNotificationToNotary;
    }

    /**
     * Sets the value of the pledgeNotificationToNotary property.
     * 
     * @param value
     *     allowed object is
     *     {@link PledgeNotificationToNotaryType }
     *     
     */
    public void setPledgeNotificationToNotary(PledgeNotificationToNotaryType value) {
        this.pledgeNotificationToNotary = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSignature(byte[] value) {
        this.signature = value;
    }

}
