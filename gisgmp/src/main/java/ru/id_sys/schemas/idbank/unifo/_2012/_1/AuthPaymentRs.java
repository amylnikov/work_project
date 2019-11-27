
package ru.id_sys.schemas.idbank.unifo._2012._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.Message;
import ru.id_sys.schemas.idbank.common._2012._0.ObjectStatus;


/**
 * Ответ на запрос на авторизацию платежа
 * 
 * <p>Java class for AuthPaymentRs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthPaymentRs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProcessingResult" type="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}ObjectStatus" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthPaymentRs", propOrder = {
    "processingResult"
})
public class AuthPaymentRs
    extends Message
{

    @XmlElement(name = "ProcessingResult", required = true)
    protected List<ObjectStatus> processingResult;

    /**
     * Gets the value of the processingResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processingResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessingResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectStatus }
     * 
     * 
     */
    public List<ObjectStatus> getProcessingResult() {
        if (processingResult == null) {
            processingResult = new ArrayList<ObjectStatus>();
        }
        return this.processingResult;
    }

}
