package com.example.member.dto;
import java.util.Date;

public class BoardDTO {
	//전역변수=필드=프로퍼티=property
	private int num;//글번호
	private String writer;//글쓴이
	private String subject;//글제목
	private String pw;//암호
	
	private Date regdate;//날짜, 글 등록일 
	private int readcount;//조회수
	
	private int ref;//답글 그룹
	private int re_step;//글 순서
	private int re_level;//답글 들여쓰기
	
	private String content;//글내용
	private String ip;//클라이언트 ip
	
	public BoardDTO() {}//default 생성자

	// getter,setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRe_step() {
		return re_step;
	}

	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}

