package exam01;

public class ImplCalculator implements Calculator {

    @Override
    public long factorial(long num) {

            long total = 1;
            for (long i = num; i > 0; i--) { // 5 * 4 * 3 * 2 * 1
                total *= i;
            }
            return total;

    }
}
