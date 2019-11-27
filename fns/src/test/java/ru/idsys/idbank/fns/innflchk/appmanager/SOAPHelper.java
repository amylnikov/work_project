package ru.idsys.idbank.fns.innflchk.appmanager;


import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import javax.xml.ws.handler.MessageContext;

import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс помошник для формирования и отправки запросов к сервису через soap протокол
 * Также в нем происходит обработка полученных ответов и различные проверки
 * @author a.mylnikov
 */
public class SOAPHelper implements SOAPHandler {
    private final Properties properties;


    public SOAPHelper() throws IOException {
        properties = new Properties();
        properties.load(new FileReader(new File("src/test/resources/local.properties")));
    }





    /**
     * Метод преобразования типа ДУЛ полученного из тестовых данных в формат пригодный для передачи в запросе к сервису unifo
     * возвращается строковое значение в нужном формате
     * @param dulType - параметр в котором передается строка которую необходимо преобразовать
     * @return
     */
    private String dulTypeConverter(String dulType) {
        try {
            if (dulType.equals("Паспорт гражданина РФ") || dulType.equals("1")) {
                return "1";
            } else if (dulType.equals("Документ иностранного гражданина") || dulType.equals("2")) {
                return "2";
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        return null;
    }

    /**
     * Метод для преобразования Типа запрашиваемых данных в формат пригодный для gередачи в запросе к сервису unifo
     * возвращает строковое значение в преобразованном формате
     * @param data - параметр в котором передается строка для преобразования
     * @return
     */
    private String kindDataConverter(String data) {
        if (data != null) {
            if (data.equals("Неоплаченные предварительные начисления") || data.equals("CHARGE-PRIOR")) {
                return "CHARGE-PRIOR";
            } else if (data.equals("Не полностью сквитованные начисления") || data.equals("CHARGENOTFULLMATCHED")) {
                return "CHARGENOTFULLMATCHED";
            } else if (data.equals("Платежи") || data.equals("PAYMENT")) {
                return "PAYMENT";
            } else if (data.equals("Платежи по связанным начислениям") || data.equals("PAYMENTMAINCHARGE")) {
                return "PAYMENTMAINCHARGE";
            } else if (data.equals("Зачисления") || data.equals("INCOME")) {
                return "INCOME";
            } else if (data.equals("Неоплаченные начисления") || data.equals("CHARGE")) {
                return "CHARGE";
            } else if (data.equals("Начисления и статусы их квитирования с платежами, включая оплаченные") || data.equals("CHARGESTATUS")) {
                return "CHARGESTATUS";
            } else if (data.equals("Результат квитирования") || data.equals("QUITTANCE")) {
                return "QUITTANCE";
            } else if (data.equals("Все результаты квитирования, включая аннулированные") || data.equals("ALLQUITTANCE")) {
                return "ALLQUITTANCE";
            } else if (data.equals("Каталог услуг поставщика") || data.equals("CATALOG")) {
                return "CATALOG";
            } else if (data.equals("Не полностью сквитованные предварительные начисления") || data.equals("CHARGE-PRIOR-NOTFULLMATCHED")) {
                return "CHARGE-PRIOR-NOTFULLMATCHED";
            } else if (data.equals("Неоплаченные предварительные начисления, сформированные ГИС ГМП") || data.equals("TEMP-CHARGING")) {
                return "TEMP-CHARGING";
            } else if (data.equals("Не полностью сквитованные предварительные начисления, сформированные ГИС ГМП") || data.equals("TEMP-CHARGING-NOTFULLMATCHED")) {
                return "TEMP-CHARGING-NOTFULLMATCHED";
            } else if (data.equals("Уточненные платежи запрашивающего АДБ") || data.equals("PAYMENTMODIFIED")) {
                return "PAYMENTMODIFIED";
            } else if (data.equals("Все платежи, которым в системе не поставлена в соответствие ни одна квитанция") || data.equals("PAYMENTUNMATCHED")) {
                return "PAYMENTUNMATCHED";
            } else if (data.equals("Предварительные начисления и статусы их квитирования") || data.equals("CHARGE-PRIOR-STATUS")) {
                return "CHARGE-PRIOR-STATUS";
            } else if (data.equals("Предварительные начисления, сформированные ГИС ГМП, и статусы их квитирования") || data.equals("TEMP-CHARGING-STATUS")) {
                return "TEMP-CHARGING-STATUS";
            } else if (data.equals("Аннулированные платежи") || data.equals("PAYMENTCANCELLED")) {
                return "PAYMENTCANCELLED";
            } else if (data.equals("Связанные начисления") || data.equals("MAINCHARGE")) {
                return "MAINCHARGE";
            }
        }
        return null;
    }

    /**
     * Метод преобразования дады в формат XMLGregorianCalendar для использования в запросах к сервису unifo
     * возвращает дату в преобразованном виде,
     * если полученная для преобразования дата не соответстует шаблону,
     * то возвращается значение по умолчанию
     * @param date - параметр дв котором передается строка с датой для преобразования в одном из предусмотренных шаблоном фоормате
     *             можно расширять набор шаблонов при необходимости
     * @return
     * @throws ParseException
     * @throws DatatypeConfigurationException
     */
    private XMLGregorianCalendar dateGregorianConvert(String date) throws ParseException, DatatypeConfigurationException {
        if(date.equals("dd.MM.yyyy HH:mm:SSS")) {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new SimpleDateFormat("dd.MM.yyyy HH:mm:SSS").parse(date)));
        }else if(date.equals("EEE MMM dd HH:mm:ss z yyyy")){
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ROOT).parse(date)));
        }
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ROOT).parse("Thu Aug 01 00:00:00 MSK 1900")));
        }




    /**
     * Метод для формирования заголовка в soap-запросе для использования wsse и авторизации
     * @param mc - параметр в котором передается контекст формируемого сообщения
     * @return
     */
    public boolean handleMessage(MessageContext mc) {
        SOAPMessageContext smc = (SOAPMessageContext) mc;
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            SOAPMessage message = smc.getMessage();
            try {
                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                SOAPElement security =
                        header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
                SOAPElement usernameToken =
                        security.addChildElement("UsernameToken", "wsse");
                usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
                SOAPElement username =
                        usernameToken.addChildElement("Username", "wsse");
                username.addTextNode(properties.getProperty("soap.username"));
                SOAPElement password =
                        usernameToken.addChildElement("Password", "wsse");
                password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                password.addTextNode(properties.getProperty("soap.password"));
                //Print out the outbound SOAP message to System.out
                message.writeTo(System.out);
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                //This handler does nothing with the response from the Web Service so
                //we just print out the SOAP message.
                SOAPMessage message = smc.getMessage();
                message.writeTo(System.out);
                System.out.println("");
                validateResponse(message, "src/test/resources/wsdl/unifoWS/unifo_1_2_3_4_5_6_7.xsd");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return outboundProperty;
    }

    public Set getHeaders() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    @Override
    public boolean handleFault(MessageContext context) {
        return true;
    }

    public void close(MessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


    /**
     * Метод для проверки xml-файлов по указанной xsd-схеме
     * @param file - параметр в котором передается информация о временном
     * @param xsdPath - параметр в котором передается путь до нужной xsd-схемы в формате строки
     */
    public void validateXMLFileAgainstXSD(File file, String xsdPath){
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(file));
        } catch (org.xml.sax.SAXException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void validateResponse(SOAPMessage message, String xsdPath) {
        StringWriter rsSource = new StringWriter();
        File tmpFileResponse = new File("src/test/resources/wsdl/tmp/tempSOAPRs.xml");

        try {
            TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(message.getSOAPBody().getFirstChild()),
                    new StreamResult(rsSource));
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        } catch (SOAPException e) {
            e.printStackTrace();
        }

        try (Writer writer = new FileWriter(tmpFileResponse)) {
            writer.write(rsSource.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(tmpFileResponse));
        } catch (org.xml.sax.SAXException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
