
package com.bssys.xsd.catalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.bssys.com/xsd/Catalog}ServiceCatalog" minOccurs="0"/&gt;
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
    "serviceCatalog"
})
@XmlRootElement(name = "CatalogFullInqMsgRs")
public class CatalogFullInqMsgRs {

    @XmlElement(name = "ServiceCatalog")
    protected ServiceCatalogType serviceCatalog;

    /**
     * Gets the value of the serviceCatalog property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCatalogType }
     *     
     */
    public ServiceCatalogType getServiceCatalog() {
        return serviceCatalog;
    }

    /**
     * Sets the value of the serviceCatalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCatalogType }
     *     
     */
    public void setServiceCatalog(ServiceCatalogType value) {
        this.serviceCatalog = value;
    }

}
