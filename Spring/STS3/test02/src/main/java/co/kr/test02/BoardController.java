package co.kr.test02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession; //MyBatis

import java.util.*;
import board.model.BoardDTO;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.naming.NamingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BoardController {

	@Autowired //자동 setter 작업
	private SqlSession sqlSession;
	
	@RequestMapping("/writeForm.do")
	public String writeForm() {
		return "writeForm"; //뷰 리턴
	}
	
	@RequestMapping(value = "writePro.do", method = RequestMethod.POST)
	public String writePro(@ModelAttribute("boardDTO") BoardDTO boardDTO, HttpServletRequest request) throws IOException, NamingException{
		
		String ip = request.getRemoteAddr(); //ip구하기
		boardDTO.setIp(ip);
		
		sqlSession.insert("board.insertBoard", boardDTO);
		
		return "redirect:list.do"; //response.sendRedirect("list.jsp")
	}
	
	@RequestMapping("/list.do")
	public ModelAndView boardList() throws IOException, NamingException{
		List<BoardDTO> list = sqlSession.selectList("board.selectAll");
		return new ModelAndView("list", "list", list);
								//뷰         list.jsp 사용 할 데이터
	}
	
	@RequestMapping("/content.do")
	public ModelAndView getcontent(int num) {
		//조회수 증가
		sqlSession.update("board.readcountBoard", new Integer(num));
		
		//글내용 보기
		BoardDTO boardDTO = (BoardDTO)sqlSession.selectOne("board.selectOne", num);
		
		return new ModelAndView("content", "boardDTO", boardDTO);
		//						'뷰'이름	     jsp에서 사용 할 데이터
	}
	//글수정 폼
	@RequestMapping(value = "/editForm.do", method = RequestMethod.GET)
	public ModelAndView editForm(int num) {
		BoardDTO boardDTO = (BoardDTO)sqlSession.selectOne("board.selectOne", num);
		return new ModelAndView("editForm", "boardDTO", boardDTO);
		//							'뷰'이름    jsp에서 사용 할 데이터
	}
	
	//DB글 수정
	@RequestMapping(value = "/editPro.do", method = RequestMethod.POST)
	public String updatePro(@ModelAttribute("boardDTO") BoardDTO boardDTO) {
		
		sqlSession.update("board.updateBoard", boardDTO);
		return "redirect:list.do";
	}
}
