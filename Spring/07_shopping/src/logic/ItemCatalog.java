package logic;

import java.util.List;

//interface : 중간 역할
public interface ItemCatalog {
	
	public List<ItemDTO> getItemList(); //추상메서드
	
	public ItemDTO getItemByItemID(Integer item_id); //추상메서드
}
