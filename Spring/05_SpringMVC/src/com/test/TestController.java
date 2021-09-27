package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controller == Action 비지니스 객체 메서드를 호출하고 결과를 받아서, view와 데이터를 리턴

@Controller
public class TestController {

	@RequestMapping("/resultPage.do")
	public ModelAndView helloWorld() {
		String msg = "Hello, World!";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.setViewName("resultPage"); //resultPage.jsp
		
		return mv;
	}
}
