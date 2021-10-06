package co.kr.TheCoffee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession;
import model.member.MemberDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import co.kr.TheCoffee.service.MailSendService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/adminMenu.do")
	public String adminMenu() {
		//return "/member/insertForm";
		return ".main.admin.adminMenu";
	}
	
	@RequestMapping(value = "/adminMemberList.do", method = RequestMethod.POST)
	public String adminMemberList(Model model) {
		
		List<MemberDto> mdto = sqlSession.selectList("member.selectAll");
		
		//return "/member/insertForm";
		
		model.addAttribute("mdto", mdto);
		
		return ".main.admin.adminMemberList";
	}
	
	@RequestMapping(value = "/adminMemberListPro.do", method = RequestMethod.GET)
	public String testCheck(String id, String isDelete) {
	    System.out.println("id" + id);
	    System.out.println("isDelete" + isDelete);
	    
	    return ".main.admin.adminMemberList";
	}
}