
package ru.roskazna.xsd.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ��� ��� ������������� �����������
 * 
 * <p>Java class for PayerIdentification_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayerIdentification_Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://roskazna.ru/xsd/Common}SimpleParameter"/&gt;
 *           &lt;element ref="{http://roskazna.ru/xsd/Common}ComplexParameter"/&gt;
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
@XmlType(name = "PayerIdentification_Type", propOrder = {
    "serviceCode",
    "simpleParameter",
    "complexParameter"
})
public class PayerIdentificationType {

    @XmlElement(name = "ServiceCode", required = true)
    protected String serviceCode;
    @XmlElement(name = "SimpleParameter", namespace = "http://roskazna.ru/xsd/Common")
    protected SimpleParameterType simpleParameter;
    @XmlElement(name = "ComplexParameter", namespace = "http://roskazna.ru/xsd/Common")
    protected ComplexParameterType complexParameter;

    /**
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the simpleParameter property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleParameterType }
     *     
     */
    public SimpleParameterType getSimpleParameter() {
        return simpleParameter;
    }

    /**
     * Sets the value of the simpleParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleParameterType }
     *     
     */
    public void setSimpleParameter(SimpleParameterType value) {
        this.simpleParameter = value;
    }

    /**
     * Gets the value of the complexParameter property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexParameterType }
     *     
     */
    public ComplexParameterType getComplexParameter() {
        return complexParameter;
    }

    /**
     * Sets the value of the complexParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexParameterType }
     *     
     */
    public void setComplexParameter(ComplexParameterType value) {
        this.complexParameter = value;
    }

}
