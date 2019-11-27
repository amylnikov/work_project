
package ru.roskazna.xsd.responsetemplate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.unifo._2012._1.ExportChargesResponseEx;
import ru.roskazna.xsd.errinfo.ErrInfo;
import ru.roskazna.xsd.pgu_chargesresponse.ExportChargesResponse;
import ru.roskazna.xsd.postblock.PostBlock;
import ru.roskazna.xsd.ticket.Ticket;


/**
 * <p>Java class for ResponseTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseTemplate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PostBlock" type="{http://roskazna.ru/xsd/PostBlock}PostBlock"/&gt;
 *         &lt;element name="RequestProcessResult" type="{http://roskazna.ru/xsd/ErrInfo}ErrInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="hasMoreElements" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseTemplate", propOrder = {
    "postBlock",
    "requestProcessResult",
    "hasMoreElements"
})
@XmlSeeAlso({
    ExportChargesResponse.class,
    ExportChargesResponseEx.class,
    Ticket.class
})
public class ResponseTemplate {

    @XmlElement(name = "PostBlock", required = true)
    protected PostBlock postBlock;
    @XmlElement(name = "RequestProcessResult")
    protected List<ErrInfo> requestProcessResult;
    protected Boolean hasMoreElements;

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
     * Gets the value of the requestProcessResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestProcessResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestProcessResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrInfo }
     * 
     * 
     */
    public List<ErrInfo> getRequestProcessResult() {
        if (requestProcessResult == null) {
            requestProcessResult = new ArrayList<ErrInfo>();
        }
        return this.requestProcessResult;
    }

    /**
     * Gets the value of the hasMoreElements property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasMoreElements() {
        return hasMoreElements;
    }

    /**
     * Sets the value of the hasMoreElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasMoreElements(Boolean value) {
        this.hasMoreElements = value;
    }

}
