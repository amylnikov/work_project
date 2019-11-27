package ru.idsys.idbank.gisgmp.WS.tests;

import org.testng.annotations.Test;
import ru.id_sys.schemas.idbank.unifo._2012._1_15.GetChargesErr;
import ru.idsys.idbank.gisgmp.UI.appmanager.DbHelper;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRqData;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.text.ParseException;


public class ExportChargesRqWSTests extends TestBase {

    @Test
    public void testExportChargesRqWS() throws GetChargesErr, DatatypeConfigurationException, ParseException, IOException {
        DbHelper db = new DbHelper();
        String formatVersion =  db.currentGMPFormatVersion();
        ChargesRqData chargeRqData = new ChargesRqData()
                .withDataRequestType("Начисления и статусы их квитирования с платежами, включая оплаченные")
                .withStartDateTime("05.03.2019 11:51:00")
                .withEndDateTime("05.03.2019 11:51:00")
                .withQtObjInPortion("120")
                .withIdAccountEsia("209111001")
                .withIdSessionEsia("332")
                .withDateTimeSessionOpen("01.03.2019 12:51:00")
                .withUserType("Индивидуальный предприниматель")
                .withInn("123456789012")
                .withSnils("10010010011")
                .withDulType("Паспорт гражданина РФ")
                .withDulSeria("1212")
                .withDulNumber("654321")
               // .withSupplierBillId("32117072411021588933")
                .withPayerIdentifier("t4123456789012")
              //  .withApplicationId("123")
                    ;
        app.soup().createChargesRq(chargeRqData,"1", "1", formatVersion);

    }
}
