package colecoes.teste;

import colecoes.dominio.SmartPhone;

import java.util.ArrayList;
import java.util.List;

public class SmartPhoneListTest01 {

    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone("1ABC1", "iPhone");
        SmartPhone s2 = new SmartPhone("2222", "Pixel");
        SmartPhone s3 = new SmartPhone("3333", "Samsung");
        List<SmartPhone> smartPhones = new ArrayList<>();
        smartPhones.add(s1);
        smartPhones.add(s2);
        smartPhones.add(s3);
        for (SmartPhone smartPhone: smartPhones) {
            System.out.println(smartPhone);
        }

        SmartPhone s4 = new SmartPhone("2222", "Pixel");
        System.out.println(smartPhones.contains(s4));
        int indexSmartPhone = smartPhones.indexOf(s4);
        System.out.println(smartPhones.get(indexSmartPhone));
    }
}
