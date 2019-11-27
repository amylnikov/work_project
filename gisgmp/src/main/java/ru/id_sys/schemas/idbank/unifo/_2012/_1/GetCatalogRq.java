
package ru.id_sys.schemas.idbank.unifo._2012._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.Message;
import ru.roskazna.xsd.pgu_datarequest.DataRequest;


/**
 * Запрос на получение каталога услуг из ИС РНИП
 * 
 * <p>Java class for GetCatalogRq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCatalogRq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DataRequest" type="{http://roskazna.ru/xsd/PGU_DataRequest}DataRequest"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCatalogRq", propOrder = {
    "dataRequest"
})
public class GetCatalogRq
    extends Message
{

    @XmlElement(name = "DataRequest", required = true)
    protected DataRequest dataRequest;

    /**
     * Gets the value of the dataRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DataRequest }
     *     
     */
    public DataRequest getDataRequest() {
        return dataRequest;
    }

    /**
     * Sets the value of the dataRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRequest }
     *     
     */
    public void setDataRequest(DataRequest value) {
        this.dataRequest = value;
    }

}
