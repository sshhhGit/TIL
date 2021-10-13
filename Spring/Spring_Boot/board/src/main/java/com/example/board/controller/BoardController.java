package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.apache.ibatis.session.SqlSession;
import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.board.util.PageTest;
import javax.annotation.Resource;

@Controller
@RequestMapping("/board")
public class BoardController {

		@Resource(name = "com.example.board.service.BoardService")
		BoardService boardService;
		
		//글쓰기 폼, 답글쓰기
		@RequestMapping("/writeForm.do")
		public String WriterF(Model model, String num, String ref, String re_step, String re_level, String PageNum) {
			
			if(num==null) { //원글
				num="0";
				ref="1";
				re_step="0";
				re_level="0";
			}
			
			model.addAttribute("pageNum", PageNum);
			model.addAttribute("num", num);
			model.addAttribute("ref", ref);
			model.addAttribute("re_step", re_step);
			model.addAttribute("re_level", re_level);
			
			return "/board/writeForm";
		}
		
		//DB글쓰기
		@RequestMapping(value = "writePro.do", method = RequestMethod.POST)
		public String writePro(@ModelAttribute("boardDto") BoardDto boardDto, HttpServletRequest request) throws Exception {
			
			int maxNum = 0; //최대 글번호
			
			if(boardService.numMax() != null) { //최대 글번호가 있다면
				maxNum = boardService.numMax();
			}
			
			if(maxNum != 0) { //최대 글번호가 0이 아니라면(글이 존재한다면)
				maxNum = maxNum+1; //ref에 넣으려고
				
			}else {
				maxNum = 1;
			}
			
			String ip = request.getRemoteAddr(); //ip구하기
			boardDto.setIp(ip);
			
			if(boardDto.getNum() != 0) {//답글이면
				boardService.reStep(boardDto); //답글위치 확보
				boardDto.setRe_step(boardDto.getRe_step()+1); //글순서 +1
				boardDto.setRe_level(boardDto.getRe_level()+1); //글깊이+1
			}else { //원글이라면
				boardDto.setRef(new Integer(maxNum)); //글그룹
				boardDto.setRe_step(new Integer(0)); //글순서
				boardDto.setRe_level(new Integer(0)); //글깊이
			}
			boardService.insertDao(boardDto); //메서드 호출
			
			return "redirect:/board/list.do";
		}
		
		//글목록
		@RequestMapping("/list.do")
		public String listBoard(Model model, String pageNum) throws Exception{
			if(pageNum == null) {
				pageNum = "1";
			}
			
			int cnt = boardService.countDao(); //총 글갯수 얻기
			int curPage = Integer.parseInt(pageNum); //현재 페이지
			PageTest pp2 = new PageTest(cnt, curPage); //페이지 처리
			
			int startPos = pp2.getStartRow()-1;
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", new Integer(startPos));
			map.put("cnt", pp2.getPageSize());
			
			List<BoardDto> list = boardService.listDao(map);
			int number = cnt-(curPage-1)*pp2.getPageSize();
			
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("number", number);
			model.addAttribute("cnt", cnt);
			model.addAttribute("list", list);
			
			return "/board/list";
		}
		
		//조회수 증가, 글내용 보기
		@RequestMapping("/content.do")
		public String contentPro(Model model, String num, String pageNum) throws Exception{
			
			boardService.readcountDao(new Integer(num)); //조회수 증가
			BoardDto boardDto = boardService.getBoard(new Integer(num));
			
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("num", num);
			model.addAttribute("bdto", boardDto); //JSP에서 사용 할 데이터
			
			return "/board/content"; 
			
		}
		
		//글 수정 폼
		@RequestMapping("/updateForm.do")
		public ModelAndView updateForm(String num, String pageNum) throws Exception{
			BoardDto boardDto = boardService.getBoard(new Integer(num)); //데이터 얻기
			ModelAndView mv = new ModelAndView();
			mv.addObject("pageNum", pageNum);
			mv.addObject("bdto", boardDto);
			mv.setViewName("/board/updateForm");
			
			return mv;
		}
		
		//DB글 수정
		@RequestMapping(value = "updatePro.do", method = RequestMethod.POST)
		public ModelAndView updatePro(BoardDto boardDto, String pageNum) throws Exception{
			boardService.updateDao(boardDto); //글수정
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("pageNum", pageNum);
			mv.setViewName("redirect:/board/list.do");
			return mv;
		}
		
		//DB글 삭제
		@RequestMapping("/delete.do")
		public String deletePro(Model model, String num, String pageNum) throws Exception{
			boardService.deleteDao(Integer.parseInt(num));
			model.addAttribute("pageNum", pageNum);
			return "redirect:/board/list.do";
		}
}
