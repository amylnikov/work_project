
package ru.id_sys.schemas.idbank.customer._2015._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.id_sys.schemas.idbank.common._2012._0.DateTimeRange;
import ru.id_sys.schemas.idbank.common._2012._0.Object;


/**
 * ������� ������� �������� � �������
 * 
 * <p>Java class for CustomerDataFilterItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerDataFilterItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Object"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TimeFilter" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="Range" type="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}DateTimeRange"/&gt;
 *                   &lt;element name="Unread" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerDataFilterItem", propOrder = {
    "timeFilter"
})
public class CustomerDataFilterItem
    extends Object
{

    @XmlElement(name = "TimeFilter")
    protected CustomerDataFilterItem.TimeFilter timeFilter;

    /**
     * Gets the value of the timeFilter property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerDataFilterItem.TimeFilter }
     *     
     */
    public CustomerDataFilterItem.TimeFilter getTimeFilter() {
        return timeFilter;
    }

    /**
     * Sets the value of the timeFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerDataFilterItem.TimeFilter }
     *     
     */
    public void setTimeFilter(CustomerDataFilterItem.TimeFilter value) {
        this.timeFilter = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="Range" type="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}DateTimeRange"/&gt;
     *         &lt;element name="Unread" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "range",
        "unread"
    })
    public static class TimeFilter {

        @XmlElement(name = "Range")
        protected DateTimeRange range;
        @XmlElement(name = "Unread")
        protected Boolean unread;

        /**
         * Gets the value of the range property.
         * 
         * @return
         *     possible object is
         *     {@link DateTimeRange }
         *     
         */
        public DateTimeRange getRange() {
            return range;
        }

        /**
         * Sets the value of the range property.
         * 
         * @param value
         *     allowed object is
         *     {@link DateTimeRange }
         *     
         */
        public void setRange(DateTimeRange value) {
            this.range = value;
        }

        /**
         * Gets the value of the unread property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isUnread() {
            return unread;
        }

        /**
         * Sets the value of the unread property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setUnread(Boolean value) {
            this.unread = value;
        }

    }

}
