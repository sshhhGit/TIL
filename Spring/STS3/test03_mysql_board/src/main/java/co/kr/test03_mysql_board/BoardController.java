package co.kr.test03_mysql_board;

import java.util.*;//Date,HashMap,List,Map
import java.text.DateFormat;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;//MyBatis 사용
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.test03_mysql_board.dto.BoardDTO;

@Controller
public class BoardController {

	@Autowired //자동으로 setter 된다 
	SqlSession sqlSession;//변수
	
	@RequestMapping("/writeForm.do")
	public String writeForm() {
		return "/writeForm";//writeForm.jsp 뷰 리턴
	}
	
	@RequestMapping(value="/writePro.do",method=RequestMethod.POST)
	public String writePro(@ModelAttribute("boardDTO") BoardDTO boardDTO) {
		
		Integer bbId=sqlSession.selectOne("board.getbId");//최대 글 번 
		
		//bGroup 처리 
		 
		if(bbId==null) {//글이 없으면
			boardDTO.setbGroup(0);
			
		}else {//글이 있으면
			boardDTO.setbGroup(bbId);
		}
		 
		sqlSession.insert("board.writeDao",boardDTO);
		return "redirect:list.do";
		
	}
	
	
	//리스트 
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<BoardDTO> list=sqlSession.selectList("board.listDao");
		model.addAttribute("list",list);//jsp에서 사용할 데이터 
		return "/list";//list.jsp  뷰 리턴 
	}
	
	// 조회수 증가 
	// 글내용 보기
	@RequestMapping("/content.do")
	public String contentView(HttpServletRequest request,Model model) {
		
		sqlSession.update("board.upHit",request.getParameter("bId"));//조회수 증가 
		
		BoardDTO bdto=sqlSession.selectOne("board.contentView",request.getParameter("bId"));
		
		model.addAttribute("bdto",bdto);//jsp사용할 데이터 
		
		return "/content";//content.jsp 뷰 리턴 
	}
	
	//글 삭제 
	@RequestMapping("/delete.do")
	public String deletePro(HttpServletRequest request) {
		sqlSession.delete("board.deleteDao",request.getParameter("bId"));
		return "redirect:list.do";
	}
	
	//글내용 보기에서  글 수정 까지 하도록 했음
	//DB글수정
	@RequestMapping(value="/modifyPro.do",method=RequestMethod.POST)
	public String modifyPro(@ModelAttribute("boardDTO") BoardDTO boardDTO) {
		sqlSession.update("board.modyfyDao",boardDTO);
		return "redirect:list.do";
	}
	
	//답글 쓰기 위해 화면에 보여주기 
	@RequestMapping("/replyView.do")
	public String replyView(Model model,HttpServletRequest request) {
		BoardDTO bdto=sqlSession.selectOne("board.replyView",request.getParameter("bId"));
		model.addAttribute("bdto",bdto);
		return "/replyView";//replyView.jsp 뷰리턴
	}
	
	//답글 위치 확보
	public void replyShape(Map map) {
		sqlSession.update("board.replyShape",map);
	}
	
	//답글 쓰기
	@RequestMapping("/replyPro.do")
	public String replyPro(@ModelAttribute("boardDTO") BoardDTO boardDTO,
			HttpServletRequest request,Model model) {
		
		String bGroup=request.getParameter("bGroup");
		String bStep=request.getParameter("bStep");
		
		Map<String ,String> map=new HashMap<String,String>();
		map.put("bGroup", bGroup);
		map.put("bStep", bStep);
		replyShape(map);//답글 위치 확보하려고 ,메서드 호출 
		
		//답글쓰기 
		sqlSession.insert("board.replyDao",boardDTO);
		
		return "redirect:list.do";
	}
}//class-end
