package com.example.member.mapper;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.*;
import com.example.member.dto.MemberDTO;

//@Repository : 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시
//@Repository("com.example.member.mapper.MemberMapper")
@Repository("com.example.member.mapper.MemberMapper")
@Mapper
public interface MemberMapper {

	//id중복체크, 내정보 수정
    public MemberDTO selectOne(String id) throws Exception;
    
    //회원가입
    public void insertMember(MemberDTO memberDTO) throws Exception;
    
    //로그인 
    public MemberDTO selectLogin(Map map) throws Exception;
    
    //DB에 내정보 수정
    public void memberUpdate(MemberDTO memberDTO) throws Exception;
    
    //탈퇴
    public void memberDelete(String id) throws Exception;
     
}
