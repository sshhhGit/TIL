package shopdb;

import java.sql.Timestamp;

public class OrderDTO {

	private int ordno;			//주문번호
	private int pro_no;			//상품일련번호
	private String quantity;	//주문 수량
	private Timestamp orddate;	//주문 날짜
	private String state;		//상태
	private String userid;		//유저ID
	
	public OrderDTO() {}		//생성자

	//getter setter
	public int getOrdno() {
		return ordno;
	}

	public void setOrdno(int ordno) {
		this.ordno = ordno;
	}

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Timestamp getOrddate() {
		return orddate;
	}

	public void setOrddate(Timestamp orddate) {
		this.orddate = orddate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
