package ru.idsys.idbank.gisgmp.UI.generators;
/**
 * Класс генерации объектов
 * при необходимости доработать
 * @author a.mylnikov
 */

import ru.idsys.idbank.gisgmp.UI.model.ChargesRqData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChargeDataGenerator {
    public static void main(String[] args){
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ChargesRqData> charges = generateCharges(count);
        save(charges,file);
    }

    private static void save(List<ChargesRqData> charges, File file) {

    }

    private static List<ChargesRqData> generateCharges(int count) {
        List<ChargesRqData> charges = new ArrayList<>();
        for (int i=0; i < count; i++){
            charges.add(new ChargesRqData()
                    .withDataRequestType(String.format("Неоплаченные предварительные начисления"))
                    .withStartDateTime(String.format("05.03.2019 11:51:00"))
                    .withEndDateTime(String.format("05.03.2019 11:51:00"))
                    .withQtObjInPortion(String.format("120")));
        }
        return charges;
    }
}
