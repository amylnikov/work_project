
package ru.id_sys.schemas.idbank.unifo._2012._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.id_sys.schemas.idbank.common._2012._0.Message;
import ru.roskazna.xsd.paymentinfo.PaymentInfoType;


/**
 * Запрос на загрузку контрольного массива платежей для сверки в iDБанк
 * 
 * <p>Java class for PutRefPaymentsRq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PutRefPaymentsRq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransactionDay" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="HaveMore" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="RefPayments"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="RefPayment" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="FinalPayment" type="{http://roskazna.ru/xsd/PaymentInfo}PaymentInfoType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="SystemIdentifier" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;minLength value="0"/&gt;
 *                                 &lt;maxLength value="36"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
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
@XmlType(name = "PutRefPaymentsRq", propOrder = {
    "transactionDay",
    "haveMore",
    "refPayments"
})
public class PutRefPaymentsRq
    extends Message
{

    @XmlElement(name = "TransactionDay", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar transactionDay;
    @XmlElement(name = "HaveMore", defaultValue = "false")
    protected Boolean haveMore;
    @XmlElement(name = "RefPayments", required = true)
    protected PutRefPaymentsRq.RefPayments refPayments;

    /**
     * Gets the value of the transactionDay property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionDay() {
        return transactionDay;
    }

    /**
     * Sets the value of the transactionDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionDay(XMLGregorianCalendar value) {
        this.transactionDay = value;
    }

    /**
     * Gets the value of the haveMore property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHaveMore() {
        return haveMore;
    }

    /**
     * Sets the value of the haveMore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHaveMore(Boolean value) {
        this.haveMore = value;
    }

    /**
     * Gets the value of the refPayments property.
     * 
     * @return
     *     possible object is
     *     {@link PutRefPaymentsRq.RefPayments }
     *     
     */
    public PutRefPaymentsRq.RefPayments getRefPayments() {
        return refPayments;
    }

    /**
     * Sets the value of the refPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link PutRefPaymentsRq.RefPayments }
     *     
     */
    public void setRefPayments(PutRefPaymentsRq.RefPayments value) {
        this.refPayments = value;
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
     *       &lt;sequence&gt;
     *         &lt;element name="RefPayment" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="FinalPayment" type="{http://roskazna.ru/xsd/PaymentInfo}PaymentInfoType" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="SystemIdentifier" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;minLength value="0"/&gt;
     *                       &lt;maxLength value="36"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "refPayment"
    })
    public static class RefPayments {

        @XmlElement(name = "RefPayment", required = true)
        protected List<PutRefPaymentsRq.RefPayments.RefPayment> refPayment;

        /**
         * Gets the value of the refPayment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the refPayment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRefPayment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PutRefPaymentsRq.RefPayments.RefPayment }
         * 
         * 
         */
        public List<PutRefPaymentsRq.RefPayments.RefPayment> getRefPayment() {
            if (refPayment == null) {
                refPayment = new ArrayList<PutRefPaymentsRq.RefPayments.RefPayment>();
            }
            return this.refPayment;
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
         *       &lt;sequence&gt;
         *         &lt;element name="FinalPayment" type="{http://roskazna.ru/xsd/PaymentInfo}PaymentInfoType" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="SystemIdentifier" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;minLength value="0"/&gt;
         *             &lt;maxLength value="36"/&gt;
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
        @XmlType(name = "", propOrder = {
            "finalPayment"
        })
        public static class RefPayment {

            @XmlElement(name = "FinalPayment")
            protected PaymentInfoType finalPayment;
            @XmlAttribute(name = "SystemIdentifier", required = true)
            protected String systemIdentifier;

            /**
             * Gets the value of the finalPayment property.
             * 
             * @return
             *     possible object is
             *     {@link PaymentInfoType }
             *     
             */
            public PaymentInfoType getFinalPayment() {
                return finalPayment;
            }

            /**
             * Sets the value of the finalPayment property.
             * 
             * @param value
             *     allowed object is
             *     {@link PaymentInfoType }
             *     
             */
            public void setFinalPayment(PaymentInfoType value) {
                this.finalPayment = value;
            }

            /**
             * Gets the value of the systemIdentifier property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSystemIdentifier() {
                return systemIdentifier;
            }

            /**
             * Sets the value of the systemIdentifier property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSystemIdentifier(String value) {
                this.systemIdentifier = value;
            }

        }

    }

}
