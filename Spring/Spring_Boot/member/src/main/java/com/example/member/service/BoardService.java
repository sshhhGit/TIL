package com.example.member.service;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.example.member.dto.BoardDTO;
import com.example.member.mapper.BoardMapper;

@Service("com.example.member.service.BoardService")
public class BoardService {

	@Resource(name="com.example.member.mapper.BoardMapper")
	BoardMapper boardMapper;

	//최대 글번호
	public Integer numMax() throws Exception{
		return boardMapper.numMax();
	}

	//답글위치 확보 
	public void reStep(BoardDTO boardDTO) throws Exception{
		boardMapper.reStep(boardDTO);
	}

	//글쓰기 , 답글쓰기
	public void insertDao(BoardDTO boardDTO) throws Exception{
		boardMapper.insertDao(boardDTO);
	}

	//글 갯수
	public int countDao() throws Exception{
		return boardMapper.countDao();
	}

	//리스트
	public List listDao(Map map) throws Exception{
		return boardMapper.listDao(map);
	}
	
	//조회수 증가 
	public void readcountDao(int num) throws Exception{
		boardMapper.readcountDao(num);
	}

	//글내용 보기 , 글 수정 
	public BoardDTO getBoard(int num) throws Exception{
		return boardMapper.getBoard(num);
	}

	//DB글수정 
	public void updateDao(BoardDTO boardDTO) throws Exception{
		boardMapper.updateDao(boardDTO);
	}

	//글 삭제 
	public void deleteDao(int num) throws Exception{
		boardMapper.deleteDao(num);
	}
}//class-end
