package exam02.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect
public class ProxyCalculator { // AOP를 이용

//    @Pointcut("execution(* exam02.aopex..*(..))") // aopex에 있는 모든 메서드를 범위로 // .이 두개이면 하위폴더
//    public void publicTarget() {}

    @Around("publicTarget()") // 정해져 있는 형식
    //@Around("execution(* exam02.aopex..*(..))") // @Pointcut없이 @Around만 정의해도 상관X
    //@Around("CommonPointcut.publicTarget()") // 같은 패키지일 때 앞의 exam02.config. 제거 무방 // CommonPointcut클래스 만들었을시
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable { // 반환값은 Object로 정해져 있음(범용적) // 매개변수도 정해져있음

        long stime = System.nanoTime(); // 공통기능은 여기에

//        Signature sig = joinPoint.getSignature();
//        System.out.println(sig.toLongString()); // 정보 확인

//        Object[] args = joinPoint.getArgs();
//        long num = (long)args[0];
//        System.out.println(num);

        try {
            Object result = joinPoint.proceed(); // factorial(..) - 핵심 기능(대신 수행)

            return result;
        } finally {
            long etime = System.nanoTime();
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}
