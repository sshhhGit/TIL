package shopdb;

import java.util.*; //Hashtable 장바구니로 사용
//Hashtable : key, value

public class CartMgr {
	
	private Hashtable cart = new Hashtable<>();

	public CartMgr() {} //기본생성자
	
	//장바구니에 넣기
	public void addCart(OrderDTO orderDTO) {
		
		int pro_no = orderDTO.getPro_no(); //상품 일련번호
		String q = orderDTO.getQuantity(); //수량
		int quantity = Integer.parseInt(q); //수량을 int로
		
		if(quantity>0){ //주문 수량이 있으면
			if(cart.containsKey(pro_no)){
				//cart pro_no가 있으면, 같은 물건이면 추가 구매
				
				OrderDTO tempDTO = (OrderDTO)cart.get(pro_no);
				quantity += Integer.parseInt(tempDTO.getQuantity());
				
				tempDTO.setQuantity(quantity+""); //수량 setter 작업
				cart.put(pro_no, tempDTO);
				//			ket, value
			}else{
				//cart에 pro_no가 없으면
				//상품을 처음으로 장바구니에 넣는 경우
				cart.put(pro_no, orderDTO);
			}
		}//if-end
	}//addCart()-end
	//----------------------------
	//장바구니 내용 보여주기, cart 내용 리턴
	//----------------------------
	public Hashtable getCartList(){
		return cart;
	}
	//----------------------------
	//cart내용 수정
	//----------------------------
	
	public void updateCart(OrderDTO orderDTO){
		int pro_no = orderDTO.getPro_no();
		cart.put(pro_no, orderDTO);
	}
	//----------------------------
	//cart내용 제거
	//----------------------------
	public void deleteCart(OrderDTO orderDTO) {
		int pro_no = orderDTO.getPro_no();
		cart.remove(pro_no); //pro_no에 해당하는것을 삭제
	}
}//class-end
