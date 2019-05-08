package my.examples.studymanager.random;

import java.util.Random;

public class RandomCode {

    public String makeRandomCode() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (cnt < 8) { // 원하는 난수의 길이
            int num1 = (int) 48 + (int) (ran.nextDouble() * 74);    //알파벳 대,소문자, 숫자범위의 아스키값발생
            if ((num1 >= 48 && num1 <= 57) || (num1 >= 65 && num1 <= 90) || (num1 >= 97 && num1 <= 122)) // 특수문자 제외
            {
                sb.append((char) num1);    //아스키코드값을 char로 형변환 후 저장
                cnt++;
            }
        }
        return sb.toString();
    }
}

