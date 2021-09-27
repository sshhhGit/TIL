package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Contoller = Action

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		String msg = "Hello, Spring!";
		return new ModelAndView("hello", "msg", msg);
		//						  뷰이름	  JSP에서 사용 할 데이터
	}
}//class-end
	