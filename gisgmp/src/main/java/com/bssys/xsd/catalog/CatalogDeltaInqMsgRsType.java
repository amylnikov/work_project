
package com.bssys.xsd.catalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип, описывающий изменения в Каталоге услуг ОПУ для авансовых платежей
 * 
 * <p>Java class for CatalogDeltaInqMsgRs_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CatalogDeltaInqMsgRs_Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Changes" type="{http://www.bssys.com/xsd/Catalog}ServiceCatalog_Type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogDeltaInqMsgRs_Type", propOrder = {
    "changes"
})
public class CatalogDeltaInqMsgRsType {

    @XmlElement(name = "Changes", required = true, nillable = true)
    protected ServiceCatalogType changes;

    /**
     * Gets the value of the changes property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCatalogType }
     *     
     */
    public ServiceCatalogType getChanges() {
        return changes;
    }

    /**
     * Sets the value of the changes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCatalogType }
     *     
     */
    public void setChanges(ServiceCatalogType value) {
        this.changes = value;
    }

}
