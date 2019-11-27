
package ru.id_sys.schemas.idbank.unifo._2012._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ru.id_sys.schemas.idbank.common._2012._0.Error;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.id_sys.schemas.idbank.unifo._2012._1 package. 
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

    private final static QName _GetChargesRq_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "GetChargesRq");
    private final static QName _GetChargesRs_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "GetChargesRs");
    private final static QName _PutPaymentRq_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "PutPaymentRq");
    private final static QName _PutPaymentRs_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "PutPaymentRs");
    private final static QName _PutRefPaymentsRq_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "PutRefPaymentsRq");
    private final static QName _PutRefPaymentsRs_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "PutRefPaymentsRs");
    private final static QName _GetCatalogRq_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "GetCatalogRq");
    private final static QName _GetCatalogRs_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "GetCatalogRs");
    private final static QName _PutPayDocsRq_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "PutPayDocsRq");
    private final static QName _PutPayDocsRs_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "PutPayDocsRs");
    private final static QName _AuthPaymentRq_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "AuthPaymentRq");
    private final static QName _AuthPaymentRs_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "AuthPaymentRs");
    private final static QName _Error_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", "Error");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.id_sys.schemas.idbank.unifo._2012._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExportChargesResponseEx }
     * 
     */
    public ExportChargesResponseEx createExportChargesResponseEx() {
        return new ExportChargesResponseEx();
    }

    /**
     * Create an instance of {@link ExportChargesResponseEx.Charges }
     * 
     */
    public ExportChargesResponseEx.Charges createExportChargesResponseExCharges() {
        return new ExportChargesResponseEx.Charges();
    }

    /**
     * Create an instance of {@link ExportChargesResponseEx.Charges.ChargeInfo }
     * 
     */
    public ExportChargesResponseEx.Charges.ChargeInfo createExportChargesResponseExChargesChargeInfo() {
        return new ExportChargesResponseEx.Charges.ChargeInfo();
    }

    /**
     * Create an instance of {@link AuthPaymentRq }
     * 
     */
    public AuthPaymentRq createAuthPaymentRq() {
        return new AuthPaymentRq();
    }

    /**
     * Create an instance of {@link AuthPaymentRq.Payment }
     * 
     */
    public AuthPaymentRq.Payment createAuthPaymentRqPayment() {
        return new AuthPaymentRq.Payment();
    }

    /**
     * Create an instance of {@link PutPayDocsRq }
     * 
     */
    public PutPayDocsRq createPutPayDocsRq() {
        return new PutPayDocsRq();
    }

    /**
     * Create an instance of {@link PutPayDocsRq.Document }
     * 
     */
    public PutPayDocsRq.Document createPutPayDocsRqDocument() {
        return new PutPayDocsRq.Document();
    }

    /**
     * Create an instance of {@link GetCatalogRs }
     * 
     */
    public GetCatalogRs createGetCatalogRs() {
        return new GetCatalogRs();
    }

    /**
     * Create an instance of {@link PutRefPaymentsRq }
     * 
     */
    public PutRefPaymentsRq createPutRefPaymentsRq() {
        return new PutRefPaymentsRq();
    }

    /**
     * Create an instance of {@link PutRefPaymentsRq.RefPayments }
     * 
     */
    public PutRefPaymentsRq.RefPayments createPutRefPaymentsRqRefPayments() {
        return new PutRefPaymentsRq.RefPayments();
    }

    /**
     * Create an instance of {@link GetChargesRq }
     * 
     */
    public GetChargesRq createGetChargesRq() {
        return new GetChargesRq();
    }

    /**
     * Create an instance of {@link GetChargesRs }
     * 
     */
    public GetChargesRs createGetChargesRs() {
        return new GetChargesRs();
    }

    /**
     * Create an instance of {@link PutPaymentRq }
     * 
     */
    public PutPaymentRq createPutPaymentRq() {
        return new PutPaymentRq();
    }

    /**
     * Create an instance of {@link PutPaymentRs }
     * 
     */
    public PutPaymentRs createPutPaymentRs() {
        return new PutPaymentRs();
    }

    /**
     * Create an instance of {@link PutRefPaymentsRs }
     * 
     */
    public PutRefPaymentsRs createPutRefPaymentsRs() {
        return new PutRefPaymentsRs();
    }

    /**
     * Create an instance of {@link GetCatalogRq }
     * 
     */
    public GetCatalogRq createGetCatalogRq() {
        return new GetCatalogRq();
    }

    /**
     * Create an instance of {@link PutPayDocsRs }
     * 
     */
    public PutPayDocsRs createPutPayDocsRs() {
        return new PutPayDocsRs();
    }

    /**
     * Create an instance of {@link AuthPaymentRs }
     * 
     */
    public AuthPaymentRs createAuthPaymentRs() {
        return new AuthPaymentRs();
    }

    /**
     * Create an instance of {@link ru.id_sys.schemas.idbank.unifo._2012._1.AccDoc }
     * 
     */
    public ru.id_sys.schemas.idbank.unifo._2012._1.AccDoc createAccDoc() {
        return new ru.id_sys.schemas.idbank.unifo._2012._1.AccDoc();
    }

    /**
     * Create an instance of {@link ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked }
     * 
     */
    public ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked createExportChargesResponseExChargesChargeInfoIsRevoked() {
        return new ExportChargesResponseEx.Charges.ChargeInfo.IsRevoked();
    }

    /**
     * Create an instance of {@link AuthPaymentRq.Payment.Payee }
     * 
     */
    public AuthPaymentRq.Payment.Payee createAuthPaymentRqPaymentPayee() {
        return new AuthPaymentRq.Payment.Payee();
    }

    /**
     * Create an instance of {@link PutPayDocsRq.Document.AccDoc }
     * 
     */
    public PutPayDocsRq.Document.AccDoc createPutPayDocsRqDocumentAccDoc() {
        return new PutPayDocsRq.Document.AccDoc();
    }

    /**
     * Create an instance of {@link GetCatalogRs.Catalog }
     * 
     */
    public GetCatalogRs.Catalog createGetCatalogRsCatalog() {
        return new GetCatalogRs.Catalog();
    }

    /**
     * Create an instance of {@link PutRefPaymentsRq.RefPayments.RefPayment }
     * 
     */
    public PutRefPaymentsRq.RefPayments.RefPayment createPutRefPaymentsRqRefPaymentsRefPayment() {
        return new PutRefPaymentsRq.RefPayments.RefPayment();
    }

    /**
     * Create an instance of {@link GetChargesRq.Paging }
     * 
     */
    public GetChargesRq.Paging createGetChargesRqPaging() {
        return new GetChargesRq.Paging();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChargesRq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetChargesRq }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "GetChargesRq")
    public JAXBElement<GetChargesRq> createGetChargesRq(GetChargesRq value) {
        return new JAXBElement<GetChargesRq>(_GetChargesRq_QNAME, GetChargesRq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChargesRs }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetChargesRs }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "GetChargesRs")
    public JAXBElement<GetChargesRs> createGetChargesRs(GetChargesRs value) {
        return new JAXBElement<GetChargesRs>(_GetChargesRs_QNAME, GetChargesRs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutPaymentRq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PutPaymentRq }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "PutPaymentRq")
    public JAXBElement<PutPaymentRq> createPutPaymentRq(PutPaymentRq value) {
        return new JAXBElement<PutPaymentRq>(_PutPaymentRq_QNAME, PutPaymentRq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutPaymentRs }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PutPaymentRs }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "PutPaymentRs")
    public JAXBElement<PutPaymentRs> createPutPaymentRs(PutPaymentRs value) {
        return new JAXBElement<PutPaymentRs>(_PutPaymentRs_QNAME, PutPaymentRs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutRefPaymentsRq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PutRefPaymentsRq }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "PutRefPaymentsRq")
    public JAXBElement<PutRefPaymentsRq> createPutRefPaymentsRq(PutRefPaymentsRq value) {
        return new JAXBElement<PutRefPaymentsRq>(_PutRefPaymentsRq_QNAME, PutRefPaymentsRq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutRefPaymentsRs }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PutRefPaymentsRs }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "PutRefPaymentsRs")
    public JAXBElement<PutRefPaymentsRs> createPutRefPaymentsRs(PutRefPaymentsRs value) {
        return new JAXBElement<PutRefPaymentsRs>(_PutRefPaymentsRs_QNAME, PutRefPaymentsRs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogRq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCatalogRq }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "GetCatalogRq")
    public JAXBElement<GetCatalogRq> createGetCatalogRq(GetCatalogRq value) {
        return new JAXBElement<GetCatalogRq>(_GetCatalogRq_QNAME, GetCatalogRq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogRs }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCatalogRs }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "GetCatalogRs")
    public JAXBElement<GetCatalogRs> createGetCatalogRs(GetCatalogRs value) {
        return new JAXBElement<GetCatalogRs>(_GetCatalogRs_QNAME, GetCatalogRs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutPayDocsRq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PutPayDocsRq }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "PutPayDocsRq")
    public JAXBElement<PutPayDocsRq> createPutPayDocsRq(PutPayDocsRq value) {
        return new JAXBElement<PutPayDocsRq>(_PutPayDocsRq_QNAME, PutPayDocsRq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutPayDocsRs }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PutPayDocsRs }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "PutPayDocsRs")
    public JAXBElement<PutPayDocsRs> createPutPayDocsRs(PutPayDocsRs value) {
        return new JAXBElement<PutPayDocsRs>(_PutPayDocsRs_QNAME, PutPayDocsRs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthPaymentRq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AuthPaymentRq }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "AuthPaymentRq")
    public JAXBElement<AuthPaymentRq> createAuthPaymentRq(AuthPaymentRq value) {
        return new JAXBElement<AuthPaymentRq>(_AuthPaymentRq_QNAME, AuthPaymentRq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthPaymentRs }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AuthPaymentRs }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "AuthPaymentRs")
    public JAXBElement<AuthPaymentRs> createAuthPaymentRs(AuthPaymentRs value) {
        return new JAXBElement<AuthPaymentRs>(_AuthPaymentRs_QNAME, AuthPaymentRs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Error }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Error }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/", name = "Error")
    public JAXBElement<Error> createError(Error value) {
        return new JAXBElement<Error>(_Error_QNAME, Error.class, null, value);
    }

}
