package logic;

import java.util.List;

//interface
public interface Shop {
	public List<ItemDTO> getItemList(); //추상메서드
	
	public ItemDTO getFindItemID(Integer item_id); //추상메서드
}
