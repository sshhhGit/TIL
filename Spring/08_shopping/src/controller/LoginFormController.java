package controller;
import logic.Shop;
import logic.User;//DTO

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러=Action가 하는 일 dao메서드 호출하고 , 결과를 받고 , 뷰를 리턴한다
@Controller
public class LoginFormController {
	
	private Shop shopService;
	private Validator loginValidator;
	
	//setter메서드 
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	//setter메서드 
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	//login뷰이름을 반환 ,GET요청이 들어오면 
	//로그인 화면 표시(WEB-INF/jsp/login.jsp)
	//login.html요청이 들어오면 처리되어지는 메서드 이다 ***
	@RequestMapping(method=RequestMethod.GET)
	public String  toLoginForm(){
		return "login";//login.jsp뷰를 리턴 
	}
	
	//<form:form modelAttribute="user">  입력 화면
	@ModelAttribute
	public User setUpForm(){
		return new User();//모델빈(DTO)을 생성해서 반환한다 
	}
	
	//로그인 했을때
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult){
		
		//BindingResult인스턴스는 거증 결과가 저장되 것이다 
		this.loginValidator.validate(user, bindingResult);//입력항목 겅증
		
		//검증 대상은 User 인스턴스와 
		//검증 결과를 저장할 BindingResult 인스턴스를 건네준다 
		ModelAndView mv=new ModelAndView();
		if(bindingResult.hasErrors()){//에러가 있으면 로그인 화면으로 되돌린다 
			mv.getModel().putAll(bindingResult.getModel());
			return mv;
		}
		
		// 로그인 화면에서 입력된값을 지우지 않고 표시하기 위해
		// bindingResult 인스턴스에서 모델를 꺼내어
		// ModelAndView 인스턴스에 저장한다 
		// return mv하면 로그인 화면으로 되돌아 간다
		//
		try{
			//유저 정보 검색
			User loginUser=
					this.shopService.getUserByIdandPwd(user.getUser_id(), user.getPassword());
		
			//유저가 있을때
			mv.setViewName("loginSuccess");;//뷰이름 loginSuccess.jsp
			mv.addObject("loginUser",loginUser);//뷰에서 사용할 데이터
			return mv;
			
			
		}catch(EmptyResultDataAccessException e){
			//유저가 없을 때
			
			bindingResult.reject("error.login.user");//에러 메시지 설정
			mv.getModel().putAll(bindingResult.getModel());//모델를 리턴 한다 
			return mv;
		}//catch-end
		
	}//onSubmit()-end
	
}//class-end
