
package ru.roskazna.xsd.pgu_chargesresponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.roskazna.xsd.pgu_chargesresponse package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ExportChargesResponse_QNAME = new QName("http://roskazna.ru/xsd/PGU_ChargesResponse", "ExportChargesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.roskazna.xsd.pgu_chargesresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExportChargesResponse }
     * 
     */
    public ExportChargesResponse createExportChargesResponse() {
        return new ExportChargesResponse();
    }

    /**
     * Create an instance of {@link ExportChargesResponse.Charges }
     * 
     */
    public ExportChargesResponse.Charges createExportChargesResponseCharges() {
        return new ExportChargesResponse.Charges();
    }

    /**
     * Create an instance of {@link ExportChargesResponse.Charges.ChargeInfo }
     * 
     */
    public ExportChargesResponse.Charges.ChargeInfo createExportChargesResponseChargesChargeInfo() {
        return new ExportChargesResponse.Charges.ChargeInfo();
    }

    /**
     * Create an instance of {@link ExportChargesResponse.Charges.ChargeInfo.IsRevoked }
     * 
     */
    public ExportChargesResponse.Charges.ChargeInfo.IsRevoked createExportChargesResponseChargesChargeInfoIsRevoked() {
        return new ExportChargesResponse.Charges.ChargeInfo.IsRevoked();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExportChargesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExportChargesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://roskazna.ru/xsd/PGU_ChargesResponse", name = "ExportChargesResponse")
    public JAXBElement<ExportChargesResponse> createExportChargesResponse(ExportChargesResponse value) {
        return new JAXBElement<ExportChargesResponse>(_ExportChargesResponse_QNAME, ExportChargesResponse.class, null, value);
    }

}
