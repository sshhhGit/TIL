package com.spring.hello2;

public class SaleItem {
	Computer item;//변수
	int cnt;
	long price;
	
	public SaleItem(){}//디폴트 생성자 추가
	
	//생성자: 생성자 Injection사용
	public SaleItem(Computer item,int cnt, long price){
		this.item=item;
		this.cnt=cnt;
		this.price=price;
	}
	
	
	//	Computer item;//변수
	//	int cnt;
	//	long price;
	//setter  : Computer item : setter Injection
	public void setItem(Computer item) {
		this.item = item;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	//사용자 정의 메서드
	public String display(){
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("상품:"+item.getContents()+"\n");
		sb.append("수량:"+cnt+"\n");
		sb.append("금액:"+price+"\n");
		
		return sb.toString();//String으로 변환 하여 리턴 
	}
}//class-end
