package sample2;

import org.aspectj.lang.ProceedingJoinPoint;
//JoinPoint 사용
import org.springframework.util.StopWatch;

//어드바이스 : 공통사용 부분
//POJO(Plain Old Java Object) 사용한다
public class LoggingAdvice {
	
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String methodName = joinPoint.getKind();//메서드 이름 구하기
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("LoggingAdvice 부분");
		System.out.println("메서드 호출 전 : "+methodName);
		
		Object obj = joinPoint.proceed();
		System.out.println("메서드 호출 후 : "+methodName);
		sw.stop();
		System.out.println("처리 시간 : "+sw.getTotalTimeMillis()/1000+"초");
		
		return obj;
	}

}
