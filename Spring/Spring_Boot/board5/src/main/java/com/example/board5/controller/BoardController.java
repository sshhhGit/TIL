package com.example.board5.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.board5.dto.BoardDTO;
import com.example.board5.service.BoardService;

@Controller
public class BoardController {

	@Resource(name = "com.example.board5.service.BoardService")
	BoardService boardService;
	
	@RequestMapping("/insert.do")
	private String boardInsertForm() {
		return "insert";
	}
	
	@RequestMapping("/insertProc.do")
	private String boardInsertPorc(@ModelAttribute("boardDTO") BoardDTO boardDTO, HttpServletRequest request) throws Exception{
		
		boardService.BoardInsertService(boardDTO);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/list.do")
	private String boardList(Model model) throws Exception{
		
		return "list";
	}
}
