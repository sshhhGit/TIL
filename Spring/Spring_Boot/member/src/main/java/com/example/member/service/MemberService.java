package com.example.member.service;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 import org.springframework.stereotype.Service;
 
import com.example.member.dto.MemberDTO;
import com.example.member.mapper.MemberMapper;
 
@Service("com.example.member.service.MemberService")
public class MemberService {

	@Resource(name="com.example.member.mapper.MemberMapper")
	MemberMapper memberMapper;

	//id중복체크, 내정보 수정
	public MemberDTO getMember(String id) throws Exception{
		return memberMapper.selectOne(id);
	}
	
	//회원가입
	public void insertMember(MemberDTO memberDTO) throws Exception{
		memberMapper.insertMember(memberDTO);
	}
	
	//로그인 
	public MemberDTO loginPro(Map map) throws Exception{
		return memberMapper.selectLogin(map);
	}
	
	//DB에 내정보 수정
	public void memberUpdate(MemberDTO memberDTO) throws Exception{
		memberMapper.memberUpdate(memberDTO);
	}
	
	//탈퇴
	public void memberDelete(String id) throws Exception{
		memberMapper.memberDelete(id);
	}
	
}//class-end
