
package ru.id_sys.schemas.idbank.thirdpartyorderservice._2015._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListFields"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="draftField" type="{http://www.id-sys.ru/schemas/idbank/ThirdPartyOrderService/2015/0.01/}DraftField" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListFields", propOrder = {
    "draftField"
})
public class ListFields {

    protected List<DraftField> draftField;

    /**
     * Gets the value of the draftField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the draftField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDraftField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DraftField }
     * 
     * 
     */
    public List<DraftField> getDraftField() {
        if (draftField == null) {
            draftField = new ArrayList<DraftField>();
        }
        return this.draftField;
    }

}
