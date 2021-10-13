package com.example.board5.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.board5.dto.BoardDTO;
import com.example.board5.mapper.BoardMapper;

@Service("com.example.board5.service.BoardService")
public class BoardService {

	@Resource(name = "com.example.board5.mapper.BoardMapper")
	BoardMapper boardMapper;
	
	//insert
	public void BoardInsertService(BoardDTO boardDTO) throws Exception{
		boardMapper.boardInsert(boardDTO); //boardInsert
	}
}
