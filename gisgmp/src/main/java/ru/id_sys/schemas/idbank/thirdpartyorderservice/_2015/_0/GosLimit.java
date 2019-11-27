
package ru.id_sys.schemas.idbank.thirdpartyorderservice._2015._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ������ �������
 * 
 * <p>Java class for GosLimit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GosLimit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="litmit" type="{http://www.id-sys.ru/schemas/idbank/ThirdPartyOrderService/2015/0.01/}LimitStats"/&gt;
 *         &lt;element name="stat" type="{http://www.id-sys.ru/schemas/idbank/ThirdPartyOrderService/2015/0.01/}LimitStats"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GosLimit", propOrder = {
    "litmit",
    "stat"
})
public class GosLimit {

    @XmlElement(required = true)
    protected LimitStats litmit;
    @XmlElement(required = true)
    protected LimitStats stat;

    /**
     * Gets the value of the litmit property.
     * 
     * @return
     *     possible object is
     *     {@link LimitStats }
     *     
     */
    public LimitStats getLitmit() {
        return litmit;
    }

    /**
     * Sets the value of the litmit property.
     * 
     * @param value
     *     allowed object is
     *     {@link LimitStats }
     *     
     */
    public void setLitmit(LimitStats value) {
        this.litmit = value;
    }

    /**
     * Gets the value of the stat property.
     * 
     * @return
     *     possible object is
     *     {@link LimitStats }
     *     
     */
    public LimitStats getStat() {
        return stat;
    }

    /**
     * Sets the value of the stat property.
     * 
     * @param value
     *     allowed object is
     *     {@link LimitStats }
     *     
     */
    public void setStat(LimitStats value) {
        this.stat = value;
    }

}
