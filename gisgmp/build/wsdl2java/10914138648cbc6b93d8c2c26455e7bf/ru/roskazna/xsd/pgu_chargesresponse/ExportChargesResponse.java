
package ru.roskazna.xsd.pgu_chargesresponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3._2000._09.xmldsig_.SignatureType;
import ru.roskazna.xsd.responsetemplate.ResponseTemplate;


/**
 * <p>Java class for ExportChargesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportChargesResponse"&gt;
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
 *                             &lt;element name="ChargeData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                             &lt;element name="ChargeSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
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
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
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
@XmlType(name = "ExportChargesResponse", propOrder = {
    "charges",
    "signature"
})
public class ExportChargesResponse
    extends ResponseTemplate
{

    @XmlElement(name = "Charges")
    protected ExportChargesResponse.Charges charges;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;

    /**
     * Gets the value of the charges property.
     * 
     * @return
     *     possible object is
     *     {@link ExportChargesResponse.Charges }
     *     
     */
    public ExportChargesResponse.Charges getCharges() {
        return charges;
    }

    /**
     * Sets the value of the charges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportChargesResponse.Charges }
     *     
     */
    public void setCharges(ExportChargesResponse.Charges value) {
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
     *                   &lt;element name="ChargeData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                   &lt;element name="ChargeSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
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
     *                 &lt;/sequence&gt;
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
        "chargeInfo"
    })
    public static class Charges {

        @XmlElement(name = "ChargeInfo", required = true)
        protected List<ExportChargesResponse.Charges.ChargeInfo> chargeInfo;

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
         * {@link ExportChargesResponse.Charges.ChargeInfo }
         * 
         * 
         */
        public List<ExportChargesResponse.Charges.ChargeInfo> getChargeInfo() {
            if (chargeInfo == null) {
                chargeInfo = new ArrayList<ExportChargesResponse.Charges.ChargeInfo>();
            }
            return this.chargeInfo;
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
         *         &lt;element name="ChargeData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *         &lt;element name="ChargeSignature" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
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
            "amountToPay",
            "quittanceWithPaymentStatus",
            "quittanceWithIncomeStatus",
            "isRevoked"
        })
        public static class ChargeInfo {

            @XmlElement(name = "ChargeData", required = true)
            protected byte[] chargeData;
            @XmlElement(name = "ChargeSignature")
            protected byte[] chargeSignature;
            @XmlElement(name = "AmountToPay")
            protected long amountToPay;
            @XmlElement(name = "QuittanceWithPaymentStatus")
            protected String quittanceWithPaymentStatus;
            @XmlElement(name = "QuittanceWithIncomeStatus")
            protected String quittanceWithIncomeStatus;
            @XmlElement(name = "IsRevoked")
            protected ExportChargesResponse.Charges.ChargeInfo.IsRevoked isRevoked;

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
             *     {@link ExportChargesResponse.Charges.ChargeInfo.IsRevoked }
             *     
             */
            public ExportChargesResponse.Charges.ChargeInfo.IsRevoked getIsRevoked() {
                return isRevoked;
            }

            /**
             * Sets the value of the isRevoked property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportChargesResponse.Charges.ChargeInfo.IsRevoked }
             *     
             */
            public void setIsRevoked(ExportChargesResponse.Charges.ChargeInfo.IsRevoked value) {
                this.isRevoked = value;
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
