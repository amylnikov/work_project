package ru.idsys.idbank.fns.innflchk.appmanager;




import ru.idsys.idbank.fns.innflchk.model.InnFLRqData;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * Вспомогательный класс для взаимодействия напрямую с базой
 * @author a.mylnikov
 */

public class RDBHelper {

    private final Properties properties;

    public static Map<String, String> DOMINATOR = new HashMap<>();


    /**
     * Конструктор в котором производится инициализация драйвера
     */
    public RDBHelper() throws IOException {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        properties = new Properties();
        properties.load(new FileReader(new File("src/test/resources/local.properties")));
    }

    /**
     * Метод получения из БД всех имеющихся Запросов проверки ИНН ФЛ
     * Отправляет запрос на языке SQL через драйвер
     * Получет выборку и сохраняет полученные данные
     * @return Возвращат множество объектов Запрос проверки ИНН ФЛ
     * @throws ParseException
     */
    public InnFLRqs getAllInnFlRequests() throws ParseException {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select\n" +
                    "d.id, \n" +
                    "fiptq.person_inn,\n" +
                    "pq.last_name,\n" +
                    "pq.first_name,\n" +
                    "pq.second_name,\n" +
                    "fiptq.dul_doc_id,\n" +
                    "fiptq.doc_name,\n" +
                    "fiptq.dul_serial,\n" +
                    "fiptq.dul_number,\n" +
                    "fiptq.dul_emitent_name,\n" +
                    "fiptq.dul_dept_code,\n" +
                    "fiptq.dul_date,\n" +
                    "d.docstatusid\n" +
                    "from FNS_INN_PERSON_TEST_QUERY fiptq\n" +
                    "join PERSON_QUERY pq on pq.id = fiptq.id\n" +
                    "join document d on d.id = fiptq.id\n" +
                    "where\n" +
                    "d.documentclassid = 1420\n" +
                    "and\n" +
                    "d.metaobjectname = 'FNS_INN_PERSON_TEST_QUERY'\n" +
                    "order by d.id DESC optimize for first rows");
            InnFLRqs requests = new InnFLRqs();
            while (rs.next()) {
                requests.add(new InnFLRqData().withId(rs.getLong("ID"))
                        .withPersonInn(rs.getString("PERSON_INN"))
                        .withLastName(rs.getString("LAST_NAME"))
                        .withFirstName(rs.getString("FIRST_NAME"))
                        .withSecondName(rs.getString("SECOND_NAME"))
                        .withDulDocId(rs.getString("DUL_DOC_ID"))
                        .withDocName(rs.getString("DOC_NAME"))
                        .withDulSerial(rs.getString("DUL_SERIAL"))
                        .withDulNumber(rs.getString("DUL_NUMBER"))
                        .withDulEmitentName(rs.getString("DUL_EMITENT_NAME"))
                        .withDulDeptCode(rs.getString("DUL_DEPT_CODE"))
                        .withDulDate(dateFormat(rs.getString("DUL_DATE")))
                        .withDocStatusId(rs.getString("DOCSTATUSID")));
            }
            stmt.close();
            conn.close();
            //System.out.println(requests);
            return requests;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * Метод преобразования строки с датой и временем в выборке из БД к типу Datetime по шаблону yyyy-MM-dd HH:mm:ss.SSS
     * и последующего преобразования к виду dd.MM.yyyy HH:mm:ss и приведению к типу String
     *
     * @param date Параметр в котором методу передается строка с датой которую необходимо преобразовать
     * @return Возвращается строка с датой и временем преобразованные в нужный формат
     * @throws ParseException Проброс ошибки
     */
    public String dateFormat(String date) throws ParseException {
        if (date != null) {
            return new SimpleDateFormat("dd.MM.yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        }
        return null;
    }

    /**
     * Метод получения количества документов в системе на опреденном статусе
     * Отправляет запрос на языке SQL через драйвер
     * Получет количество отобранных строк
     *
     * @param statusid Параметр в котором передается идентификатор статуса
     *                 1 - Новый
     *                 98 - Ошибка
     *                 152 - Получен ответ
     *                 310 - Запрос выполнен
     *                 800 - Ожидает обработки
     *                 816 - Ошибка отправки
     *                 820 - Отправлен
     *                 Остальные статусы смотреть в зависимости от документооборота
     * @return Возвпащает количество отобранных в соответствии с условием строк
     */
    public int countDocumentsInStatus(String statusid) {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select count(*) from DOCUMENT d where d.documentclassid = '1420' and d.docstatusid = '%s'", statusid));
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("COUNT");
            }
            stmt.close();
            conn.close();
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Метод удаляет из БД все данные в соответствии с имеющимся запросом
     */
    public void deleteAllData() {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            stmt.execute("delete from document d\n" +
                    "where\n" +
                    "d.documentclassid = 1420\n" +
                    "and\n" +
                    "d.metaobjectname = 'FNS_INN_PERSON_TEST_QUERY'");
            stmt.execute("delete from FNS_INN_PERSON_TEST_QUERY");
            stmt.execute("delete from PERSON_QUERY");
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Метод добавляет документ в Систему через БД
     * @param data Параметр для передачи данных которые необходимо вставить
     */
    public void insertRow(InnFLRqData data) {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            stmt.execute("insert into DOCUMENT (DOCUMENTCLASSID, DOCSTATUSID, DOC_DATE, CREATE_DATE, ID, METAOBJECTNAME, PARENT_ID,\n" +
                    "                          DOC_NUMBER, CHANGE_DATE, CONTROL_STATUS_ID, AMOUNT, DESCRIPTION, SLLV_ID, SLC_ID, SLG_ID,\n" +
                    "                          SUSER_ID, SUSER_ID_CHANGE, BARCODE)\n" +
                    " values (1420, 1, null, (select current_timestamp\n" +
                    "                            from RDB$DATABASE), gen_id(SEQ_DOCUMENT, 1), 'FNS_INN_PERSON_TEST_QUERY', null, null, (select current_timestamp\n" +
                    "                                                                                                        from RDB$DATABASE),\n" +
                    "                                                                                                        null, null,\n" +
                    "                                                                                                        null, null,\n" +
                    "                                                                                                        null, null,\n" +
                    "                                                                                                        8992, 8992,\n" +
                    "                                                                                                        null)");

            ResultSet rs = stmt.executeQuery("select max(d.id) as \"ID\" from DOCUMENT d " +
                                                            "where d.documentclassid = '1420' " +
                                                            "and d.metaobjectname = 'FNS_INN_PERSON_TEST_QUERY' " +
                                                            "and d.docstatusid = 1");
            String id = "";
            while (rs.next()) {
                id = rs.getString("ID");
            }
            stmt.execute("insert into FNS_INN_PERSON_TEST_QUERY\n" +
                    "(DUL_DOC_ID, PERSON_INN, DUL_SERIAL, DUL_NUMBER, DUL_DATE, DUL_DEPT_CODE, DUL_EMITENT_NAME, ANSWER_TYPE, ID, DOC_NAME)\n" +
                    "values\n" +
                    "(" + data.getDulDocId() +
                    ",'" + data.getPersonInn() +
                    "','" + data.getDulSerial() +
                    "','" + data.getDulNumber() +
                    "','" + data.getDulDate() +
                    "','" + data.getDulDeptCode() +
                    "','" + data.getDulEmitentName() +
                    "',null" +
                    "," + id +
                    ",'" + data.getDocName() +
                    "')");

            stmt.execute("insert into PERSON_QUERY\n" +
                    "(ID, LAST_NAME, FIRST_NAME, SECOND_NAME, ERROR_DESCRIPTION, RESULT_MESSAGE, ERROR_CODE, ANSWER_DATE_TIME, SENT_TIME)\n" +
                    "values\n" +
                    "('" + id +
                    "','" + data.getLastName() +
                    "','" + data.getFirstName() +
                    "','" + data.getSecondName() +
                    "',null" +
                    ",null" +
                    ",null" +
                    ",null" +
                    ",null" +
                    ")");

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    /**
     * Метод добавляет документ в Систему через БД c рандомными данными
     * @param data Параметр для передачи данных которые необходимо вставить
     */
    public void insertRowWithRndData(InnFLRqData data) {
        String[] status = {"1", "98", "152", "310", "816", "820"};
        Integer rnd = new Random().nextInt(6);
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            stmt.execute("insert into DOCUMENT (DOCUMENTCLASSID, DOCSTATUSID, DOC_DATE, CREATE_DATE, ID, METAOBJECTNAME, PARENT_ID,\n" +
                    "                          DOC_NUMBER, CHANGE_DATE, CONTROL_STATUS_ID, AMOUNT, DESCRIPTION, SLLV_ID, SLC_ID, SLG_ID,\n" +
                    "                          SUSER_ID, SUSER_ID_CHANGE, BARCODE)\n" +
                    " values (1420,\n" + status[rnd] + ", null, (select current_timestamp\n" +
                    "                            from RDB$DATABASE) +" + rnd + ", gen_id(SEQ_DOCUMENT, 1), 'FNS_INN_PERSON_TEST_QUERY', null, null, (select current_timestamp\n" +
                    "                                                                                                        from RDB$DATABASE),\n" +
                    "                                                                                                        null, null,\n" +
                    "                                                                                                        null, null,\n" +
                    "                                                                                                        null, null,\n" +
                    "                                                                                                        8992, 8992,\n" +
                    "                                                                                                        null)");

            ResultSet rs = stmt.executeQuery("select max(d.id) as \"ID\" from DOCUMENT d " +
                    "where d.documentclassid = '1420' " +
                    "and d.metaobjectname = 'FNS_INN_PERSON_TEST_QUERY' ");
            String id = "";
            while (rs.next()) {
                id = rs.getString("ID");
            }
            stmt.execute("insert into FNS_INN_PERSON_TEST_QUERY\n" +
                    "(DUL_DOC_ID, PERSON_INN, DUL_SERIAL, DUL_NUMBER, DUL_DATE, DUL_DEPT_CODE, DUL_EMITENT_NAME, ANSWER_TYPE, ID, DOC_NAME)\n" +
                    "values\n" +
                    "(" + data.getDulDocId() +
                    ",'" + "01234567898" + rnd +
                    "','" + data.getDulSerial() +
                    "','" + "88888" + rnd +
                    "','" + data.getDulDate() +
                    "','" + data.getDulDeptCode() +
                    "','" + data.getDulEmitentName() +
                    "',null" +
                    "," + id +
                    ",'" + data.getDocName() +
                    "')");

            stmt.execute("insert into PERSON_QUERY\n" +
                    "(ID, LAST_NAME, FIRST_NAME, SECOND_NAME, ERROR_DESCRIPTION, RESULT_MESSAGE, ERROR_CODE, ANSWER_DATE_TIME, SENT_TIME)\n" +
                    "values\n" +
                    "('" + id +
                    "','" + data.getLastName() + rnd +
                    "','" + data.getFirstName() +
                    "','" + data.getSecondName() +
                    "',null" +
                    ",null" +
                    ",null" +
                    ",(select current_timestamp from RDB$DATABASE) +" + rnd +
                    ",null" +
                    ")");

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    /**
     * Метод отбирает записи с одинаковыми значениями,
     * которых больше всего, затем из этих записей отбирает одну
     * и сохраняет информацию в статическую переменную,
     * для последующего использования в тестах
     * @return
     */
    public void dominantData() {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select first 1 docstatusid, \"n\" from\n" +
                    "(select d.docstatusid, count(*) as \"n\" from DOCUMENT d\n" +
                    "where d.documentclassid = '1420'\n" +
                    "group by 1)\n" +
                    "where \"n\" = (select max(\"n\") from\n" +
                    "(select d.docstatusid, count(*) as \"n\" from DOCUMENT d\n" +
                    "where d.documentclassid = '1420'\n" +
                    "group by 1))"));
            String status = "";
            while (rs.next()) {
                status = rs.getString("docstatusid");
                DOMINATOR.put("STATUS", rs.getString("docstatusid"));
                DOMINATOR.put("COUNT", rs.getString("n"));
            }

            ResultSet rs1 = stmt.executeQuery(String.format(
                    "select d.create_date, pq.answer_date_time, pq.last_name, fiptq.person_inn, fiptq.dul_number\n" +
                    "from document d\n" +
                    "join FNS_INN_PERSON_TEST_QUERY fiptq on fiptq.id = d.id\n" +
                    "join PERSON_QUERY pq on pq.id = d.id\n" +
                    "where d.id = (select first 1 d.id from document d where d.docstatusid =" + status + ")"));
            while (rs1.next()) {
                DOMINATOR.put("ANSDATE", rs1.getString("ANSWER_DATE_TIME"));
                DOMINATOR.put("CREATEDATE", rs1.getString("CREATE_DATE"));
                DOMINATOR.put("LASTNAME", rs1.getString("LAST_NAME"));
                DOMINATOR.put("PERSONINN", rs1.getString("PERSON_INN"));
                DOMINATOR.put("DULNUMBER", rs1.getString("DUL_NUMBER"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
