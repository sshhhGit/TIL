package com.example.member.controller;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;
 
@Controller
public class MemberController {

	@Resource(name="com.example.member.service.MemberService")
	MemberService memberService;

	@RequestMapping("insertForm.do")
	public String insertForm() {
		return "/member/insertForm";//뷰리턴
	}

  //id중복 체크
  @RequestMapping(value="confirmID.do", method=RequestMethod.POST)
  public String idCheck(String id,Model model) throws Exception{
	  
	  //System.out.println("id:"+id);
 	  int check=-1;
	  
	  MemberDTO mdto=memberService.getMember(id);
	  
	  if(mdto==null) {
		  check=1;//사용 가능한 ID
	  }else {
		  check=-1;//사용중인ID
	  }
	  
	  model.addAttribute("check",check);
	  return "member/confirmID";//qb 리턴  confirmID.jsp
  }
  
  //회원가입
  @RequestMapping(value="insertPro.do",method=RequestMethod.POST)
  public String insertPro(@ModelAttribute("memberDTO") MemberDTO memberDTO,
		  HttpServletRequest request) throws Exception{
	 
	  String email1=request.getParameter("email1");
	  String email2=request.getParameter("email2");
	  String email=email1+email2;
	  
	  memberDTO.setEmail(email);
	  
	  
	  String tel1=request.getParameter("tel1");
	  String tel2=request.getParameter("tel2");
	  String tel3=request.getParameter("tel3");
	  
	  String tel=tel1+tel2+tel3;
	  
	  memberDTO.setTel(tel);
	  
	  //sqlSession.insert("member.insertMember",memberDTO);//ȸ������
	  memberService.insertMember(memberDTO);
	  
	  return "main";//뷰 리턴
	  //return "member/login";
	  
  }
  
  @RequestMapping("loginForm.do")
  public String loginForm() {
	  return "member/loginForm";//뷰리턴
  }
  
  
  //로그인
	@RequestMapping(value="loginPro.do", method=RequestMethod.POST)
	public String loginPro(String id,String pw, Model model) throws Exception{

		HashMap<String,String> map=new HashMap<String,String>();
		map.put("id", id);
		map.put("pw", pw);
		
		MemberDTO mdto=memberService.loginPro(map);
		
		if(mdto==null) {
			model.addAttribute("msg","ID,PW입력 오류");
			return "/member/loginForm";//뷰 리턴
		}//if-end
		
		model.addAttribute("mdto",mdto);
		
		return "/member/loginSuccess";//뷰 리턴
	}//method-end


  
  @RequestMapping("logOut.do")
  public String logOut() {
	  return "/member/logOut";//뷰리턴
  }
  
  
  //내정보 수정 폼
  @RequestMapping(value="memUpdateForm.do",method=RequestMethod.POST)
  public String updateForm(String id,Model model) throws Exception{
	  
	  //MemberDTO mdto=sqlSession.selectOne("member.selectOne",id);
	  MemberDTO mdto=memberService.getMember(id);
	  //ppp@daum.net
	  String email=mdto.getEmail();
	  int  idx1=email.indexOf("@");
	  
	  String email1=email.substring(0,idx1);//ppp
	  String email2=email.substring(idx1);//@daum.net
	  
	  model.addAttribute("email1",email1);
	  model.addAttribute("email2",email2);
	  
	  //01023236767
	  //012345678901
	  String tel=mdto.getTel();
	  String tel1=tel.substring(0,3);//010
	  String tel2=tel.substring(3,7);//2323
	  String tel3=tel.substring(7);
	  
	  model.addAttribute("tel1",tel1);
	  model.addAttribute("tel2",tel2);
	  model.addAttribute("tel3",tel3);
	  
	  model.addAttribute("mdto",mdto);
	  
	  return "/member/updateForm";//뷰 리턴
  }
  
  //DB 내정보 수정 
  @RequestMapping(value="memUpdatePro.do",method=RequestMethod.POST)
  public String updatePro(@ModelAttribute("memberDTO") MemberDTO memberDTO,HttpServletRequest request)
  throws Exception{
	  
	  String email1=request.getParameter("email1");
	  String email2=request.getParameter("email2");
	  String email=email1+email2;
	  
	  memberDTO.setEmail(email);
	  
	  
	  String tel1=request.getParameter("tel1");
	  String tel2=request.getParameter("tel2");
	  String tel3=request.getParameter("tel3");
	  
	  String tel=tel1+tel2+tel3;
	  
	  memberDTO.setTel(tel);
	  
	  //sqlSession.update("member.memberUpdate",memberDTO);
	  memberService.memberUpdate(memberDTO);
	  return "main";//뷰리턴
  }
  
  //탈퇴
  @RequestMapping("deleteMember.do")
  public String deleteMember(String id) throws Exception{
	  //sqlSession.delete("member.memberDelete",id);
	  memberService.memberDelete(id);
	  return "main"; //뷰리턴
  }
  
}//class-end
