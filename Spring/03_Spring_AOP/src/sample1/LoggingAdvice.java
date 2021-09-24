package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer;
import org.springframework.aop.framework.ProxyFactoryBean;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = invocation.getMethod().getName(); //target메서드 이름
		
		StopWatch sw = new StopWatch(); //단수난 스톱워치 기능을 제곡하는 유틸리티 클래스
		
		sw.start(methodName);
		
		System.out.println("공통사용 부분, 로깅부분");
		System.out.println("메서드 : " + methodName + "호출 전");
		
		Object obj = invocation.proceed();
		
		sw.stop();
		
		System.out.println("메서드 : " + methodName + "호출 후");
		System.out.println("처리시간 : " + sw.getTotalTimeMillis()/1000 + "초");
		return obj;
	}

	
}
