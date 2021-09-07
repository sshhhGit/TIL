package shopdb;

import java.sql.Timestamp;

public class ProductDTO {

	private int pro_no;		//상품 일련변호
	private String code;	//상품 코드
	private String name;	//상품 이름
	private int price;		//상품 가격
	private int stock;		//입고물량
	private String detail;	//설명
	private String comp;	//회사명
	private Timestamp regdate;	//날짜
	private String image;	//상품 이미지
	
	public ProductDTO() {}	//기본 생성자

	//getter setter
	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	
}
