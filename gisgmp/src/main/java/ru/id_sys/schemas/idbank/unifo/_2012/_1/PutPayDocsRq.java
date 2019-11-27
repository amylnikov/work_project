
package ru.id_sys.schemas.idbank.unifo._2012._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.id_sys.schemas.idbank.common._2012._0.Message;


/**
 * «апрос на регистрацию расчетных документов
 * 
 * <p>Java class for PutPayDocsRq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PutPayDocsRq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Message"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Document" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AccDoc" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/}AccDoc"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="DocAction"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                       &lt;enumeration value="0"/&gt;
 *                       &lt;enumeration value="1"/&gt;
 *                       &lt;enumeration value="2"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="DocRef"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                       &lt;minLength value="1"/&gt;
 *                       &lt;maxLength value="100"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
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
@XmlType(name = "PutPayDocsRq", propOrder = {
    "document"
})
public class PutPayDocsRq
    extends Message
{

    @XmlElement(name = "Document", required = true)
    protected List<PutPayDocsRq.Document> document;

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PutPayDocsRq.Document }
     * 
     * 
     */
    public List<PutPayDocsRq.Document> getDocument() {
        if (document == null) {
            document = new ArrayList<PutPayDocsRq.Document>();
        }
        return this.document;
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
     *         &lt;element name="AccDoc" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/}AccDoc"&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="DocAction"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *             &lt;enumeration value="0"/&gt;
     *             &lt;enumeration value="1"/&gt;
     *             &lt;enumeration value="2"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="DocRef"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *             &lt;minLength value="1"/&gt;
     *             &lt;maxLength value="100"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "accDoc"
    })
    public static class Document {

        @XmlElement(name = "AccDoc")
        protected PutPayDocsRq.Document.AccDoc accDoc;
        @XmlAttribute(name = "DocAction")
        protected Integer docAction;
        @XmlAttribute(name = "DocRef")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String docRef;

        /**
         * Gets the value of the accDoc property.
         * 
         * @return
         *     possible object is
         *     {@link PutPayDocsRq.Document.AccDoc }
         *     
         */
        public PutPayDocsRq.Document.AccDoc getAccDoc() {
            return accDoc;
        }

        /**
         * Sets the value of the accDoc property.
         * 
         * @param value
         *     allowed object is
         *     {@link PutPayDocsRq.Document.AccDoc }
         *     
         */
        public void setAccDoc(PutPayDocsRq.Document.AccDoc value) {
            this.accDoc = value;
        }

        /**
         * Gets the value of the docAction property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getDocAction() {
            return docAction;
        }

        /**
         * Sets the value of the docAction property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setDocAction(Integer value) {
            this.docAction = value;
        }

        /**
         * Gets the value of the docRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocRef() {
            return docRef;
        }

        /**
         * Sets the value of the docRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocRef(String value) {
            this.docRef = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/}AccDoc"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class AccDoc
            extends ru.id_sys.schemas.idbank.unifo._2012._1.AccDoc
        {


        }

    }

}
