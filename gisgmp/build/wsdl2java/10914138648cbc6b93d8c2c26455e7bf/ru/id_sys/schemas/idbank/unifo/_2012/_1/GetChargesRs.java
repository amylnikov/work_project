
package ru.id_sys.schemas.idbank.unifo._2012._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.Errors;
import ru.id_sys.schemas.idbank.common._2012._0.Message;


/**
 * Ответ на запрос на получение начислений из ГИС ГМП
 * 
 * <p>Java class for GetChargesRs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetChargesRs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExportChargesResponse" type="{http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/}ExportChargesResponseEx" minOccurs="0"/&gt;
 *         &lt;element name="Errors" type="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Errors" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetChargesRs", propOrder = {
    "exportChargesResponse",
    "errors"
})
public class GetChargesRs
    extends Message
{

    @XmlElement(name = "ExportChargesResponse")
    protected ExportChargesResponseEx exportChargesResponse;
    @XmlElement(name = "Errors")
    protected Errors errors;

    /**
     * Gets the value of the exportChargesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ExportChargesResponseEx }
     *     
     */
    public ExportChargesResponseEx getExportChargesResponse() {
        return exportChargesResponse;
    }

    /**
     * Sets the value of the exportChargesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportChargesResponseEx }
     *     
     */
    public void setExportChargesResponse(ExportChargesResponseEx value) {
        this.exportChargesResponse = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link Errors }
     *     
     */
    public Errors getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Errors }
     *     
     */
    public void setErrors(Errors value) {
        this.errors = value;
    }

}
