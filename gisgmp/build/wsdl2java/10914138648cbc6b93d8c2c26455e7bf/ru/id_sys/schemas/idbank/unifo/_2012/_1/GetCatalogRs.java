
package ru.id_sys.schemas.idbank.unifo._2012._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.bssys.xsd.catalog.ServiceType;
import ru.id_sys.schemas.idbank.common._2012._0.Errors;
import ru.id_sys.schemas.idbank.common._2012._0.Message;


/**
 * Ответ на запрос на получение каталога услуг из ИС РНИП
 * 
 * <p>Java class for GetCatalogRs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCatalogRs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Catalog" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="BinaryData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                   &lt;element name="Service" type="{http://www.bssys.com/xsd/Catalog}Service_Type" maxOccurs="unbounded"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "GetCatalogRs", propOrder = {
    "catalog",
    "errors"
})
public class GetCatalogRs
    extends Message
{

    @XmlElement(name = "Catalog")
    protected GetCatalogRs.Catalog catalog;
    @XmlElement(name = "Errors")
    protected Errors errors;

    /**
     * Gets the value of the catalog property.
     * 
     * @return
     *     possible object is
     *     {@link GetCatalogRs.Catalog }
     *     
     */
    public GetCatalogRs.Catalog getCatalog() {
        return catalog;
    }

    /**
     * Sets the value of the catalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCatalogRs.Catalog }
     *     
     */
    public void setCatalog(GetCatalogRs.Catalog value) {
        this.catalog = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element name="BinaryData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *         &lt;element name="Service" type="{http://www.bssys.com/xsd/Catalog}Service_Type" maxOccurs="unbounded"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "binaryData",
        "service"
    })
    public static class Catalog {

        @XmlElement(name = "BinaryData")
        protected byte[] binaryData;
        @XmlElement(name = "Service")
        protected List<ServiceType> service;

        /**
         * Gets the value of the binaryData property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getBinaryData() {
            return binaryData;
        }

        /**
         * Sets the value of the binaryData property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setBinaryData(byte[] value) {
            this.binaryData = value;
        }

        /**
         * Gets the value of the service property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the service property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ServiceType }
         * 
         * 
         */
        public List<ServiceType> getService() {
            if (service == null) {
                service = new ArrayList<ServiceType>();
            }
            return this.service;
        }

    }

}
