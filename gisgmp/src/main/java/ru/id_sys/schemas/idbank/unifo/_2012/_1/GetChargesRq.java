
package ru.id_sys.schemas.idbank.unifo._2012._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.Message;
import ru.roskazna.xsd.pgu_datarequest.DataRequest;


/**
 * Запрос на получение начислений из ГИС ГМП
 * 
 * <p>Java class for GetChargesRq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetChargesRq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChargesMode" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="1"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DataRequest" type="{http://roskazna.ru/xsd/PGU_DataRequest}DataRequest"/&gt;
 *         &lt;element name="Paging" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="pageNumber" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                       &lt;minInclusive value="1"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="pageLength" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                       &lt;minInclusive value="1"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetChargesRq", propOrder = {
    "chargesMode",
    "dataRequest",
    "paging"
})
public class GetChargesRq
    extends Message
{

    @XmlElement(name = "ChargesMode")
    protected String chargesMode;
    @XmlElement(name = "DataRequest", required = true)
    protected DataRequest dataRequest;
    @XmlElement(name = "Paging")
    protected GetChargesRq.Paging paging;

    /**
     * Gets the value of the chargesMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargesMode() {
        return chargesMode;
    }

    /**
     * Sets the value of the chargesMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargesMode(String value) {
        this.chargesMode = value;
    }

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

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link GetChargesRq.Paging }
     *     
     */
    public GetChargesRq.Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetChargesRq.Paging }
     *     
     */
    public void setPaging(GetChargesRq.Paging value) {
        this.paging = value;
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
     *       &lt;attribute name="pageNumber" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *             &lt;minInclusive value="1"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="pageLength" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *             &lt;minInclusive value="1"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Paging {

        @XmlAttribute(name = "pageNumber", required = true)
        protected int pageNumber;
        @XmlAttribute(name = "pageLength", required = true)
        protected int pageLength;

        /**
         * Gets the value of the pageNumber property.
         * 
         */
        public int getPageNumber() {
            return pageNumber;
        }

        /**
         * Sets the value of the pageNumber property.
         * 
         */
        public void setPageNumber(int value) {
            this.pageNumber = value;
        }

        /**
         * Gets the value of the pageLength property.
         * 
         */
        public int getPageLength() {
            return pageLength;
        }

        /**
         * Sets the value of the pageLength property.
         * 
         */
        public void setPageLength(int value) {
            this.pageLength = value;
        }

    }

}
