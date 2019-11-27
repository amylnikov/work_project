
package ru.id_sys.schemas.idbank.unifo._2012._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3._2000._09.xmldsig_.SignatureType;
import ru.roskazna.xsd.charge.ChargeType;
import ru.roskazna.xsd.responsetemplate.ResponseTemplate;


/**
 * <p>Java class for ExportChargesResponseEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportChargesResponseEx"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://roskazna.ru/xsd/ResponseTemplate}ResponseTemplate"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Charges" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ChargeInfo" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element name="ChargeData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                 &lt;element name="ChargeSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *                               &lt;/sequence&gt;
 *                               &lt;element name="Charge" type="{http://roskazna.ru/xsd/Charge}ChargeType"/&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="AmountToPay" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *                             &lt;element name="QuittanceWithPaymentStatus" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="1"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="QuittanceWithIncomeStatus" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;length value="1"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IsRevoked" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
 *                                     &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="srcSystemID" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="30"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *                             &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="hasMore" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *                 &lt;attribute name="needReRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "ExportChargesResponseEx", propOrder = {
    "charges",
    "signature"
})
public class ExportChargesResponseEx
    extends ResponseTemplate
{

    @XmlElement(name = "Charges")
    protected ExportChargesResponseEx.Charges charges;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;

    /**
     * Gets the value of the charges property.
     * 
     * @return
     *     possible object is
     *     {@link ExportChargesResponseEx.Charges }
     *     
     */
    public ExportChargesResponseEx.Charges getCharges() {
        return charges;
    }

    /**
     * Sets the value of the charges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportChargesResponseEx.Charges }
     *     
     */
    public void setCharges(ExportChargesResponseEx.Charges value) {
        this.charges = value;
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
     *         &lt;element name="ChargeInfo" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element name="ChargeData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                       &lt;element name="ChargeSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
     *                     &lt;/sequence&gt;
     *                     &lt;element name="Charge" type="{http://roskazna.ru/xsd/Charge}ChargeType"/&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="AmountToPay" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
     *                   &lt;element name="QuittanceWithPaymentStatus" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="1"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="QuittanceWithIncomeStatus" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;length value="1"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IsRevoked" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
     *                           &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="srcSystemID" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="30"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
     *                   &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="hasMore" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="needReRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "chargeInfo"
    })
    public static class Charges {

        @XmlElement(name = "ChargeInfo", required = true)
        protected List<ExportChargesResponseEx.Charges.ChargeInfo> chargeInfo;
        @XmlAttribute(name = "hasMore")
        protected Boolean hasMore;
        @XmlAttribute(name = "needReRequest")
        protected Boolean needReRequest;

        /**
         * Gets the value of the chargeInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the chargeInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChargeInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportChargesResponseEx.Charges.ChargeInfo }
         * 
         * 
         */
        public List<ExportChargesResponseEx.Charges.ChargeInfo> getChargeInfo() {
            if (chargeInfo == null) {
                chargeInfo = new ArrayList<ExportChargesResponseEx.Charges.ChargeInfo>();
            }
            return this.chargeInfo;
        }

        /**
         * Gets the value of the hasMore property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isHasMore() {
            return hasMore;
        }

        /**
         * Sets the value of the hasMore property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setHasMore(Boolean value) {
            this.hasMore = value;
        }

        /**
         * Gets the value of the needReRequest property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isNeedReRequest() {
            if (needReRequest == null) {
                return false;
            } else {
                return needReRequest;
            }
        }

        /**
         * Sets the value of the needReRequest property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNeedReRequest(Boolean value) {
            this.needReRequest = value;
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
         *         &lt;choice&gt;
         *           &lt;sequence&gt;
         *             &lt;element name="ChargeData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *             &lt;element name="ChargeSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
         *           &lt;/sequence&gt;
         *           &lt;element name="Charge" type="{http://roskazna.ru/xsd/Charge}ChargeType"/&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="AmountToPay" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
         *         &lt;element name="QuittanceWithPaymentStatus" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="1"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="QuittanceWithIncomeStatus" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;length value="1"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IsRevoked" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
         *                 &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
         *               &lt;/extension&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="srcSystemID" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="30"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
         *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
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
            "chargeData",
            "chargeSignature",
            "charge",
            "amountToPay",
            "quittanceWithPaymentStatus",
            "quittanceWithIncomeStatus",
            "isRevoked",
            "srcSystemID",
            "year",
            "month"
        })
        public static class ChargeInfo {

            @XmlElement(name = "ChargeData")
            protected byte[] chargeData;
            @XmlElement(name = "ChargeSignature")
            protected byte[] chargeSignature;
            @XmlElement(name = "Charge")
            protected ChargeType charge;
            @XmlElement(name = "AmountToPay")
            protected long amountToPay;
            @XmlElement(name = "QuittanceWithPaymentStatus")
            protected String quittanceWithPaymentStatus;
            @XmlElement(name = "QuittanceWithIncomeStatus")
            protected String quittanceWithIncomeStatus;
            @XmlElement(name = "IsRevoked")
            protected ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked isRevoked;
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String srcSystemID;
            @XmlElement(name = "Year")
            protected Short year;
            @XmlElement(name = "Month")
            protected Short month;

            /**
             * Gets the value of the chargeData property.
             * 
             * @return
             *     possible object is
             *     byte[]
             */
            public byte[] getChargeData() {
                return chargeData;
            }

            /**
             * Sets the value of the chargeData property.
             * 
             * @param value
             *     allowed object is
             *     byte[]
             */
            public void setChargeData(byte[] value) {
                this.chargeData = value;
            }

            /**
             * Gets the value of the chargeSignature property.
             * 
             * @return
             *     possible object is
             *     byte[]
             */
            public byte[] getChargeSignature() {
                return chargeSignature;
            }

            /**
             * Sets the value of the chargeSignature property.
             * 
             * @param value
             *     allowed object is
             *     byte[]
             */
            public void setChargeSignature(byte[] value) {
                this.chargeSignature = value;
            }

            /**
             * Gets the value of the charge property.
             * 
             * @return
             *     possible object is
             *     {@link ChargeType }
             *     
             */
            public ChargeType getCharge() {
                return charge;
            }

            /**
             * Sets the value of the charge property.
             * 
             * @param value
             *     allowed object is
             *     {@link ChargeType }
             *     
             */
            public void setCharge(ChargeType value) {
                this.charge = value;
            }

            /**
             * Gets the value of the amountToPay property.
             * 
             */
            public long getAmountToPay() {
                return amountToPay;
            }

            /**
             * Sets the value of the amountToPay property.
             * 
             */
            public void setAmountToPay(long value) {
                this.amountToPay = value;
            }

            /**
             * Gets the value of the quittanceWithPaymentStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuittanceWithPaymentStatus() {
                return quittanceWithPaymentStatus;
            }

            /**
             * Sets the value of the quittanceWithPaymentStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuittanceWithPaymentStatus(String value) {
                this.quittanceWithPaymentStatus = value;
            }

            /**
             * Gets the value of the quittanceWithIncomeStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuittanceWithIncomeStatus() {
                return quittanceWithIncomeStatus;
            }

            /**
             * Sets the value of the quittanceWithIncomeStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuittanceWithIncomeStatus(String value) {
                this.quittanceWithIncomeStatus = value;
            }

            /**
             * Gets the value of the isRevoked property.
             * 
             * @return
             *     possible object is
             *     {@link ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked }
             *     
             */
            public ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked getIsRevoked() {
                return isRevoked;
            }

            /**
             * Sets the value of the isRevoked property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked }
             *     
             */
            public void setIsRevoked(ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked value) {
                this.isRevoked = value;
            }

            /**
             * Gets the value of the srcSystemID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSrcSystemID() {
                return srcSystemID;
            }

            /**
             * Sets the value of the srcSystemID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSrcSystemID(String value) {
                this.srcSystemID = value;
            }

            /**
             * Gets the value of the year property.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getYear() {
                return year;
            }

            /**
             * Sets the value of the year property.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setYear(Short value) {
                this.year = value;
            }

            /**
             * Gets the value of the month property.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getMonth() {
                return month;
            }

            /**
             * Sets the value of the month property.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setMonth(Short value) {
                this.month = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;boolean"&gt;
             *       &lt;attribute name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
             *     &lt;/extension&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class IsRevoked {

                @XmlValue
                protected boolean value;
                @XmlAttribute(name = "date")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar date;

                /**
                 * Gets the value of the value property.
                 * 
                 */
                public boolean isValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 */
                public void setValue(boolean value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the date property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDate() {
                    return date;
                }

                /**
                 * Sets the value of the date property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDate(XMLGregorianCalendar value) {
                    this.date = value;
                }

            }

        }

    }

}
