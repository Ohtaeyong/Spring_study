package exam02.aopex;

public class RecCalculator implements Calculator {

    @Override
    public long factorial(long num) { // 재귀 방식

            if (num < 1) {
                return 1;
            }
            return num * factorial(num - 1);
    }
}
