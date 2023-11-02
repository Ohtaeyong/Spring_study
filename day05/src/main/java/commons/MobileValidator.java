package commons;

public interface MobileValidator {
    default boolean checkMobile(String num) {

        /*
        010 0000 0000
        011 000 0000
        016 000 0000

        01000000000 / 010 0000 0000 / 010-0000-0000 / 010.0000.0000
        */
        String mobile = num.replaceAll("\\D", ""); //소문자d는 숫자 대문자D는 숫자가 아닌것
        String pattern = "^01[016]\\d{3,4}\\d{4}$";

        return mobile.matches(pattern);
    }
}
