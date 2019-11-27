
package com.triasoft.dev.schemas.eis.eregistry.pppr._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип Описание российского или иностранного юридического лица
 * 
 * <p>Java class for OrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="RussianOrganization" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}RussianOrganizationType"/&gt;
 *         &lt;element name="ForeignOrganization" type="{http://dev.triasoft.com/schemas/eis/eregistry/pppr/2.0}ForeignOrganizationType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationType", propOrder = {
    "russianOrganization",
    "foreignOrganization"
})
public class OrganizationType {

    @XmlElement(name = "RussianOrganization")
    protected RussianOrganizationType russianOrganization;
    @XmlElement(name = "ForeignOrganization")
    protected ForeignOrganizationType foreignOrganization;

    /**
     * Gets the value of the russianOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link RussianOrganizationType }
     *     
     */
    public RussianOrganizationType getRussianOrganization() {
        return russianOrganization;
    }

    /**
     * Sets the value of the russianOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RussianOrganizationType }
     *     
     */
    public void setRussianOrganization(RussianOrganizationType value) {
        this.russianOrganization = value;
    }

    /**
     * Gets the value of the foreignOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link ForeignOrganizationType }
     *     
     */
    public ForeignOrganizationType getForeignOrganization() {
        return foreignOrganization;
    }

    /**
     * Sets the value of the foreignOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForeignOrganizationType }
     *     
     */
    public void setForeignOrganization(ForeignOrganizationType value) {
        this.foreignOrganization = value;
    }

}
