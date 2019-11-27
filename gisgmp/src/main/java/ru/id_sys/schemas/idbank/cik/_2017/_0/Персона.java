
package ru.id_sys.schemas.idbank.cik._2017._0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ������� complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="�������"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="��������" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="����"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="���" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="��������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="��������"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�����" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�����" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="�����"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="������������" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="�����������"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="���" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="���������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="������"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�����" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
 *                           &lt;attribute name="���������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
 *                           &lt;attribute name="���������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
 *                           &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *                           &lt;attribute name="�����������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="�����" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="����"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *                           &lt;attribute name="�����������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="���������"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="��������" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="������"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *                           &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="������������"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="��������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="��" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u041f\u0435\u0440\u0441\u043e\u043d\u0430", propOrder = {
    "\u043f\u0435\u0440\u0441\u0418\u043d\u0444\u043e",
    "\u0446\u0435\u043d\u043d\u044b\u0435\u0411\u0443\u043c\u0430\u0433\u0438",
    "\u0441\u0447\u0435\u0442\u0430",
    "\u0441\u043b\u0443\u0436\u0418\u043d\u0444\u043e"
})
public class ������� {

    @XmlElement(name = "\u041f\u0435\u0440\u0441\u0418\u043d\u0444\u043e")
    protected �������.�������� ��������;
    @XmlElement(name = "\u0426\u0435\u043d\u043d\u044b\u0435\u0411\u0443\u043c\u0430\u0433\u0438")
    protected List<�������.������������> ������������;
    @XmlElement(name = "\u0421\u0447\u0435\u0442\u0430")
    protected List<�������.�����> �����;
    @XmlElement(name = "\u0421\u043b\u0443\u0436\u0418\u043d\u0444\u043e")
    protected �������.�������� ��������;
    @XmlAttribute(name = "\u0418\u0434", required = true)
    protected String ��;

    /**
     * Gets the value of the �������� property.
     * 
     * @return
     *     possible object is
     *     {@link �������.�������� }
     *     
     */
    public �������.�������� get��������() {
        return ��������;
    }

    /**
     * Sets the value of the �������� property.
     * 
     * @param value
     *     allowed object is
     *     {@link �������.�������� }
     *     
     */
    public void set��������(�������.�������� value) {
        this.�������� = value;
    }

    /**
     * Gets the value of the ������������ property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ������������ property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get������������().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link �������.������������ }
     * 
     * 
     */
    public List<�������.������������> get������������() {
        if (������������ == null) {
            ������������ = new ArrayList<�������.������������>();
        }
        return this.������������;
    }

    /**
     * Gets the value of the ����� property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ����� property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get�����().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link �������.����� }
     * 
     * 
     */
    public List<�������.�����> get�����() {
        if (����� == null) {
            ����� = new ArrayList<�������.�����>();
        }
        return this.�����;
    }

    /**
     * Gets the value of the �������� property.
     * 
     * @return
     *     possible object is
     *     {@link �������.�������� }
     *     
     */
    public �������.�������� get��������() {
        return ��������;
    }

    /**
     * Sets the value of the �������� property.
     * 
     * @param value
     *     allowed object is
     *     {@link �������.�������� }
     *     
     */
    public void set��������(�������.�������� value) {
        this.�������� = value;
    }

    /**
     * Gets the value of the �� property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get��() {
        return ��;
    }

    /**
     * Sets the value of the �� property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set��(String value) {
        this.�� = value;
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
     *         &lt;element name="����"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="���" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="��������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="��������"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�����" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�����" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="�����"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
        "\u0444\u0438\u043e\u0434",
        "\u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442",
        "\u0430\u0434\u0440\u0435\u0441"
    })
    public static class �������� {

        @XmlElement(name = "\u0424\u0418\u041e\u0414", required = true)
        protected �������.��������.���� ����;
        @XmlElement(name = "\u0414\u043e\u043a\u0443\u043c\u0435\u043d\u0442", required = true)
        protected �������.��������.�������� ��������;
        @XmlElement(name = "\u0410\u0434\u0440\u0435\u0441", required = true)
        protected �������.��������.����� �����;

        /**
         * Gets the value of the ���� property.
         * 
         * @return
         *     possible object is
         *     {@link �������.��������.���� }
         *     
         */
        public �������.��������.���� get����() {
            return ����;
        }

