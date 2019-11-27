
package ru.roskazna.xsd.requesttemplate;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.roskazna.xsd.pgu_datarequest.DataRequest;
import ru.roskazna.xsd.postblock.PostBlock;


/**
 * Шаблон запроса к ИС РНиП
 * 
 * <p>Java class for RequestTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestTemplate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PostBlock" type="{http://roskazna.ru/xsd/PostBlock}PostBlock"/&gt;
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="Paging" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="pageNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *                 &lt;attribute name="pageSize" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="kind"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="PAYMENT"/&gt;
 *             &lt;enumeration value="PAYMENTUNMATCHED"/&gt;
 *             &lt;enumeration value="PAYMENTMODIFIED"/&gt;
 *             &lt;enumeration value="PAYMENTMAINCHARGE"/&gt;
 *             &lt;enumeration value="CHARGE"/&gt;
 *             &lt;enumeration value="CHARGENOTFULLMATCHED"/&gt;
 *             &lt;enumeration value="INCOME"/&gt;
 *             &lt;enumeration value="ALLQUITTANCE"/&gt;
 *             &lt;enumeration value="QUITTANCE"/&gt;
 *             &lt;enumeration value="CHARGESTATUS"/&gt;
 *             &lt;enumeration value="CATALOG"/&gt;
 *             &lt;enumeration value="CHARGE-PRIOR"/&gt;
 *             &lt;enumeration value="CHARGE-PRIOR-NOTFULLMATCHED"/&gt;
 *             &lt;enumeration value="CHARGE-PRIOR-STATUS"/&gt;
 *             &lt;enumeration value="TEMP-CHARGING"/&gt;
 *             &lt;enumeration value="TEMP-CHARGING-NOTFULLMATCHED"/&gt;
 *             &lt;enumeration value="TEMP-CHARGING-STATUS"/&gt;
 *             &lt;enumeration value="PAYMENTCANCELLED"/&gt;
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
@XmlType(name = "RequestTemplate", propOrder = {
    "postBlock",
    "startDate",
    "endDate",
    "paging"
})
@XmlSeeAlso({
    DataRequest.class
})
public class RequestTemplate {

    @XmlElement(name = "PostBlock", required = true)
    protected PostBlock postBlock;
    @XmlElement(name = "StartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "Paging")
    protected RequestTemplate.Paging paging;
    @XmlAttribute(name = "kind")
    protected String kind;

    /**
     * Gets the value of the postBlock property.
     * 
     * @return
     *     possible object is
     *     {@link PostBlock }
     *     
     */
    public PostBlock getPostBlock() {
        return postBlock;
    }

    /**
     * Sets the value of the postBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostBlock }
     *     
     */
    public void setPostBlock(PostBlock value) {
        this.postBlock = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link RequestTemplate.Paging }
     *     
     */
    public RequestTemplate.Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestTemplate.Paging }
     *     
     */
    public void setPaging(RequestTemplate.Paging value) {
        this.paging = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKind(String value) {
        this.kind = value;
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
     *       &lt;attribute name="pageNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
     *       &lt;attribute name="pageSize" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
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
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger pageNumber;
        @XmlAttribute(name = "pageSize")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger pageSize;

        /**
         * Gets the value of the pageNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPageNumber() {
            return pageNumber;
        }

        /**
         * Sets the value of the pageNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPageNumber(BigInteger value) {
            this.pageNumber = value;
        }

        /**
         * Gets the value of the pageSize property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPageSize() {
            return pageSize;
        }

        /**
         * Sets the value of the pageSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPageSize(BigInteger value) {
            this.pageSize = value;
        }

    }

}
