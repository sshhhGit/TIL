package sample3;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAdvice {
	
	@Around("execution(public * sample3.*.sayHello())")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getKind(); //메서드 이름 얻기
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("LoggingAdvice");
		System.out.println("메소드 호출 전 : " + methodName);
		
		Object obj = joinPoint.proceed(); //target(비지니스 로직) 메서드 호출
		System.out.println("메소드 호출 후 : " + methodName);
		sw.stop();
		
		return obj;
	}
	//어노테이션 
	// @Aspect => Advice클래스에 마크를 부여하는 어노테이션
	// @Around => AroundAdvice 메서드에 부여하는 어노테이션
	// @Before => BeforeAdvice 메서드에 부여하는 어노테이션 
	// @After  => AfterAdvice 메서드에 부여하는 어노테이션
	// @AfterReturning => AfterReturning메서드에 부여하는 어노테이션
	// @AfterThrowing => AfterThrowingAdvice메서드에 부여하는 어노테이션 

	// Aspect : 공통 사용 부분의 객체(클래스)
	// Advice : Aspect의해 실행되는 기능 ( 메서드 )
	// pointcut : 적용 위치 ( 클래스냐 , 메서드냐 )
	// advisor : point + advice 합친것 
	// joinpoint : Aspect 적용될 대상 지점 ( 적용지점 )

}
