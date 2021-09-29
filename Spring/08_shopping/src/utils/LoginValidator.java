package utils;
import logic.User;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
//데이터 유효성 체크 

//user_id, password
public class LoginValidator implements Validator{

	//supports() 는 clazz객체가 Validator로 검증이 가능한지 체크하는 메서드 이다
	@Override
	public boolean supports(Class<?> clazz) {
		 
		return User.class.isAssignableFrom(clazz);
	}

	//validate()는 검증할 오브젝트를 실질적으로 체크하는 부분이다 
	@Override
	public void validate(Object obj, Errors errors) {
		 User user=(User)obj;
		
		 //user_id가 공백이면 필드오휴 정보를 설정한다 
		 if(!StringUtils.hasLength(user.getUser_id())){
			errors.rejectValue("userId", "error.required"); 
			//msg.properties
			//error.required.userId=유저ID를 입력해 주세요
		 }//if-end
		 
		 
		 //password가 공백이면 필드오류 정보를 설정 한다
		 if(!StringUtils.hasLength(user.getPassword())){
			 errors.rejectValue("pasaword","error.required");
			 //error.required.password=패스워드를 입력해 주세요
		 }//if-end
		 
		 
		 //대상 검증이 클래스(User)자체에 대한 오류 이면 
		 if(errors.hasErrors()){
			 errors.reject("error.input.user");
			 //error.input.user=입력 정보에 문제가 있습니다
		 }//if-end
	}//validate()-end

}//class-end
