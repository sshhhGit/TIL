package com.spring.hello3;
import java.util.*;//List(중복허용),Set(중복허용 안된다 )

import com.spring.hello2.Computer;

public class CollectionBean {
	//===================================
	//List type 참조
	List<Computer> itemList;//변수
	
	//setter method
	public void setItemList(List<Computer> itemList){
		this.itemList=itemList;
	}
	
	//출력 메서드 
	public void printItemList(){
		for(Computer item:itemList){
			System.out.println(item.getContents());
		}
	}
	//===================================
	//Set type참조
	Set<Computer> itemSet;//변수

	//setter method
	public void setItemSet(Set<Computer> itemSet) {
		this.itemSet = itemSet;
	}
	
	//출력 메서드 
	public void printItemSet(){
		for(Computer item:itemSet){
			System.out.println(item.getContents());
		}
	}
	
	//===================================
	//Map type 참조
	Map<String,Computer> itemMap;//변수

	//setter method
	public void setItemMap(Map<String, Computer> itemMap) {
		this.itemMap = itemMap;
	}
	
	//출력 메서드 
	public void printItemMap(){
		for(String key:itemMap.keySet()){
			Computer item=itemMap.get(key);//key에 해당하는 값을 얻어서 item에 할당
			System.out.println(key+":"+item.getContents());
		}//for-end
	}//method-end
	//===================================
	
}//class-end
