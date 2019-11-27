
package ru.roskazna.xsd.paymentinfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.roskazna.xsd.paymentinfo package. 
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

    private final static QName _Income_QNAME = new QName("http://roskazna.ru/xsd/PaymentInfo", "Income");
    private final static QName _FinalPayment_QNAME = new QName("http://roskazna.ru/xsd/PaymentInfo", "FinalPayment");
    private final static QName _TransKind_QNAME = new QName("http://roskazna.ru/xsd/PaymentInfo", "TransKind");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.roskazna.xsd.paymentinfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentType }
     * 
     */
    public PaymentType createPaymentType() {
        return new PaymentType();
    }

    /**
     * Create an instance of {@link PaymentInfoType }
     * 
     */
    public PaymentInfoType createPaymentInfoType() {
        return new PaymentInfoType();
    }

    /**
     * Create an instance of {@link PaymentInfoType.SpeciallID }
     * 
     */
    public PaymentInfoType.SpeciallID createPaymentInfoTypeSpeciallID() {
        return new PaymentInfoType.SpeciallID();
    }

    /**
     * Create an instance of {@link PaymentInfoType.SpeciallID.Payer }
     * 
     */
    public PaymentInfoType.SpeciallID.Payer createPaymentInfoTypeSpeciallIDPayer() {
        return new PaymentInfoType.SpeciallID.Payer();
    }

    /**
     * Create an instance of {@link IncomeInfoType }
     * 
     */
    public IncomeInfoType createIncomeInfoType() {
        return new IncomeInfoType();
    }

    /**
     * Create an instance of {@link AccDoc }
     * 
     */
    public AccDoc createAccDoc() {
        return new AccDoc();
    }

    /**
     * Create an instance of {@link PaymentIdentificationDataType }
     * 
     */
    public PaymentIdentificationDataType createPaymentIdentificationDataType() {
        return new PaymentIdentificationDataType();
    }

    /**
     * Create an instance of {@link FioType }
     * 
     */
    public FioType createFioType() {
        return new FioType();
    }

    /**
     * Create an instance of {@link PaymentType.AdditionalData }
     * 
     */
    public PaymentType.AdditionalData createPaymentTypeAdditionalData() {
        return new PaymentType.AdditionalData();
    }

    /**
     * Create an instance of {@link PaymentType.PartialPayt }
     * 
     */
    public PaymentType.PartialPayt createPaymentTypePartialPayt() {
        return new PaymentType.PartialPayt();
    }

    /**
     * Create an instance of {@link PaymentInfoType.SupplierData }
     * 
     */
    public PaymentInfoType.SupplierData createPaymentInfoTypeSupplierData() {
        return new PaymentInfoType.SupplierData();
    }

    /**
     * Create an instance of {@link PaymentInfoType.SpeciallID.Period }
     * 
     */
    public PaymentInfoType.SpeciallID.Period createPaymentInfoTypeSpeciallIDPeriod() {
        return new PaymentInfoType.SpeciallID.Period();
    }

    /**
     * Create an instance of {@link PaymentInfoType.SpeciallID.Payer.FIO }
     * 
     */
    public PaymentInfoType.SpeciallID.Payer.FIO createPaymentInfoTypeSpeciallIDPayerFIO() {
        return new PaymentInfoType.SpeciallID.Payer.FIO();
    }

    /**
     * Create an instance of {@link PaymentInfoType.SpeciallID.Payer.Address }
     * 
     */
    public PaymentInfoType.SpeciallID.Payer.Address createPaymentInfoTypeSpeciallIDPayerAddress() {
        return new PaymentInfoType.SpeciallID.Payer.Address();
    }

    /**
     * Create an instance of {@link IncomeInfoType.IncomeRows }
     * 
     */
    public IncomeInfoType.IncomeRows createIncomeInfoTypeIncomeRows() {
        return new IncomeInfoType.IncomeRows();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncomeInfoType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncomeInfoType }{@code >}
     */
    @XmlElementDecl(namespace = "http://roskazna.ru/xsd/PaymentInfo", name = "Income")
    public JAXBElement<IncomeInfoType> createIncome(IncomeInfoType value) {
        return new JAXBElement<IncomeInfoType>(_Income_QNAME, IncomeInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentInfoType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaymentInfoType }{@code >}
     */
    @XmlElementDecl(namespace = "http://roskazna.ru/xsd/PaymentInfo", name = "FinalPayment")
    public JAXBElement<PaymentInfoType> createFinalPayment(PaymentInfoType value) {
        return new JAXBElement<PaymentInfoType>(_FinalPayment_QNAME, PaymentInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://roskazna.ru/xsd/PaymentInfo", name = "TransKind")
    public JAXBElement<String> createTransKind(String value) {
        return new JAXBElement<String>(_TransKind_QNAME, String.class, null, value);
    }

}
