
package com.triasoft.dev.schemas.eis.eregistry.pppr._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип Транспортное средство (контроль обязательности взаимозависимых полей схемой)
 * 
 * <p>Java class for VehiclePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehiclePropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="VIN" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}VehiclePropertyVINType"/&gt;
 *             &lt;element name="ChassisNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-25Type" minOccurs="0"/&gt;
 *             &lt;element name="BodyNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-20Type" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="PIN" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}VehiclePropertyPINType"/&gt;
 *             &lt;element name="ChassisNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-25Type" minOccurs="0"/&gt;
 *             &lt;element name="BodyNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-20Type" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="ChassisNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-25Type"/&gt;
 *             &lt;element name="BodyNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-20Type" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="BodyNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-20Type"/&gt;
 *             &lt;element name="ChassisNumber" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-25Type" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Description" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}String1-4000Type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiclePropertyType", propOrder = {
    "content"
})
public class VehiclePropertyType {

    @XmlElementRefs({
        @XmlElementRef(name = "VIN", namespace = "http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ChassisNumber", namespace = "http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BodyNumber", namespace = "http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PIN", namespace = "http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Description", namespace = "http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "ChassisNumber" is used by two different parts of a schema. See: 
     * line 285 of file:/c:/Рабочая%20папка/JavaTestingEnvironment/TestsProjects/id_bank_autotests/gisgmp/src/test/resources/wsdl/unifoWS/unifo_1_2.xsd
     * line 268 of file:/c:/Рабочая%20папка/JavaTestingEnvironment/TestsProjects/id_bank_autotests/gisgmp/src/test/resources/wsdl/unifoWS/unifo_1_2.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<String>>();
        }
        return this.content;
    }

}
