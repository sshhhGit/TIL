package com.example.board5.mapper;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import java.util.*;
import com.example.board5.dto.BoardDTO;

@Repository("com.example.board5.mapper.BoardMapper")
@Mapper
public interface BoardMapper {

		//게시글 작성
	public void boardInsert(BoardDTO boardDTO) throws Exception;
}
