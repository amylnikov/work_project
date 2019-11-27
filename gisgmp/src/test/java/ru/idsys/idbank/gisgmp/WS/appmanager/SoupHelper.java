package ru.idsys.idbank.gisgmp.WS.appmanager;


import ru.id_sys.schemas.idbank.unifo._2012._1.ExportChargesResponseEx;
import ru.id_sys.schemas.idbank.unifo._2012._1.GetChargesRq;
import ru.id_sys.schemas.idbank.unifo._2012._1.GetChargesRs;

import ru.id_sys.schemas.idbank.unifo._2012._1_15.GetChargesErr;
import ru.id_sys.schemas.idbank.unifo._2012._1_15.IDBankUnifoPortType;
import ru.id_sys.schemas.idbank.unifo._2012._1_15.IDBankUnifoService;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRqData;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRs;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRsData;
import ru.roskazna.xsd.common.EsiaUserInfoType;
import ru.roskazna.xsd.pgu_datarequest.DataRequest;
import ru.roskazna.xsd.postblock.PostBlock;

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
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.*;
import java.math.BigInteger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс помошник для формирования и отправки запросов к сервису через soap протокол
 * Также в нем происходит обработка полученных ответов и различные проверки
 * @author a.mylnikov
 */
public class SoupHelper implements SOAPHandler {
    private final Properties properties;
    private static IDBankUnifoPortType servicePort;

    public SoupHelper() throws IOException {
        properties = new Properties();
        properties.load(new FileReader(new File("src/test/resources/local.properties")));
    }

    /**
     * Метод заполнения данными запроса наислений через сервис unifo.
     * При использовани этого метода необходимо учитывать способ отправки запроса - напрямую или через МС
     * от этого будет зависить формат передавемых идентификаторов
     * @param chargeRqData - параметр в который передаются тестовые данные запроса
     * @param chargesMode - параметр в который необходимо передавать Режим предоставления информации о начислениях
     *                    1 - Формирование запроса в формате платежной системы
     *                    3 - Формирование запроса в формате ЭПД.
     * @param systemMode - параметр в который передаются Идентификатор платежной системы
     *                   1 - ГИС ГМП
     *                   2 - ИС РНиП
     *                   ID - для Менеджера Связок
     * @param format - параметр в который передается текущий формат взаимодействия с сервисом
     * @throws GetChargesErr
     * @throws DatatypeConfigurationException
     * @throws ParseException
     * @throws IOException
     */
    public void createChargesRq(ChargesRqData chargeRqData, String chargesMode, String systemMode, String format) throws GetChargesErr, DatatypeConfigurationException, ParseException, IOException {
        int randomNumber = (int) (Math.random() * 100000);

        GetChargesRq getChargesRq = new GetChargesRq();
        getChargesRq.setMsgID(String.format("%s", randomNumber-3));
        getChargesRq.setMsgTimestamp(dateGregorianConvert(Calendar.getInstance().getTime().toString()));
        getChargesRq.setVersion("1.4");
        getChargesRq.setChargesMode(chargesMode);
        getChargesRq.setDstSystemID(systemMode);
        getChargesRq.setDataRequest(new DataRequest() {{    // Блок <DataRequest>
            setKind(kindDataConverter(chargeRqData.getDataRequestType()));
            setPostBlock(new PostBlock() {{                 // Блок <PostBlock>
                setID(String.format("%s", randomNumber));
                setSenderIdentifier("000000");
            }});
            setPaging(new Paging() {{                       // Блок <Paging>
                setPageNumber(BigInteger.valueOf(1));
                setPageSize(BigInteger.valueOf(Long.parseLong(chargeRqData.getQtObjInPortion())));
            }});
            if (format.equals("2_1") || format.equals("2_0")) { // Условие проверки формата от которого зависит будем добавлять или не блок для ЕСИА
                setEsiaUserInfo(new EsiaUserInfoType() {{   // Блок <EsiaUserInfo>
                    if (chargeRqData.getUserType().equals("Физическое лицо")) { // Проверяем тип лица, для ИП и ФЛ заполняются разные блоки
                        setPerson(new EsiaUserInfoType.Person() {{  // Блок <Person>
                            setSnils(chargeRqData.getSnils());
                            setPersonINN(chargeRqData.getInn());
                            setDocumentIdentity(new DocumentIdentity() {{   // Блок  <DocumentIdentity>
                                setCode(dulTypeConverter(chargeRqData.getDulType()));
                                setSeries(chargeRqData.getDulSeria());
                                setNumber(chargeRqData.getDulNumber());
                            }});
                        }});
                    } else if (chargeRqData.getUserType().equals("Индивидуальный предприниматель") && !chargeRqData.getInn().equals(null)) {    // Проверяем тип лица, для ИП и ФЛ заполняются разные блоки
                        setIndividualBussnes(new EsiaUserInfoType.IndividualBussnes() {{    // Блок <IndividualBussnes>
                            setPersonINN(chargeRqData.getInn());
                        }});
                    }
                    setUserId(BigInteger.valueOf(Long.parseLong(chargeRqData.getIdAccountEsia())));
                    setSessionIndex(chargeRqData.getIdSessionEsia());
                    setSessionDate(dateGregorianConvert(chargeRqData.getDateTimeSessionOpen()));
                }});
            }
            setPayers(new DataRequest.Payers() {{   // Блок <Payers>
                if (chargeRqData.getPayerIdentifier() != null && chargeRqData.getSupplierBillId() == null && chargeRqData.getApplicationId() == null) { // Проверяем какой из идентификаторов заполнен в тестовых данных
                    getPayerIdentifierOrPayerIdentificationOrIdentificationSet().add(chargeRqData.getPayerIdentifier());
                } else if (chargeRqData.getSupplierBillId() != null && chargeRqData.getPayerIdentifier() == null && chargeRqData.getApplicationId() == null) {  // Проверяем какой из идентификаторов заполнен в тестовых данных
                    getPayerIdentifierOrPayerIdentificationOrIdentificationSet().add(chargeRqData.getSupplierBillId());
                } else if (chargeRqData.getApplicationId() != null && chargeRqData.getPayerIdentifier() == null && chargeRqData.getSupplierBillId() == null) {  // Проверяем какой из идентификаторов заполнен в тестовых данных
                    getPayerIdentifierOrPayerIdentificationOrIdentificationSet().add(chargeRqData.getApplicationId());
                } else {    // Если ни одно из условй не выполняется, то используется значение по умолчанию
                    getPayerIdentifierOrPayerIdentificationOrIdentificationSet().add("2100000000123456789012643");
                }
            }});
        }});
        GetChargesRs getChargesRs = getUnifoServicePort().getCharges(getChargesRq);
        //getChargesRs.getExportChargesResponse();
        getChargesRs.getErrors();

        chekChargesRs(getChargesRs);
    }


