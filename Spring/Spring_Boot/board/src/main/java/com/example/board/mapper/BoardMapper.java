package com.example.board.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.board.dto.BoardDto;

//@Repository는 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시하는 것
@Repository("com.example.board.mapper.BoardMapper")
@Mapper
public interface BoardMapper {
	//최대 글번호
	public Integer numMax() throws Exception;
	
	//답글 위치 확보
	public void reStep(BoardDto boardDto) throws Exception;
	
	//글쓰기, 답글쓰기
	public void insertDao(BoardDto boardDto) throws Exception;
	
	//글갯수 얻기
	public int countDao() throws Exception;
	
	//리스트
	public List listDao() throws Exception;
	
	//조회수 증가
	public void readcountDao(int num) throws Exception;
	
	//글내용 보기, 글수정
	public BoardDto getBoard(int num) throws Exception;
	
	//DB글 수정
	public void updateDao(BoardDto boardDto) throws Exception;
	
	//DB글 삭제
	public void deleteDao(int num) throws Exception;
}
