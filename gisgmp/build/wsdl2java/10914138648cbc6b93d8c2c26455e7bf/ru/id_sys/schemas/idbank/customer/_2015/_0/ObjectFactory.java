
package ru.id_sys.schemas.idbank.customer._2015._0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.id_sys.schemas.idbank.customer._2015._0 package. 
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

    private final static QName _Customer_QNAME = new QName("http://www.id-sys.ru/schemas/idbank/customer/2015/0.01/", "Customer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.id_sys.schemas.idbank.customer._2015._0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerDataFilterItem }
     * 
     */
    public CustomerDataFilterItem createCustomerDataFilterItem() {
        return new CustomerDataFilterItem();
    }

    /**
     * Create an instance of {@link BankruptcyData }
     * 
     */
    public BankruptcyData createBankruptcyData() {
        return new BankruptcyData();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link CustomerDocument }
     * 
     */
    public CustomerDocument createCustomerDocument() {
        return new CustomerDocument();
    }

    /**
     * Create an instance of {@link CustomerDataFilterItem.TimeFilter }
     * 
     */
    public CustomerDataFilterItem.TimeFilter createCustomerDataFilterItemTimeFilter() {
        return new CustomerDataFilterItem.TimeFilter();
    }

    /**
     * Create an instance of {@link BankruptcyData.NameHistory }
     * 
     */
    public BankruptcyData.NameHistory createBankruptcyDataNameHistory() {
        return new BankruptcyData.NameHistory();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.id-sys.ru/schemas/idbank/customer/2015/0.01/", name = "Customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

}