    private void chekChargesRs(GetChargesRs getChargesRs) throws IOException {
        if (getChargesRs.getExportChargesResponse()!= null) {

            Iterator<ExportChargesResponseEx.Charges.ChargeInfo> chargeInfo = getChargesRs.getExportChargesResponse().getCharges().getChargeInfo().iterator();
            File file = new File("src/test/resources/wsdl/tmp/tempDecodeChargeData.xml");
            ChargesRs chargeRsInfo = new ChargesRs();
            while (chargeInfo.hasNext()) {
                ExportChargesResponseEx.Charges.ChargeInfo nxtChargeInfo = chargeInfo.next();
                chargeRsInfo.add(new ChargesRsData()
                        .withAmountToPay(String.valueOf(nxtChargeInfo.getAmountToPay()))
                        .withIsRevoked(String.valueOf(nxtChargeInfo.getIsRevoked().isValue()))
                        .withQuittancePaymentStatus(nxtChargeInfo.getQuittanceWithPaymentStatus())
                );

                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                bout.write(nxtChargeInfo.getChargeData());
                String chargeData = new String(bout.toByteArray(), "UTF-8");

                try (Writer writer = new FileWriter(file)) {
                    writer.write(chargeData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                validateXMLFileAgainstXSD(file, "src/test/resources/wsdl/xsdGMP/entity/document/Charge.xsd");
            }
        } else if(getChargesRs.getErrors() != null){

        }
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
     * Вспомогательный метод для формирования тела soap-запроса и отправки его на указанный адрес
     * @return
     */
    private synchronized IDBankUnifoPortType getUnifoServicePort() {
        if (servicePort == null) {
            IDBankUnifoService service = new IDBankUnifoService();
            service.setHandlerResolver(new HandlerResolver() {
                public List getHandlerChain(PortInfo portInfo) {
                    List handlerChain = new ArrayList();
                    SoupHelper hh = null;
                    try {
                        hh = new SoupHelper();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    handlerChain.add(hh);
                    return handlerChain;
                }
            });
            final BindingProvider provider = (BindingProvider) service.getIDBankUnifoPort();
            provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, properties.getProperty("soap.endpointURL"));
            servicePort = (IDBankUnifoPortType) provider;
        }
        return servicePort;
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
