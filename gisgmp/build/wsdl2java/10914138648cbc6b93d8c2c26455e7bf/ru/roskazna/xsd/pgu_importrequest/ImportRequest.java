
package ru.roskazna.xsd.pgu_importrequest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.bssys.xsd.catalog.ServiceCatalogType;
import ru.roskazna.xsd.charge.ChargeType;
import ru.roskazna.xsd.paymentinfo.IncomeInfoType;
import ru.roskazna.xsd.paymentinfo.PaymentInfoType;
import ru.roskazna.xsd.postblock.PostBlock;


/**
 * Запрос на импорт в ИС РНиП
 * 
 * <p>Java class for ImportRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PostBlock" type="{http://roskazna.ru/xsd/PostBlock}PostBlock" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Charge" type="{http://roskazna.ru/xsd/Charge}ChargeType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="FinalPayment" type="{http://roskazna.ru/xsd/PaymentInfo}PaymentInfoType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="Income" type="{http://roskazna.ru/xsd/PaymentInfo}IncomeInfoType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="Catalog"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="Changes" type="{http://www.bssys.com/xsd/Catalog}ServiceCatalog_Type"/&gt;
 *                     &lt;element name="ServiceCatalog" type="{http://www.bssys.com/xsd/Catalog}ServiceCatalog_Type"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportRequest", propOrder = {
    "postBlock",
    "charge",
    "finalPayment",
    "income",
    "catalog"
})
public class ImportRequest {

    @XmlElement(name = "PostBlock")
    protected PostBlock postBlock;
    @XmlElement(name = "Charge")
    protected List<ChargeType> charge;
    @XmlElement(name = "FinalPayment")
    protected List<PaymentInfoType> finalPayment;
    @XmlElement(name = "Income")
    protected List<IncomeInfoType> income;
    @XmlElement(name = "Catalog")
    protected ImportRequest.Catalog catalog;

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
     * Gets the value of the charge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the charge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     * 
     * 
     */
    public List<ChargeType> getCharge() {
        if (charge == null) {
            charge = new ArrayList<ChargeType>();
        }
        return this.charge;
    }

    /**
     * Gets the value of the finalPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the finalPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinalPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentInfoType }
     * 
     * 
     */
    public List<PaymentInfoType> getFinalPayment() {
        if (finalPayment == null) {
            finalPayment = new ArrayList<PaymentInfoType>();
        }
        return this.finalPayment;
    }

    /**
     * Gets the value of the income property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the income property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncomeInfoType }
     * 
     * 
     */
    public List<IncomeInfoType> getIncome() {
        if (income == null) {
            income = new ArrayList<IncomeInfoType>();
        }
        return this.income;
    }

    /**
     * Gets the value of the catalog property.
     * 
     * @return
     *     possible object is
     *     {@link ImportRequest.Catalog }
     *     
     */
    public ImportRequest.Catalog getCatalog() {
        return catalog;
    }

    /**
     * Sets the value of the catalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportRequest.Catalog }
     *     
     */
    public void setCatalog(ImportRequest.Catalog value) {
        this.catalog = value;
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
     *         &lt;element name="Changes" type="{http://www.bssys.com/xsd/Catalog}ServiceCatalog_Type"/&gt;
     *         &lt;element name="ServiceCatalog" type="{http://www.bssys.com/xsd/Catalog}ServiceCatalog_Type"/&gt;
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
        "changes",
        "serviceCatalog"
    })
    public static class Catalog {

        @XmlElementRef(name = "Changes", type = JAXBElement.class, required = false)
        protected JAXBElement<ServiceCatalogType> changes;
        @XmlElement(name = "ServiceCatalog")
        protected ServiceCatalogType serviceCatalog;

        /**
         * Gets the value of the changes property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link ServiceCatalogType }{@code >}
         *     
         */
        public JAXBElement<ServiceCatalogType> getChanges() {
            return changes;
        }

        /**
         * Sets the value of the changes property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link ServiceCatalogType }{@code >}
         *     
         */
        public void setChanges(JAXBElement<ServiceCatalogType> value) {
            this.changes = value;
        }

        /**
         * Gets the value of the serviceCatalog property.
         * 
         * @return
         *     possible object is
         *     {@link ServiceCatalogType }
         *     
         */
        public ServiceCatalogType getServiceCatalog() {
            return serviceCatalog;
        }

        /**
         * Sets the value of the serviceCatalog property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceCatalogType }
         *     
         */
        public void setServiceCatalog(ServiceCatalogType value) {
            this.serviceCatalog = value;
        }

    }

}
