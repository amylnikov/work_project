package ru.idsys.idbank.gisgmp.UI.appmanager;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.TestSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class TestlinkHelper {

    public void testlinkAPIClient() throws MalformedURLException {
        TestLinkAPI client = new TestLinkAPI(new URL("http://192.168.1.216/testlink/lib/api/xmlrpc/v1/xmlrpc.php"),"fac418b5c2f970c90dcae9cb7602454e");

        TestSuite[] ts = client.getFirstLevelTestSuitesForTestProject(1);

        System.out.println("Инфа " + ts[1]);



    }
}
