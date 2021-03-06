package co.kr.test04_oracle_board.dto;

import java.sql.Timestamp;//년월일 시분초
//DB: datetime //년원일 시분초
public class BoardDTO {
	//전역변수=필드=프로퍼티=property
	private int bId;
	private String bName;
	private String bTitle;
	private String bContent;
	
	private Timestamp bDate;
	
	private int bHit;
	private int bGroup;//글 그룹
	private int bStep;//글 순서 
	private int bIndent;//글 들여쓰기 
	
	public BoardDTO() {}//디폴트 생성자

	//setter/getter
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
}
