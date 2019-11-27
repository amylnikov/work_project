package ru.idsys.idbank.gisgmp.UI.appmanager;


import ru.idsys.idbank.gisgmp.UI.model.ChargesRq;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRqData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * Вспомогательный класс для взаимодействия напрямую с базой
 * @author a.mylnikov
 */

public class DbHelper {

    private final Properties properties;

    /**
     * Конструктор в котором производится инициализация драйвера
     */
    public DbHelper() throws IOException {
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
     * Метод при помощи которого из базы выбираются данные обо всех имеющихся Запросах начислений
     * Данные получаются путем формирования sql-запроса к БД через подключенный драйвер
     * из выборки извлекается информация по каждому полю и помещается в объект типа Charges
     *
     * @return Возвращаются данные всех имеющихся запросов начислений, либо Null
     */
    public ChargesRq getAllChargesRq() {
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
                    "urt.kind,\n" +
                    "urt.start_date,\n" +
                    "urt.end_date,\n" +
                    "urt.\"PAGE_SIZE\", \n" +
                    "uecr.esia_account_id,\n" +
                    "uecr.esia_session_id,\n" +
                    "uecr.esia_session_start,\n" +
                    "uecr.esia_user_type,\n" +
                    "uecr.snils,\n" +
                    "uecr.inn,\n" +
                    "uecr.dul_type,\n" +
                    "uecr.dul_serie,\n" +
                    "uecr.dul_number,\n" +
                    "urs.supplier_bill_id,\n" +
                    "urp.payer_identifier,\n" +
                    "ura.application_id\n" +
                    "from DOCUMENT d\n" +
                    "left join UNIFO_REQUEST ur on ur.id=d.id\n" +
                    "left join UNIFO_REQUEST_TEMPLATE urt on urt.id=d.id\n" +
                    "left join UNIFO_REQUEST_SUPPLIER urs on urs.unifo_data_request_id=d.id\n" +
                    "left join UNIFO_REQUEST_PAYER urp on urp.unifo_data_request_id=d.id\n" +
                    "left join UNIFO_REQUEST_APPLICATION ura on ura.unifo_data_request_id=d.id\n" +
                    "left join UNIFO_EXPORT_CHARGE_REQUEST uecr on uecr.id=d.id\n" +
                    "where\n" +
                    "d.documentclassid = '1000'\n" +
                    "and\n" +
                    "d.metaobjectname = 'UNIFO_EXPORT_CHARGE_REQUEST'\n" +
                    "order by d.id DESC optimize for first rows");
            //int columnsCount = rs.getMetaData().getColumnCount();
            ChargesRq charges = new ChargesRq();

            while (rs.next()) {
                charges.add(new ChargesRqData().withId(rs.getLong("ID"))
                        .withDataRequestType(castValueFromDbIntoUI(rs.getString("KIND")))
                        .withStartDateTime(dateFormat(rs.getString("START_DATE")))
                        .withEndDateTime(dateFormat(rs.getString("END_DATE")))
                        .withQtObjInPortion(rs.getString("PAGE_SIZE"))
                        .withIdAccountEsia(rs.getString("ESIA_ACCOUNT_ID"))
                        .withIdSessionEsia(rs.getString("ESIA_SESSION_ID"))
                        .withDateTimeSessionOpen(dateFormat(rs.getString("ESIA_SESSION_START")))
                        .withUserType(castValueFromDbIntoUI(rs.getString("ESIA_USER_TYPE")))
                        .withSnils(rs.getString("SNILS"))
                        .withInn(rs.getString("INN"))
                        .withDulType(rs.getString("DUL_TYPE"))
                        .withDulSeria(rs.getString("DUL_SERIE"))
                        .withDulNumber(rs.getString("DUL_NUMBER"))
                        .withSupplierBillId(rs.getString("SUPPLIER_BILL_ID"))
                        .withPayerIdentifier(rs.getString("PAYER_IDENTIFIER"))
                        .withApplicationId(rs.getString("APPLICATION_ID")));
            }
            stmt.close();
            conn.close();
            System.out.println(charges);
            return charges;
        } catch (SQLException | ParseException ex) {
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
            return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date));
        }
        return null;
    }

    /**
     * Вспомогательный метод преобразующий полученные данные к виду который используется винтерфейсе
     * в данном случае актуально только для ГИС ГМП, в дальнейшем возможно расширение лья других модулей
     *
     * @param data Параметр в который передаются данные для преобразования
     * @return Возвращается строка с преобразованными данными
     */
    public String castValueFromDbIntoUI(String data) {
        if (data != null) {
            if (data.equals("CHARGE-PRIOR")) {
                return "Неоплаченные предварительные начисления";
            } else if (data.equals("CHARGENOTFULLMATCHED")) {
                return "Не полностью сквитованные начисления";
            } else if (data.equals("PAYMENT")) {
                return "Платежи";
            } else if (data.equals("PAYMENTMAINCHARGE")) {
                return "Платежи по связанным начислениям";
            } else if (data.equals("INCOME")) {
                return "Зачисления";
            } else if (data.equals("CHARGE")) {
                return "Неоплаченные начисления";
            } else if (data.equals("CHARGESTATUS")) {
                return "Начисления и статусы их квитирования с платежами, включая оплаченные";
            } else if (data.equals("QUITTANCE")) {
                return "Результат квитирования";
            } else if (data.equals("ALLQUITTANCE")) {
                return "Все результаты квитирования, включая аннулированные";
            } else if (data.equals("CATALOG")) {
                return "Каталог услуг поставщика";
            } else if (data.equals("CHARGE-PRIOR-NOTFULLMATCHED")) {
                return "Не полностью сквитованные предварительные начисления";
            } else if (data.equals("TEMP-CHARGING")) {
                return "Неоплаченные предварительные начисления, сформированные ГИС ГМП";
            } else if (data.equals("TEMP-CHARGING-NOTFULLMATCHED")) {
                return "Не полностью сквитованные предварительные начисления, сформированные ГИС ГМП";
            } else if (data.equals("PAYMENTMODIFIED")) {
                return "Уточненные платежи запрашивающего АДБ";
            } else if (data.equals("PAYMENTUNMATCHED")) {
                return "Все платежи, которым в системе не поставлена в соответствие ни одна квитанция";
            } else if (data.equals("CHARGE-PRIOR-STATUS")) {
                return "Предварительные начисления и статусы их квитирования";
            } else if (data.equals("TEMP-CHARGING-STATUS")) {
                return "Предварительные начисления, сформированные ГИС ГМП, и статусы их квитирования";
            } else if (data.equals("PAYMENTCANCELLED")) {
                return "Аннулированные платежи";
            } else if (data.equals("MAINCHARGE")) {
                return "Связанные начисления";
            } else if (data.equals("ИП")) {
                return "Индивидуальный предприниматель";
            } else if (data.equals("ФЛ")) {
                return "Физическое лицо";
            }
        }
        return null;
    }


    public int countDocumentsInStatus(String statusid) {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select count(*) from DOCUMENT d where d.documentclassid = '1000' and d.metaobjectname = 'UNIFO_EXPORT_CHARGE_REQUEST' and d.docstatusid = '%s'", statusid));
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
     *
     *
     * @return
     */
    public String currentGMPFormatVersion() {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select bcfg.gisgmp_format_version as \"VERSION\" from BANK_CLIENT_CONFIG  bcfg");
            String version = null;
            while (rs.next()) {
                version = rs.getString("VERSION");
            }
            stmt.close();
            conn.close();
            return version;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Пока не используется
     *
     * @param version
     */
    public void setGMPFormatVersion(String version) {
        Connection conn = null;
        try {
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(properties.getProperty("db.connection"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            if (conn == null) {
                System.err.println("Could not connect to database");
            }
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(String.format("update BANK_CLIENT_CONFIG bcfg set bcfg.gisgmp_format_version='%s'", version));
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
