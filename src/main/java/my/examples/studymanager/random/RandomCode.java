package my.examples.studymanager.random;

import java.util.Random;

public class RandomCode {

    public String makeRandomCode() {
        Random ran = new Random();
        String value = "";

        for (int i = 0; i < 8; i++) {     //  원하는 난수의 길이
            int num1 = (int) 48 + (int) (ran.nextDouble() * 74);
            value = value + (char) num1;
        }
        return value;
    }
}

