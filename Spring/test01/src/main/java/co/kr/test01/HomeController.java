package co.kr.test01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.*; //HashMap 사용

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession; //MyBatis 사용

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//추가
	@Autowired  //자동ㅇ,로 setter 작업
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//추가
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("name", "kim"); //검색 할 내용
		
		List<HashMap<String, String>> map2 = sqlSession.selectList("sam.selectOne", map1);
																   //"namespace.id"
		model.addAttribute("map2",map2); //home.jsp에 사용 할 데이터
		
		System.out.println(map2.toString());
		
		return "home"; //'뷰' 리턴 hone.jsp
	}
	
}
