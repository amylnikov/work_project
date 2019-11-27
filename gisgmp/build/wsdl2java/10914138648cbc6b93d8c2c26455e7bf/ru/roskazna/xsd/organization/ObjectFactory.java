
package ru.roskazna.xsd.organization;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.roskazna.xsd.organization package. 
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

    private final static QName _Payee_QNAME = new QName("http://roskazna.ru/xsd/Organization", "Payee");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.roskazna.xsd.organization
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link PayeeType }
     * 
     */
    public PayeeType createPayeeType() {
        return new PayeeType();
    }

    /**
     * Create an instance of {@link AccountCatalogType }
     * 
     */
    public AccountCatalogType createAccountCatalogType() {
        return new AccountCatalogType();
    }

    /**
     * Create an instance of {@link AccountType }
     * 
     */
    public AccountType createAccountType() {
        return new AccountType();
    }

    /**
     * Create an instance of {@link AccountsType }
     * 
     */
    public AccountsType createAccountsType() {
        return new AccountsType();
    }

    /**
     * Create an instance of {@link OrganizationCatalogType }
     * 
     */
    public OrganizationCatalogType createOrganizationCatalogType() {
        return new OrganizationCatalogType();
    }

    /**
     * Create an instance of {@link BankCatalogType }
     * 
     */
    public BankCatalogType createBankCatalogType() {
        return new BankCatalogType();
    }

    /**
     * Create an instance of {@link BankType }
     * 
     */
    public BankType createBankType() {
        return new BankType();
    }

    /**
     * Create an instance of {@link KFOType }
     * 
     */
    public KFOType createKFOType() {
        return new KFOType();
    }

    /**
     * Create an instance of {@link OrganizationType.Addresses }
     * 
     */
    public OrganizationType.Addresses createOrganizationTypeAddresses() {
        return new OrganizationType.Addresses();
    }

    /**
     * Create an instance of {@link OrganizationType.Contacts }
     * 
     */
    public OrganizationType.Contacts createOrganizationTypeContacts() {
        return new OrganizationType.Contacts();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayeeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PayeeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://roskazna.ru/xsd/Organization", name = "Payee")
    public JAXBElement<PayeeType> createPayee(PayeeType value) {
        return new JAXBElement<PayeeType>(_Payee_QNAME, PayeeType.class, null, value);
    }

}
