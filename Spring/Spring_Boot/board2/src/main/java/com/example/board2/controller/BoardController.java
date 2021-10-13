package com.example.board2.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.board2.dto.BoardDTO;
//import com.example.board.service.BoardService;

@Controller
public class BoardController {
    @RequestMapping("/insert.do") //게시글 작성폼 호출  
    private String boardInsertForm(){
         return "insert";//뷰
    }

}
