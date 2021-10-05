package co.kr.test05_member_board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession;
import model.member.MemberDto;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/main.do")
	public String insertForm( ) {
		return "/member/insertForm";
	}
	
	//id중복 체크
	@RequestMapping(value = "idCheck.do", method = RequestMethod.POST)
	public String idCheck(String id, Model model) {
		int check = -1; //변수
		MemberDto mDto = sqlSession.selectOne("member.selectOne", id);
		if(mDto==null) {
			check = 1; //사용가능
		}
		
		model.addAttribute("check", check);
		
		return "/member/idCheck"; //idCheck.jsp 뷰 리턴
	}
	
	//회원가입
	@RequestMapping(value = "insertPro.do", method = RequestMethod.POST)
	public String memberInsert(@ModelAttribute("memberDto") MemberDto memberDto, HttpServletRequest request) {
		
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		email = email+email2;
		memberDto.setEmail(email);
		
		String tel = request.getParameter("tel");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		tel = tel+tel2+tel3;
		memberDto.setTel(tel);
		
		sqlSession.insert("member.insertMember", memberDto); //회원가입
		
		return "/member/loginForm"; //뷰 리턴, loginForm.jsp
		
	}
	
	//로그인 폼
	@RequestMapping("loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
		
	//로그인
	@RequestMapping(value = "loginPro.do", method = RequestMethod.POST)
	public String loginPro(String id, String pw, Model model) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		
		MemberDto mdto = sqlSession.selectOne("member.selectLogin", map);
		
		if(mdto==null) {
			model.addAttribute("msg", "로그인 실패");
			return "/member/loginForm"; //뷰 리턴 loginForm.jsp
		}
		
		//정상적으로 로그인 된 경우
		model.addAttribute("mdto", mdto);
		return "/member/loginSuccess"; //뷰 리턴, loginSuccess.jsp
	}
		
	//로그아웃
	@RequestMapping("/logOut.do")
	public String logOut() {
		return "/member/logOut";
	}
	
	//회원 정보 수정 폼
	@RequestMapping(value="editForm.do", method = RequestMethod.POST)
	public String editForm(String id, Model model) {
		MemberDto mdto = sqlSession.selectOne("member.selectOne", id);
		
		String emailTemp = mdto.getEmail();
		int idx = emailTemp.indexOf("@");
		String email = emailTemp.substring(0, idx);
		String email2 = emailTemp.substring(idx+1);
		
		String telTemp = mdto.getTel();
		String tel = telTemp.substring(0,3);
		String tel2 = telTemp.substring(3,7);
		String tel3 = telTemp.substring(7);
		
		model.addAttribute("email", email);
		model.addAttribute("email2", email2);
		model.addAttribute("tel", tel);
		model.addAttribute("tel2", tel2);
		model.addAttribute("tel3", tel3);
		model.addAttribute("mdto", mdto);
		return "/member/editForm";
	}
	
	//DB회원 정보 수정
	@RequestMapping(value = "/editPro.do", method = RequestMethod.POST)
	public String editPro(@ModelAttribute("memberDto") MemberDto memberDto, HttpServletRequest request) {
		
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		email=email+email2;
		memberDto.setEmail(email);
		
		String tel = request.getParameter("tel");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		tel=tel+tel2+tel3;
		memberDto.setTel(tel);
		
		sqlSession.update("member.memberUpdate", memberDto);
		
		return "main";
	}
	
	//회원탈퇴
	@RequestMapping("deleteMember.do")
	public String deletePro(String id) {
		sqlSession.delete("member.memberDelete", id);
		
		return "main";
	}
	
}
	
	

