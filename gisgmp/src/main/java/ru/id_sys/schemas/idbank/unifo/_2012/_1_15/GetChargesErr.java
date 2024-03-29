
package ru.id_sys.schemas.idbank.unifo._2012._1_15;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.3.1
 * 2019-03-21T13:35:14.401+03:00
 * Generated source version: 3.3.1
 */

@WebFault(name = "Error", targetNamespace = "http://www.id-sys.ru/schemas/idbank/unifo/2012/1.15/")
public class GetChargesErr extends Exception {

    private ru.id_sys.schemas.idbank.common._2012._0.Error error;

    public GetChargesErr() {
        super();
    }

    public GetChargesErr(String message) {
        super(message);
    }

    public GetChargesErr(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public GetChargesErr(String message, ru.id_sys.schemas.idbank.common._2012._0.Error error) {
        super(message);
        this.error = error;
    }

    public GetChargesErr(String message, ru.id_sys.schemas.idbank.common._2012._0.Error error, java.lang.Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public ru.id_sys.schemas.idbank.common._2012._0.Error getFaultInfo() {
        return this.error;
    }
}
