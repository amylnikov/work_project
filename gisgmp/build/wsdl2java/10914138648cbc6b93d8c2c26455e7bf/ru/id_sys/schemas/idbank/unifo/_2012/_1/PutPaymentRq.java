
package ru.id_sys.schemas.idbank.unifo._2012._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.Message;
import ru.roskazna.xsd.pgu_importrequest.ImportRequest;


/**
 * Запрос на отправку платежей в ГИС ГМП
 * 
 * <p>Java class for PutPaymentRq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PutPaymentRq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ImportRequest" type="{http://roskazna.ru/xsd/PGU_ImportRequest}ImportRequest"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PutPaymentRq", propOrder = {
    "importRequest"
})
public class PutPaymentRq
    extends Message
{

    @XmlElement(name = "ImportRequest", required = true)
    protected ImportRequest importRequest;

    /**
     * Gets the value of the importRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ImportRequest }
     *     
     */
    public ImportRequest getImportRequest() {
        return importRequest;
    }

    /**
     * Sets the value of the importRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportRequest }
     *     
     */
    public void setImportRequest(ImportRequest value) {
        this.importRequest = value;
    }

}
