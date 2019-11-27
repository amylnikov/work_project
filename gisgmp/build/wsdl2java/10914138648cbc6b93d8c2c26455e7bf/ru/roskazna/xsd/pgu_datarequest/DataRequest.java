
package ru.roskazna.xsd.pgu_datarequest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3._2000._09.xmldsig_.SignatureType;
import ru.roskazna.xsd.common.EsiaUserInfoType;
import ru.roskazna.xsd.common.PayerIdentificationType;
import ru.roskazna.xsd.requesttemplate.RequestTemplate;


/**
 * <p>Java class for DataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://roskazna.ru/xsd/RequestTemplate}RequestTemplate"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EsiaUserInfo" type="{http://roskazna.ru/xsd/Common}EsiaUserInfoType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="SupplierBillIDs" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="SupplierBillID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Payers" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice maxOccurs="unbounded"&gt;
 *                     &lt;element name="PayerIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                     &lt;element ref="{http://roskazna.ru/xsd/Common}PayerIdentification"/&gt;
 *                     &lt;element name="IdentificationSet"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="PayerIdentifier" maxOccurs="unbounded"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                     &lt;minLength value="1"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                             &lt;attribute name="dateFrom" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *                             &lt;attribute name="dateTo" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="ApplicationIDs" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ApplicationID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataRequest", propOrder = {
    "esiaUserInfo",
    "supplierBillIDs",
    "payers",
    "applicationIDs",
    "signature"
})
public class DataRequest
    extends RequestTemplate
{

    @XmlElement(name = "EsiaUserInfo")
    protected EsiaUserInfoType esiaUserInfo;
    @XmlElement(name = "SupplierBillIDs")
    protected DataRequest.SupplierBillIDs supplierBillIDs;
    @XmlElement(name = "Payers")
    protected DataRequest.Payers payers;
    @XmlElement(name = "ApplicationIDs")
    protected DataRequest.ApplicationIDs applicationIDs;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;

    /**
     * Gets the value of the esiaUserInfo property.
     * 
     * @return
     *     possible object is
     *     {@link EsiaUserInfoType }
     *     
     */
    public EsiaUserInfoType getEsiaUserInfo() {
        return esiaUserInfo;
    }

    /**
     * Sets the value of the esiaUserInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsiaUserInfoType }
     *     
     */
    public void setEsiaUserInfo(EsiaUserInfoType value) {
        this.esiaUserInfo = value;
    }

    /**
     * Gets the value of the supplierBillIDs property.
     * 
     * @return
     *     possible object is
     *     {@link DataRequest.SupplierBillIDs }
     *     
     */
    public DataRequest.SupplierBillIDs getSupplierBillIDs() {
        return supplierBillIDs;
    }

    /**
     * Sets the value of the supplierBillIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRequest.SupplierBillIDs }
     *     
     */
    public void setSupplierBillIDs(DataRequest.SupplierBillIDs value) {
        this.supplierBillIDs = value;
    }

    /**
     * Gets the value of the payers property.
     * 
     * @return
     *     possible object is
     *     {@link DataRequest.Payers }
     *     
     */
    public DataRequest.Payers getPayers() {
        return payers;
    }

    /**
     * Sets the value of the payers property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRequest.Payers }
     *     
     */
    public void setPayers(DataRequest.Payers value) {
        this.payers = value;
    }

    /**
     * Gets the value of the applicationIDs property.
     * 
     * @return
     *     possible object is
     *     {@link DataRequest.ApplicationIDs }
     *     
     */
    public DataRequest.ApplicationIDs getApplicationIDs() {
        return applicationIDs;
    }

    /**
     * Sets the value of the applicationIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRequest.ApplicationIDs }
     *     
     */
    public void setApplicationIDs(DataRequest.ApplicationIDs value) {
        this.applicationIDs = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
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
     *         &lt;element name="ApplicationID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
        "applicationID"
    })
    public static class ApplicationIDs {

        @XmlElement(name = "ApplicationID", required = true)
        protected List<String> applicationID;

        /**
         * Gets the value of the applicationID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the applicationID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getApplicationID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getApplicationID() {
            if (applicationID == null) {
                applicationID = new ArrayList<String>();
            }
            return this.applicationID;
        }

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
     *       &lt;choice maxOccurs="unbounded"&gt;
     *         &lt;element name="PayerIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element ref="{http://roskazna.ru/xsd/Common}PayerIdentification"/&gt;
     *         &lt;element name="IdentificationSet"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PayerIdentifier" maxOccurs="unbounded"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="dateFrom" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
     *                 &lt;attribute name="dateTo" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "payerIdentifierOrPayerIdentificationOrIdentificationSet"
    })
    public static class Payers {

        @XmlElements({
            @XmlElement(name = "PayerIdentifier", type = String.class),
            @XmlElement(name = "PayerIdentification", namespace = "http://roskazna.ru/xsd/Common", type = PayerIdentificationType.class),
            @XmlElement(name = "IdentificationSet", type = DataRequest.Payers.IdentificationSet.class)
        })
        protected List<Object> payerIdentifierOrPayerIdentificationOrIdentificationSet;

        /**
         * Gets the value of the payerIdentifierOrPayerIdentificationOrIdentificationSet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the payerIdentifierOrPayerIdentificationOrIdentificationSet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPayerIdentifierOrPayerIdentificationOrIdentificationSet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link PayerIdentificationType }
         * {@link DataRequest.Payers.IdentificationSet }
         * 
         * 
         */
        public List<Object> getPayerIdentifierOrPayerIdentificationOrIdentificationSet() {
            if (payerIdentifierOrPayerIdentificationOrIdentificationSet == null) {
                payerIdentifierOrPayerIdentificationOrIdentificationSet = new ArrayList<Object>();
            }
            return this.payerIdentifierOrPayerIdentificationOrIdentificationSet;
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
         *         &lt;element name="PayerIdentifier" maxOccurs="unbounded"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="dateFrom" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
         *       &lt;attribute name="dateTo" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "payerIdentifier"
        })
        public static class IdentificationSet {

            @XmlElement(name = "PayerIdentifier", required = true)
            protected List<String> payerIdentifier;
            @XmlAttribute(name = "ID")
            protected String id;
            @XmlAttribute(name = "dateFrom")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dateFrom;
            @XmlAttribute(name = "dateTo")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dateTo;

            /**
             * Gets the value of the payerIdentifier property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the payerIdentifier property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPayerIdentifier().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getPayerIdentifier() {
                if (payerIdentifier == null) {
                    payerIdentifier = new ArrayList<String>();
                }
                return this.payerIdentifier;
            }

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getID() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setID(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the dateFrom property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDateFrom() {
                return dateFrom;
            }

            /**
             * Sets the value of the dateFrom property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDateFrom(XMLGregorianCalendar value) {
                this.dateFrom = value;
            }

            /**
             * Gets the value of the dateTo property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDateTo() {
                return dateTo;
            }

            /**
             * Sets the value of the dateTo property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDateTo(XMLGregorianCalendar value) {
                this.dateTo = value;
            }

        }

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
     *         &lt;element name="SupplierBillID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
        "supplierBillID"
    })
    public static class SupplierBillIDs {

        @XmlElement(name = "SupplierBillID", required = true)
        protected List<String> supplierBillID;

        /**
         * Gets the value of the supplierBillID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the supplierBillID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSupplierBillID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSupplierBillID() {
            if (supplierBillID == null) {
                supplierBillID = new ArrayList<String>();
            }
            return this.supplierBillID;
        }

    }

}
