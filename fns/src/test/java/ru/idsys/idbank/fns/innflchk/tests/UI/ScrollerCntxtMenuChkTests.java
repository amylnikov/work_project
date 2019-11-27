package ru.idsys.idbank.fns.innflchk.tests.UI;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqData;
import ru.idsys.idbank.fns.innflchk.tests.TestBase;

import java.text.ParseException;
import java.util.ArrayList;

public class ScrollerCntxtMenuChkTests extends TestBase {

    private ArrayList<Integer> runStatus = new ArrayList<Integer>();
    private ArrayList<String> exeption = new ArrayList<String>();


    @BeforeTest
    /**
     * Проверка наличия актуальной для тестирования сборки
     */
    public void checkNewBuildForTesting(){
        if(!app.testLink().checkAvailableBuilds(5032)) {
            app.stop();
            System.out.println("Нет новых сборок для прогона.");
            System.exit(-1);
        }
    }

    @BeforeMethod
    /**
     * Предварительная подготовка среды для выполнения теста
     *
     */
    public void ensurePreconditions() throws ParseException {
        if(app.db().getAllInnFlRequests().size() >= 20){
            app.db().deleteAllData();
        }
        for(int i = 1; i < 21; i++){
            InnFLRqData preData = new InnFLRqData().withPersonInn("012345678987")
                    .withLastName("Предварительно").withFirstName("Заполненный" + i).withSecondName("Чувак" + i)
                    .withDulDocId("21").withDocName("ПасРФ").withDulSerial("9999").withDulNumber("888888").withDulDate("05.03.1917")
                    .withDulEmitentName("РОВД по гроду Тамбову").withDulDeptCode("800-008");
            app.db().insertRowWithRndData(preData);
            //if(i==2){
            //    app.db().insertRow(preData);
            //}
        }
    }


    @BeforeMethod(enabled = true)
    /**
     * Метод проверки не закрытого всплывающего окна перед тестами
     */
    public void escapePopupContent() throws InterruptedException {
        if(app.innFlRequest().checkPopupContent()){
            app.innFlRequest().clickFormButton("OK");
        }
    }




    @AfterMethod
    /**
     * После каждого теста получает статус прогона теста
     */
    public void getTestsRunStatus(ITestResult result){
        runStatus.add(result.getStatus());
        if(result.getThrowable() != null) {
            exeption.add(result.getThrowable().toString());
        }else{
            exeption.add("");
        }
    }

    @AfterTest()
    /**
     * После всех тестов отмечает в Тестлинке статус по каждому пройденному кейсу и по сьюту вцелом
     */
    public void closeCasesInTestlink() {
        app.testLink().putTestResults(runStatus, exeption, 5032, 29);
    }

}