        /**
         * Sets the value of the ���� property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.��������.���� }
         *     
         */
        public void set����(�������.��������.���� value) {
            this.���� = value;
        }

        /**
         * Gets the value of the �������� property.
         * 
         * @return
         *     possible object is
         *     {@link �������.��������.�������� }
         *     
         */
        public �������.��������.�������� get��������() {
            return ��������;
        }

        /**
         * Sets the value of the �������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.��������.�������� }
         *     
         */
        public void set��������(�������.��������.�������� value) {
            this.�������� = value;
        }

        /**
         * Gets the value of the ����� property.
         * 
         * @return
         *     possible object is
         *     {@link �������.��������.����� }
         *     
         */
        public �������.��������.����� get�����() {
            return �����;
        }

        /**
         * Sets the value of the ����� property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.��������.����� }
         *     
         */
        public void set�����(�������.��������.����� value) {
            this.����� = value;
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
         *       &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ����� {

            @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u044a\u0435\u043a\u0442\u0430", required = true)
            protected String �����������;
            @XmlAttribute(name = "\u041d\u0435\u043a\u043e\u043d\u0444\u0410\u0434\u0440\u0435\u0441", required = true)
            protected String �����������;
            @XmlAttribute(name = "\u041a\u043e\u043d\u0444\u0410\u0434\u0440\u0435\u0441", required = true)
            protected String ���������;
            @XmlAttribute(name = "\u041c\u0435\u0441\u0442\u043e\u0420\u043e\u0436\u0434\u0435\u043d\u0438\u044f", required = true)
            protected String �������������;

            /**
             * Gets the value of the ����������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����������() {
                return �����������;
            }

            /**
             * Sets the value of the ����������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����������(String value) {
                this.����������� = value;
            }

            /**
             * Gets the value of the ����������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����������() {
                return �����������;
            }

            /**
             * Sets the value of the ����������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����������(String value) {
                this.����������� = value;
            }

            /**
             * Gets the value of the ��������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���������() {
                return ���������;
            }

            /**
             * Sets the value of the ��������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���������(String value) {
                this.��������� = value;
            }

            /**
             * Gets the value of the ������������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�������������() {
                return �������������;
            }

            /**
             * Sets the value of the ������������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�������������(String value) {
                this.������������� = value;
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
         *       &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�����" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�����" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class �������� {

            @XmlAttribute(name = "\u041a\u043e\u0434\u0412\u0438\u0434\u0414\u043e\u043a", required = true)
            protected String ���������;
            @XmlAttribute(name = "\u0421\u0435\u0440\u0438\u044f", required = true)
            protected String �����;
            @XmlAttribute(name = "\u041d\u043e\u043c\u0435\u0440", required = true)
            protected String �����;

            /**
             * Gets the value of the ��������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���������() {
                return ���������;
            }

            /**
             * Sets the value of the ��������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���������(String value) {
                this.��������� = value;
            }

            /**
             * Gets the value of the ����� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����() {
                return �����;
            }

            /**
             * Sets the value of the ����� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����(String value) {
                this.����� = value;
            }

            /**
             * Gets the value of the ����� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����() {
                return �����;
            }

            /**
             * Sets the value of the ����� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����(String value) {
                this.����� = value;
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
         *       &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="���" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="��������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ���� {

            @XmlAttribute(name = "\u0424\u0430\u043c\u0438\u043b\u0438\u044f", required = true)
            protected String �������;
            @XmlAttribute(name = "\u0418\u043c\u044f", required = true)
            protected String ���;
            @XmlAttribute(name = "\u041e\u0442\u0447\u0435\u0441\u0442\u0432\u043e", required = true)
            protected String ��������;
            @XmlAttribute(name = "\u0414\u0430\u0442\u0430\u0420\u043e\u0436\u0434")
            protected String ��������;

            /**
             * Gets the value of the ������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�������() {
                return �������;
            }

            /**
             * Sets the value of the ������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�������(String value) {
                this.������� = value;
            }

            /**
             * Gets the value of the ��� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���() {
                return ���;
            }

            /**
             * Sets the value of the ��� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���(String value) {
                this.��� = value;
            }

            /**
             * Gets the value of the �������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get��������() {
                return ��������;
            }

            /**
             * Sets the value of the �������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set��������(String value) {
                this.�������� = value;
            }

            /**
             * Gets the value of the �������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get��������() {
                return ��������;
            }

            /**
             * Sets the value of the �������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set��������(String value) {
                this.�������� = value;
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
     *         &lt;element name="������"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
     *                 &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="������������"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="��������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "\u0438\u0434\u0418\u043d\u0444\u043e",
        "\u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435"
    })
    public static class �������� {

        @XmlElement(name = "\u0418\u0414\u0418\u043d\u0444\u043e", required = true)
        protected �������.��������.������ ������;
        @XmlElement(name = "\u041d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435", required = true)
        protected �������.��������.������������ ������������;
        @XmlAttribute(name = "\u0412\u0420\u041d\u041a\u0430\u043d\u0434", required = true)
        protected BigInteger �������;

        /**
         * Gets the value of the ������ property.
         * 
         * @return
         *     possible object is
         *     {@link �������.��������.������ }
         *     
         */
        public �������.��������.������ get������() {
            return ������;
        }

        /**
         * Sets the value of the ������ property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.��������.������ }
         *     
         */
        public void set������(�������.��������.������ value) {
            this.������ = value;
        }

        /**
         * Gets the value of the ������������ property.
         * 
         * @return
         *     possible object is
         *     {@link �������.��������.������������ }
         *     
         */
        public �������.��������.������������ get������������() {
            return ������������;
        }

        /**
         * Sets the value of the ������������ property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.��������.������������ }
         *     
         */
        public void set������������(�������.��������.������������ value) {
            this.������������ = value;
        }

        /**
         * Gets the value of the ������� property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger get�������() {
            return �������;
        }

        /**
         * Sets the value of the ������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void set�������(BigInteger value) {
            this.������� = value;
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
         *       &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
         *       &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ������ {

            @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u044a\u0435\u043a\u0442\u0430", required = true)
            protected String �����������;
            @XmlAttribute(name = "\u041a\u0430\u043c\u043f\u0430\u043d\u0438\u044f", required = true)
            protected BigInteger ��������;
            @XmlAttribute(name = "\u0421\u0438\u0441\u0442\u0435\u043c\u0430", required = true)
            @XmlSchemaType(name = "unsignedByte")
            protected short �������;

            /**
             * Gets the value of the ����������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����������() {
                return �����������;
            }

            /**
             * Sets the value of the ����������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����������(String value) {
                this.����������� = value;
            }

            /**
             * Gets the value of the �������� property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger get��������() {
                return ��������;
            }

            /**
             * Sets the value of the �������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void set��������(BigInteger value) {
                this.�������� = value;
            }

            /**
             * Gets the value of the ������� property.
             * 
             */
            public short get�������() {
                return �������;
            }

            /**
             * Sets the value of the ������� property.
             * 
             */
            public void set�������(short value) {
                this.������� = value;
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
         *       &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="��������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ������������ {

            @XmlAttribute(name = "\u0412\u044b\u0431\u043e\u0440\u044b", required = true)
            protected String ������;
            @XmlAttribute(name = "\u0421\u0443\u0431\u044a\u0435\u043a\u0442", required = true)
            protected String �������;
            @XmlAttribute(name = "\u0414\u0430\u0442\u0430\u0421\u0432\u0435\u0434", required = true)
            protected String ��������;

            /**
             * Gets the value of the ������ property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get������() {
                return ������;
            }

            /**
             * Sets the value of the ������ property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set������(String value) {
                this.������ = value;
            }

            /**
             * Gets the value of the ������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�������() {
                return �������;
            }

            /**
             * Sets the value of the ������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�������(String value) {
                this.������� = value;
            }

            /**
             * Gets the value of the �������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get��������() {
                return ��������;
            }

            /**
             * Sets the value of the �������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set��������(String value) {
                this.�������� = value;
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
     *         &lt;element name="����"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
     *                 &lt;attribute name="�����������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="���������"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "\u0441\u0447\u0435\u0442",
        "\u043a\u0440\u0435\u0434\u0438\u0442\u041e\u0440\u0433"
    })
    public static class ����� {

        @XmlElement(name = "\u0421\u0447\u0435\u0442", required = true)
        protected �������.�����.���� ����;
        @XmlElement(name = "\u041a\u0440\u0435\u0434\u0438\u0442\u041e\u0440\u0433", required = true)
        protected �������.�����.��������� ���������;
        @XmlAttribute(name = "\u0418\u0434\u0421\u0447\u0435\u0442\u0430", required = true)
        protected String �������;

        /**
         * Gets the value of the ���� property.
         * 
         * @return
         *     possible object is
         *     {@link �������.�����.���� }
         *     
         */
        public �������.�����.���� get����() {
            return ����;
        }

        /**
         * Sets the value of the ���� property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.�����.���� }
         *     
         */
        public void set����(�������.�����.���� value) {
            this.���� = value;
        }

        /**
         * Gets the value of the ��������� property.
         * 
         * @return
         *     possible object is
         *     {@link �������.�����.��������� }
         *     
         */
        public �������.�����.��������� get���������() {
            return ���������;
        }

        /**
         * Sets the value of the ��������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.�����.��������� }
         *     
         */
        public void set���������(�������.�����.��������� value) {
            this.��������� = value;
        }

        /**
         * Gets the value of the ������� property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get�������() {
            return �������;
        }

        /**
         * Sets the value of the ������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set�������(String value) {
            this.������� = value;
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
         *       &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ��������� {

            @XmlAttribute(name = "\u041d\u0430\u0438\u043c\u041a\u0440\u0435\u0434\u0438\u0442", required = true)
            protected String ����������;
            @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u041a\u0440\u0435\u0434", required = true)
            protected String ����������;
            @XmlAttribute(name = "\u041d\u0435\u043a\u043e\u043d\u0444\u0410\u0434\u0440\u041a\u0440\u0435\u0434", required = true)
            protected String �������������;
            @XmlAttribute(name = "\u041a\u043e\u043d\u0444\u0410\u0434\u0440\u041a\u0440\u0435\u0434", required = true)
            protected String �����������;

            /**
             * Gets the value of the ���������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get����������() {
                return ����������;
            }

            /**
             * Sets the value of the ���������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set����������(String value) {
                this.���������� = value;
            }

            /**
             * Gets the value of the ���������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get����������() {
                return ����������;
            }

            /**
             * Sets the value of the ���������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set����������(String value) {
                this.���������� = value;
            }

            /**
             * Gets the value of the ������������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�������������() {
                return �������������;
            }

            /**
             * Sets the value of the ������������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�������������(String value) {
                this.������������� = value;
            }

            /**
             * Gets the value of the ����������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����������() {
                return �����������;
            }

            /**
             * Sets the value of the ����������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����������(String value) {
                this.����������� = value;
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
         *       &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�������" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
         *       &lt;attribute name="�����������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ���� {

            @XmlAttribute(name = "\u0412\u0438\u0434\u0421\u0447\u0435\u0442\u0430", required = true)
            protected String ��������;
            @XmlAttribute(name = "\u041d\u043e\u043c\u0435\u0440\u0421\u0447\u0435\u0442\u0430", required = true)
            protected String ����������;
            @XmlAttribute(name = "\u041e\u0441\u0442\u0430\u0442\u043e\u043a", required = true)
            protected BigDecimal �������;
            @XmlAttribute(name = "\u0414\u0430\u0442\u0430\u0421\u0432\u0435\u0434\u041e\u0442\u0432")
            protected String �����������;

            /**
             * Gets the value of the �������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get��������() {
                return ��������;
            }

            /**
             * Sets the value of the �������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set��������(String value) {
                this.�������� = value;
            }

            /**
             * Gets the value of the ���������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get����������() {
                return ����������;
            }

            /**
             * Sets the value of the ���������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set����������(String value) {
                this.���������� = value;
            }

            /**
             * Gets the value of the ������� property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal get�������() {
                return �������;
            }

            /**
             * Sets the value of the ������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void set�������(BigDecimal value) {
                this.������� = value;
            }

            /**
             * Gets the value of the ����������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����������() {
                return �����������;
            }

            /**
             * Sets the value of the ����������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����������(String value) {
                this.����������� = value;
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
     *         &lt;element name="�����������"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="���" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="���������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="������"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="�����" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
     *                 &lt;attribute name="���������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
     *                 &lt;attribute name="���������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
     *                 &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
     *                 &lt;attribute name="�����������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "\u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044f",
        "\u0431\u0443\u043c\u0430\u0433\u0430"
    })
    public static class ������������ {

        @XmlElement(name = "\u041e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044f", required = true)
        protected �������.������������.����������� �����������;
        @XmlElement(name = "\u0411\u0443\u043c\u0430\u0433\u0430", required = true)
        protected �������.������������.������ ������;
        @XmlAttribute(name = "\u0418\u0434\u0411\u0443\u043c\u0430\u0433\u0438", required = true)
        protected String ��������;

        /**
         * Gets the value of the ����������� property.
         * 
         * @return
         *     possible object is
         *     {@link �������.������������.����������� }
         *     
         */
        public �������.������������.����������� get�����������() {
            return �����������;
        }

        /**
         * Sets the value of the ����������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.������������.����������� }
         *     
         */
        public void set�����������(�������.������������.����������� value) {
            this.����������� = value;
        }

        /**
         * Gets the value of the ������ property.
         * 
         * @return
         *     possible object is
         *     {@link �������.������������.������ }
         *     
         */
        public �������.������������.������ get������() {
            return ������;
        }

        /**
         * Sets the value of the ������ property.
         * 
         * @param value
         *     allowed object is
         *     {@link �������.������������.������ }
         *     
         */
        public void set������(�������.������������.������ value) {
            this.������ = value;
        }

        /**
         * Gets the value of the �������� property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get��������() {
            return ��������;
        }

        /**
         * Sets the value of the �������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set��������(String value) {
            this.�������� = value;
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
         *       &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�����" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
         *       &lt;attribute name="���������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
         *       &lt;attribute name="���������" use="required" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Number" /&gt;
         *       &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
         *       &lt;attribute name="�����������" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}�������" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ������ {

            @XmlAttribute(name = "\u041a\u043e\u0434\u0412\u0438\u0434\u0411\u0443\u043c", required = true)
            protected String ���������;
            @XmlAttribute(name = "\u041a\u043e\u0434\u041a\u0430\u0442\u0435\u0433", required = true)
            protected String ��������;
            @XmlAttribute(name = "\u041a\u043e\u043b\u0432\u043e", required = true)
            protected String �����;
            @XmlAttribute(name = "\u041a\u043e\u043b\u0432\u043e\u0427\u0438\u0441\u043b", required = true)
            protected String ���������;
            @XmlAttribute(name = "\u041a\u043e\u043b\u0432\u043e\u0417\u043d\u0430\u043c", required = true)
            protected String ���������;
            @XmlAttribute(name = "\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c", required = true)
            protected BigDecimal ���������;
            @XmlAttribute(name = "\u0414\u0430\u0442\u0430\u0421\u0432\u0435\u0434\u041e\u0442\u0432")
            protected String �����������;

            /**
             * Gets the value of the ��������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���������() {
                return ���������;
            }

            /**
             * Sets the value of the ��������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���������(String value) {
                this.��������� = value;
            }

            /**
             * Gets the value of the �������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get��������() {
                return ��������;
            }

            /**
             * Sets the value of the �������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set��������(String value) {
                this.�������� = value;
            }

            /**
             * Gets the value of the ����� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����() {
                return �����;
            }

            /**
             * Sets the value of the ����� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����(String value) {
                this.����� = value;
            }

            /**
             * Gets the value of the ��������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���������() {
                return ���������;
            }

            /**
             * Sets the value of the ��������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���������(String value) {
                this.��������� = value;
            }

            /**
             * Gets the value of the ��������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���������() {
                return ���������;
            }

            /**
             * Sets the value of the ��������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���������(String value) {
                this.��������� = value;
            }

            /**
             * Gets the value of the ��������� property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal get���������() {
                return ���������;
            }

            /**
             * Sets the value of the ��������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void set���������(BigDecimal value) {
                this.��������� = value;
            }

            /**
             * Gets the value of the ����������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����������() {
                return �����������;
            }

            /**
             * Sets the value of the ����������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����������(String value) {
                this.����������� = value;
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
         *       &lt;attribute name="��������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="���" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="�������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="���������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="���������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="������������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="����������" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ����������� {

            @XmlAttribute(name = "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435", required = true)
            protected String ��������;
            @XmlAttribute(name = "\u0418\u041d\u041d\u041e\u0440\u0433", required = true)
            protected String ������;
            @XmlAttribute(name = "\u041f\u0418\u0424", required = true)
            protected String ���;
            @XmlAttribute(name = "\u0421\u0442\u0430\u0442\u0443\u0441", required = true)
            protected String ������;
            @XmlAttribute(name = "\u0414\u043e\u043b\u044f\u041f\u0440\u043e\u0446\u0435\u043d\u0442", required = true)
            protected String �����������;
            @XmlAttribute(name = "\u0414\u043e\u043b\u044f\u0427\u0438\u0441\u043b\u0438\u0442\u0435\u043b\u044c", required = true)
            protected String �������������;
            @XmlAttribute(name = "\u0414\u043e\u043b\u044f\u0417\u043d\u0430\u043c\u0435\u043d\u0430\u0442\u0435\u043b\u044c", required = true)
            protected String ���������������;
            @XmlAttribute(name = "\u041a\u043e\u0434\u0421\u0443\u0431\u041e\u0440\u0433", required = true)
            protected String ���������;
            @XmlAttribute(name = "\u041d\u0435\u043a\u043e\u043d\u0444\u0410\u0434\u0440\u041e\u0440\u0433", required = true)
            protected String ������������;
            @XmlAttribute(name = "\u041a\u043e\u043d\u0444\u0410\u0434\u0440\u041e\u0440\u0433", required = true)
            protected String ����������;

            /**
             * Gets the value of the �������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get��������() {
                return ��������;
            }

            /**
             * Sets the value of the �������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set��������(String value) {
                this.�������� = value;
            }

            /**
             * Gets the value of the ������ property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get������() {
                return ������;
            }

            /**
             * Sets the value of the ������ property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set������(String value) {
                this.������ = value;
            }

            /**
             * Gets the value of the ��� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���() {
                return ���;
            }

            /**
             * Sets the value of the ��� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���(String value) {
                this.��� = value;
            }

            /**
             * Gets the value of the ������ property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get������() {
                return ������;
            }

            /**
             * Sets the value of the ������ property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set������(String value) {
                this.������ = value;
            }

            /**
             * Gets the value of the ����������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�����������() {
                return �����������;
            }

            /**
             * Sets the value of the ����������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�����������(String value) {
                this.����������� = value;
            }

            /**
             * Gets the value of the ������������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get�������������() {
                return �������������;
            }

            /**
             * Sets the value of the ������������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set�������������(String value) {
                this.������������� = value;
            }

            /**
             * Gets the value of the ��������������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���������������() {
                return ���������������;
            }

            /**
             * Sets the value of the ��������������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���������������(String value) {
                this.��������������� = value;
            }

            /**
             * Gets the value of the ��������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get���������() {
                return ���������;
            }

            /**
             * Sets the value of the ��������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set���������(String value) {
                this.��������� = value;
            }

            /**
             * Gets the value of the ������������ property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get������������() {
                return ������������;
            }

            /**
             * Sets the value of the ������������ property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set������������(String value) {
                this.������������ = value;
            }

            /**
             * Gets the value of the ���������� property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String get����������() {
                return ����������;
            }

            /**
             * Sets the value of the ���������� property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void set����������(String value) {
                this.���������� = value;
            }

        }

    }

}
