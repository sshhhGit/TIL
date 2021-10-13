package com.example.member.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.member.dto.BoardDTO;
import com.example.member.service.BoardService;

 
@Controller
public class BoardController {

	@Resource(name="com.example.member.service.BoardService")
	BoardService boardService;
	
	//글쓰기 폼, 답글쓰기
	@RequestMapping("/writeForm.do")
	public String writeF(Model model,String num,String ref,String re_step,String re_level,String pageNum) {
		if(num==null) {//원글 쓰기
			num="0";//글번호
			ref="1";//글 그룹
			re_step="0";//글순서
			re_level="0";//글 깊이
		}

		model.addAttribute("pageNum",pageNum);
		model.addAttribute("num",new Integer(num));
		model.addAttribute("ref",new Integer(ref));
		model.addAttribute("re_step",new Integer(re_step));
		model.addAttribute("re_level",new Integer(re_level));

		return "board/writeForm";//뷰리턴
	}

	//글쓰기 ,답글쓰기
	@RequestMapping(value="writePro.do",method=RequestMethod.POST)
	public String writePro(@ModelAttribute("boardDTO") BoardDTO boardDTO, 
			HttpServletRequest request)	throws Exception{

		int maxNum=0;//최대 글번호 넣을 변수 선언
		if(boardService.numMax() != null) {
			//최대글번호가 있으면
			maxNum=boardService.numMax();
		}

		if(maxNum != 0) {//최대 글번호가 0이 아니면, 글이 존재하면
			maxNum=maxNum+1;//ref그룹이 넣으려고
		}else {//처음 글이면
			maxNum=1;//ref그룹에 1을 넣으려고
		}

		String ip=request.getRemoteAddr();//ip구한다
		boardDTO.setIp(ip);

		if(boardDTO.getNum() !=0 ) {//답글이면
			//답글 위치 확보
			boardService.reStep(boardDTO);
			boardDTO.setRe_step(boardDTO.getRe_step()+1);//글순서+1
			boardDTO.setRe_level(boardDTO.getRe_level()+1);//글 깊이+1

		}else {//원글이면
			boardDTO.setRef(new Integer(maxNum));//글그룹
			boardDTO.setRe_step(new Integer(0));//글순서
			boardDTO.setRe_level(new Integer(0));//글 깊이 
		}

		//sqlSession.insert("board.insertDao",boardDTO);//글쓰기,답글쓰기
		boardService.insertDao(boardDTO);//글쓰기,답글쓰기
		return "redirect:list.do";//response.sendRedirect("list.jsp")와 같다
	}//글쓰기-답글쓰기-end
	
	
	@RequestMapping("list.do")
	public String listboard(Model model, String pageNum) throws Exception{
		if(pageNum==null) {
			pageNum="1";
		}
		
		int pageSize=10;//1 페이지에 10개씩
		int currentPage=Integer.parseInt(pageNum);//현재 페이지 
		
		int startRow=(currentPage-1)*pageSize+1;//페이지의 첫번째 행(row)을 구한다 
		int endRow=currentPage*pageSize;//페이지의 마지막 행(row)을 구한다 
		
		int count=0;//총 글개수 넣으려고 
		int pageBlock=10;//1블럭당 10개 페이지로 처리 하려고 
		
        //count=sqlSession.selectOne("board.countDao");//총 글갯수 얻기 
        count=boardService.countDao();//총 글갯수 얻기 
        
        int number=count-(currentPage-1)*pageSize;//글번호 역순으로 하려고 
        
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("start", startRow-1);//시작위치, mysql은 0(행=row)부터 시작
        map.put("cnt", pageSize);
        
        int pageCount=count/pageSize+(count%pageSize==0?0:1);//총페이지 구하기
        //                             꽁다리 row갯수 구하기
        
        int startPage=(currentPage/pageBlock)*10+1;//시작페이지
        int endPage=startPage+pageBlock-1;//end 페이지
        
        //List<BoardDTO> list=sqlSession.selectList("board.listDao",map);
        List<BoardDTO> list=boardService.listDao(map);
        
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("currentPage",currentPage);
        
        model.addAttribute("startRow",startRow);
        model.addAttribute("endRow",endRow);
        
        model.addAttribute("pageBlock",pageBlock);
        model.addAttribute("pageCount",pageCount);
        
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        
        model.addAttribute("count",count);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("number",number);
        
        model.addAttribute("list",list);
		return "board/list";//뷰리턴
	}//list-end

	//글내용 보기
	@RequestMapping("content.do")
	public String content(Model model,String num,String pageNum) throws Exception{

		int num1=Integer.parseInt(num);
		//sqlSession.update("board.readcountDao",num1);//조회수 증가
		boardService.readcountDao(num1);//조회수 증가

		//BoardDTO bdto=sqlSession.selectOne("board.getBoard",num1);
		BoardDTO bdto=boardService.getBoard(num1);
		String content=bdto.getContent();
		content=content.replace("\n", "<br>");

		model.addAttribute("pageNum",pageNum);
		model.addAttribute("num",num1);
		model.addAttribute("content",content);
		model.addAttribute("dto",bdto);

		return "board/content";//뷰 리턴
	}//content()-end

	//글수정 폼
	@RequestMapping("updateForm.do")
	public ModelAndView  updateForm(String num,String pageNum) throws Exception{
		int num1=Integer.parseInt(num);
		//BoardDTO bdto=sqlSession.selectOne("board.getBoard",num1);
		BoardDTO bdto=boardService.getBoard(num1);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("pageNum",pageNum);
		mv.addObject("dto",bdto);
		mv.setViewName("board/updateForm");//뷰
		
		return mv;
	}

	
	//DB글수정
	@RequestMapping(value="updatePro.do",method=RequestMethod.POST)
	public ModelAndView updatePro(BoardDTO boardDTO,String pageNum)
			throws Exception{
		//sqlSession.update("board.updateDao",boardDTO);//글수정
		boardService.updateDao(boardDTO);//글수정

		ModelAndView mv=new ModelAndView();
		mv.addObject("pageNum", pageNum);
		mv.setViewName("redirect:list.do");

		return mv;
	}

	//글삭제
	@RequestMapping("delete.do")
	public String delete(Model model,String num,String pageNum) throws Exception{

		//sqlSession.delete("board.deleteDao",new Integer(num));//글삭제
		boardService.deleteDao(Integer.parseInt(num));
		model.addAttribute("pageNum",pageNum);

		return "redirect:list.do";
	}

}//class-end
