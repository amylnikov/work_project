
package ru.roskazna.xsd.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Parameters_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Parameters_Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element ref="{http://roskazna.ru/xsd/Common}SimpleParameter"/&gt;
 *         &lt;element ref="{http://roskazna.ru/xsd/Common}ComplexParameter"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameters_Type", propOrder = {
    "simpleParameterOrComplexParameter"
})
public class ParametersType {

    @XmlElements({
        @XmlElement(name = "SimpleParameter", namespace = "http://roskazna.ru/xsd/Common", type = SimpleParameterType.class),
        @XmlElement(name = "ComplexParameter", namespace = "http://roskazna.ru/xsd/Common", type = ComplexParameterType.class)
    })
    protected List<ParameterType> simpleParameterOrComplexParameter;

    /**
     * Gets the value of the simpleParameterOrComplexParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simpleParameterOrComplexParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimpleParameterOrComplexParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleParameterType }
     * {@link ComplexParameterType }
     * 
     * 
     */
    public List<ParameterType> getSimpleParameterOrComplexParameter() {
        if (simpleParameterOrComplexParameter == null) {
            simpleParameterOrComplexParameter = new ArrayList<ParameterType>();
        }
        return this.simpleParameterOrComplexParameter;
    }

}
