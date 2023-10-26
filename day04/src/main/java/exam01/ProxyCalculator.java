package exam01;

public class ProxyCalculator implements Calculator { // 프록시 = 핵심기능 대신 수행

    //private Calculator calculator = new ImplCalculator(); // 다형성에 의해 나머지 계산도 같이

    private Calculator calculator;

    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public long factorial(long num) {

        long stime = System.nanoTime(); // 공통 기능

        try {
            long result = calculator.factorial(num); // 틀은 같지만 중요한 연산기능을 대신 수행 // 핵심 기능(대신 수행)

            return result;
        } finally {
            long etime = System.nanoTime(); // 공통 기능
            System.out.printf("걸린시간 : %d%n", etime - stime);
        }
    }
}
