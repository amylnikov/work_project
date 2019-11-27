
package ru.id_sys.schemas.idbank.common._2012._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.id_sys.schemas.idbank.cik._2017._0.Персона;
import ru.id_sys.schemas.idbank.esia._2015._0.AuthorityRequest;
import ru.id_sys.schemas.idbank.esia._2015._0.RegisterNBPType;
import ru.id_sys.schemas.idbank.notary._2014._1.PledgeNotificationSigned;
import ru.id_sys.schemas.idbank.notary._2014._1.RegistrationCertificateSigned;
import ru.id_sys.schemas.idbank.thirdpartyorderservice._2015._0.GosLimit;
import ru.id_sys.schemas.idbank.thirdpartyorderservice._2015._0.GosServ;


/**
 * Документ
 * 
 * <p>Java class for CommonDocument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonDocument"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}Object"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="PledgeNotification" type="{http://www.id-sys.ru/schemas/idbank/notary/2014/1.00/}PledgeNotificationSigned"/&gt;
 *         &lt;element name="RegistrationCertificate" type="{http://www.id-sys.ru/schemas/idbank/notary/2014/1.00/}RegistrationCertificateSigned"/&gt;
 *         &lt;element name="Register" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}AuthorityRequest"/&gt;
 *         &lt;element name="Recover" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}AuthorityRequest"/&gt;
 *         &lt;element name="DeleteEsiaAcc" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}AuthorityRequest"/&gt;
 *         &lt;element name="Confirm" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}AuthorityRequest"/&gt;
 *         &lt;element name="GosServ" type="{http://www.id-sys.ru/schemas/idbank/ThirdPartyOrderService/2015/0.01/}GosServ"/&gt;
 *         &lt;element name="GosLimit" type="{http://www.id-sys.ru/schemas/idbank/ThirdPartyOrderService/2015/0.01/}GosLimit"/&gt;
 *         &lt;element name="RegisterNBP" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}RegisterNBPType"/&gt;
 *         &lt;element name="Персона" type="{http://www.id-sys.ru/schemas/idbank/cik/2017/0.01/}Персона"/&gt;
 *         &lt;element name="RegisterBySimplified" type="{http://www.id-sys.ru/schemas/idbank/esia/2015/0.01/}AuthorityRequest"/&gt;
 *         &lt;element name="PFR_ILS" type="{http://www.id-sys.ru/schemas/idbank/common/2012/0.01/}PFR_ILS"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="customerID" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonDocument", propOrder = {
    "pledgeNotification",
    "registrationCertificate",
    "register",
    "recover",
    "deleteEsiaAcc",
    "confirm",
    "gosServ",
    "gosLimit",
    "registerNBP",
    "\u043f\u0435\u0440\u0441\u043e\u043d\u0430",
    "registerBySimplified",
    "pfrils"
})
public class CommonDocument
    extends Object
{

    @XmlElement(name = "PledgeNotification")
    protected PledgeNotificationSigned pledgeNotification;
    @XmlElement(name = "RegistrationCertificate")
    protected RegistrationCertificateSigned registrationCertificate;
    @XmlElement(name = "Register")
    protected AuthorityRequest register;
    @XmlElement(name = "Recover")
    protected AuthorityRequest recover;
    @XmlElement(name = "DeleteEsiaAcc")
    protected AuthorityRequest deleteEsiaAcc;
    @XmlElement(name = "Confirm")
    protected AuthorityRequest confirm;
    @XmlElement(name = "GosServ")
    protected GosServ gosServ;
    @XmlElement(name = "GosLimit")
    protected GosLimit gosLimit;
    @XmlElement(name = "RegisterNBP")
    protected RegisterNBPType registerNBP;
    @XmlElement(name = "\u041f\u0435\u0440\u0441\u043e\u043d\u0430")
    protected Персона персона;
    @XmlElement(name = "RegisterBySimplified")
    protected AuthorityRequest registerBySimplified;
    @XmlElement(name = "PFR_ILS")
    protected PFRILS pfrils;
    @XmlAttribute(name = "customerID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String customerID;

    /**
     * Gets the value of the pledgeNotification property.
     * 
     * @return
     *     possible object is
     *     {@link PledgeNotificationSigned }
     *     
     */
    public PledgeNotificationSigned getPledgeNotification() {
        return pledgeNotification;
    }

    /**
     * Sets the value of the pledgeNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link PledgeNotificationSigned }
     *     
     */
    public void setPledgeNotification(PledgeNotificationSigned value) {
        this.pledgeNotification = value;
    }

    /**
     * Gets the value of the registrationCertificate property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationCertificateSigned }
     *     
     */
    public RegistrationCertificateSigned getRegistrationCertificate() {
        return registrationCertificate;
    }

    /**
     * Sets the value of the registrationCertificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationCertificateSigned }
     *     
     */
    public void setRegistrationCertificate(RegistrationCertificateSigned value) {
        this.registrationCertificate = value;
    }

    /**
     * Gets the value of the register property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorityRequest }
     *     
     */
    public AuthorityRequest getRegister() {
        return register;
    }

    /**
     * Sets the value of the register property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorityRequest }
     *     
     */
    public void setRegister(AuthorityRequest value) {
        this.register = value;
    }

    /**
     * Gets the value of the recover property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorityRequest }
     *     
     */
    public AuthorityRequest getRecover() {
        return recover;
    }

    /**
     * Sets the value of the recover property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorityRequest }
     *     
     */
    public void setRecover(AuthorityRequest value) {
        this.recover = value;
    }

    /**
     * Gets the value of the deleteEsiaAcc property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorityRequest }
     *     
     */
    public AuthorityRequest getDeleteEsiaAcc() {
        return deleteEsiaAcc;
    }

    /**
     * Sets the value of the deleteEsiaAcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorityRequest }
     *     
     */
    public void setDeleteEsiaAcc(AuthorityRequest value) {
        this.deleteEsiaAcc = value;
    }

    /**
     * Gets the value of the confirm property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorityRequest }
     *     
     */
    public AuthorityRequest getConfirm() {
        return confirm;
    }

    /**
     * Sets the value of the confirm property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorityRequest }
     *     
     */
    public void setConfirm(AuthorityRequest value) {
        this.confirm = value;
    }

    /**
     * Gets the value of the gosServ property.
     * 
     * @return
     *     possible object is
     *     {@link GosServ }
     *     
     */
    public GosServ getGosServ() {
        return gosServ;
    }

    /**
     * Sets the value of the gosServ property.
     * 
     * @param value
     *     allowed object is
     *     {@link GosServ }
     *     
     */
    public void setGosServ(GosServ value) {
        this.gosServ = value;
    }

    /**
     * Gets the value of the gosLimit property.
     * 
     * @return
     *     possible object is
     *     {@link GosLimit }
     *     
     */
    public GosLimit getGosLimit() {
        return gosLimit;
    }

    /**
     * Sets the value of the gosLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link GosLimit }
     *     
     */
    public void setGosLimit(GosLimit value) {
        this.gosLimit = value;
    }

    /**
     * Gets the value of the registerNBP property.
     * 
     * @return
     *     possible object is
     *     {@link RegisterNBPType }
     *     
     */
    public RegisterNBPType getRegisterNBP() {
        return registerNBP;
    }

    /**
     * Sets the value of the registerNBP property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegisterNBPType }
     *     
     */
    public void setRegisterNBP(RegisterNBPType value) {
        this.registerNBP = value;
    }

    /**
     * Gets the value of the персона property.
     * 
     * @return
     *     possible object is
     *     {@link Персона }
     *     
     */
    public Персона getПерсона() {
        return персона;
    }

    /**
     * Sets the value of the персона property.
     * 
     * @param value
     *     allowed object is
     *     {@link Персона }
     *     
     */
    public void setПерсона(Персона value) {
        this.персона = value;
    }

    /**
     * Gets the value of the registerBySimplified property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorityRequest }
     *     
     */
    public AuthorityRequest getRegisterBySimplified() {
        return registerBySimplified;
    }

    /**
     * Sets the value of the registerBySimplified property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorityRequest }
     *     
     */
    public void setRegisterBySimplified(AuthorityRequest value) {
        this.registerBySimplified = value;
    }

    /**
     * Gets the value of the pfrils property.
     * 
     * @return
     *     possible object is
     *     {@link PFRILS }
     *     
     */
    public PFRILS getPFRILS() {
        return pfrils;
    }

    /**
     * Sets the value of the pfrils property.
     * 
     * @param value
     *     allowed object is
     *     {@link PFRILS }
     *     
     */
    public void setPFRILS(PFRILS value) {
        this.pfrils = value;
    }

    /**
     * Gets the value of the customerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Sets the value of the customerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerID(String value) {
        this.customerID = value;
    }

}
