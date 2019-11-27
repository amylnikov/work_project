
package ru.id_sys.schemas.idbank.esia._2015._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �������������� �������
 * 
 * <p>Java class for BiometricDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiometricDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Modality"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="PHOTO"/&gt;
 *               &lt;enumeration value="SOUND"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AttachmentFileName"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BinaryAttachment" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="BioMetadata" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}BioMetadataType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiometricDataType", propOrder = {
    "modality",
    "attachmentFileName",
    "binaryAttachment",
    "bioMetadata"
})
public class BiometricDataType {

    @XmlElement(name = "Modality", required = true)
    protected String modality;
    @XmlElement(name = "AttachmentFileName", required = true)
    protected String attachmentFileName;
    @XmlElement(name = "BinaryAttachment", required = true)
    protected byte[] binaryAttachment;
    @XmlElement(name = "BioMetadata")
    protected BioMetadataType bioMetadata;

    /**
     * Gets the value of the modality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModality() {
        return modality;
    }

    /**
     * Sets the value of the modality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModality(String value) {
        this.modality = value;
    }

    /**
     * Gets the value of the attachmentFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentFileName() {
        return attachmentFileName;
    }

    /**
     * Sets the value of the attachmentFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentFileName(String value) {
        this.attachmentFileName = value;
    }

    /**
     * Gets the value of the binaryAttachment property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBinaryAttachment() {
        return binaryAttachment;
    }

    /**
     * Sets the value of the binaryAttachment property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBinaryAttachment(byte[] value) {
        this.binaryAttachment = value;
    }

    /**
     * Gets the value of the bioMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link BioMetadataType }
     *     
     */
    public BioMetadataType getBioMetadata() {
        return bioMetadata;
    }

    /**
     * Sets the value of the bioMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BioMetadataType }
     *     
     */
    public void setBioMetadata(BioMetadataType value) {
        this.bioMetadata = value;
    }

}
