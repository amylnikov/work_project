package ru.idsys.idbank.fns.innflchk.appmanager;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestCaseStepResult;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Вспомогательный класс взаимодействия с Тестлинком
 * @author a.mylnikov
 */
public class TestlinkHelper {

    public TestLinkAPI client;
    private final Properties properties;

    public TestlinkHelper() throws IOException {
        properties = new Properties();
        properties.load(new FileReader(new File("src/test/resources/local.properties")));
        client = new TestLinkAPI(new URL(properties.getProperty("testlink.apiURL")),properties.getProperty("testlink.apiKey"));
    }

    /**
     * Метод отправляет в Тестлинк результаты прогона тестов,
     * устанавливает результаты прогона тестов в тест-плане
     * @param statuses Параметр в котором передаются статусы проверки кейсов
     * @param testPlanId Параметр в котором передается идентификатор тест-плана
     * @param testCaseId Параметр в котором передается идентификатор тест-кейса
     */
    public void putTestResults(ArrayList<Integer> statuses, ArrayList<String> exeptions, Integer testPlanId, Integer testCaseId) {
        Build lastBuild = client.getLatestBuildForTestPlan(testPlanId);
        String buildName = lastBuild.getName();
        Integer buildId =  lastBuild.getId();
        List<TestCaseStepResult> stepResults = new LinkedList<TestCaseStepResult>();
        ExecutionStatus suiteExecStatus = ExecutionStatus.PASSED;
        Integer stepNumber = 0;
        String[] errors = exeptions.toArray(new String[0]);

        for(Integer status : statuses){
            ExecutionStatus es;
            if(status.equals(1)){
                es = ExecutionStatus.PASSED;
            }else{
                es = ExecutionStatus.FAILED;
                suiteExecStatus = ExecutionStatus.FAILED;
            }
            TestCaseStepResult tcsr = new TestCaseStepResult(++stepNumber,
                                                                es,
                                                errors[stepNumber - 1],
                                                        true,
                                            ExecutionType.AUTOMATED);
            stepResults.add(tcsr);
        }


       client.setTestCaseExecutionResult(
               testCaseId,
               null,
               testPlanId,
               suiteExecStatus,
               stepResults,
               buildId,
               buildName,
               "",
               0,
               false,
               null,
               null,
               null,
               null,
               false,
               "apiuser",
               null);


    }

    /**
     * Метод проверяет если ли сборки доступные для прогона тестов
     * @param testPlanId Параметр в котором передается идентификатор тест-плана
     * @return Возавращает true или false
     */
    public boolean checkAvailableBuilds(Integer testPlanId) {
        Build lastBuild = client.getLatestBuildForTestPlan(testPlanId);
        Integer buildId = lastBuild.getId();
        TestCase[] testCase;
        boolean canExecute = false;
        if (lastBuild.getIsOpen().equals(1)) {
            testCase = client.getTestCasesForTestPlan(
                    testPlanId,
                    null,
                    buildId,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
            for (int i = 0; i < testCase.length; i++) {
                if (testCase[i].getExecutionStatus().equals(ExecutionStatus.NOT_RUN)) {
                    canExecute = true;
                }
            }
        }
        return canExecute;
    }
}
