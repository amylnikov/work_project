
package ru.id_sys.schemas.idbank.common._2012._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ����� � �������� �������
 * 
 * <p>Java class for BinaryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BinaryResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BinaryFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinaryResult", propOrder = {
    "binaryFile"
})
public class BinaryResult {

    @XmlElement(name = "BinaryFile", required = true)
    protected byte[] binaryFile;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the binaryFile property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBinaryFile() {
        return binaryFile;
    }

    /**
     * Sets the value of the binaryFile property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBinaryFile(byte[] value) {
        this.binaryFile = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
