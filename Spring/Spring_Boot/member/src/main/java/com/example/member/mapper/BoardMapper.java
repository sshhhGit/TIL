package com.example.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.member.dto.BoardDTO;

//@Repository : 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시
//@Repository("com.example.member.mapper.MemberMapper")
@Repository("com.example.member.mapper.BoardMapper")
@Mapper
public interface BoardMapper {
  
	//최대 글번호
	public Integer numMax() throws Exception;
  
	//답글위치 확보 
	public void reStep(BoardDTO boardDTO) throws Exception;
	
	//글쓰기 , 답글쓰기
	public void insertDao(BoardDTO boardDTO) throws Exception;
	
	//글 갯수
	public int countDao() throws Exception;
	
	//리스트
	public List listDao(Map map) throws Exception;
	
	//조회수 증가 
	public void readcountDao(int num) throws Exception;
	
	//글내용 보기 , 글 수정 
	public BoardDTO getBoard(int num) throws Exception;
	
	//DB글수정 
	public void updateDao(BoardDTO boardDTO) throws Exception;
	
	//글 삭제 
	public void deleteDao(int num) throws Exception;
}
