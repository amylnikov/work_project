
package ru.id_sys.schemas.idbank.customer._2015._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.Object;


/**
 * Документ клиента
 * 
 * <p>Java class for CustomerDocument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerDocument"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Object"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="BinaryDocument" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerDocument", propOrder = {
    "binaryDocument"
})
public class CustomerDocument
    extends Object
{

    @XmlElement(name = "BinaryDocument")
    protected byte[] binaryDocument;

    /**
     * Gets the value of the binaryDocument property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBinaryDocument() {
        return binaryDocument;
    }

    /**
     * Sets the value of the binaryDocument property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBinaryDocument(byte[] value) {
        this.binaryDocument = value;
    }

}
