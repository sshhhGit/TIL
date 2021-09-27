package logic;

import java.util.List;

import dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog{
	
	private ItemDao itemDao; //변수
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<ItemDTO> getItemList() {
		// TODO Auto-generated method stub
		return itemDao.findAll();
	}

	@Override
	public ItemDTO getItemByItemID(Integer item_id) {
		// TODO Auto-generated method stub
		return itemDao.findByPrimaryKey(item_id);
	}
	
}
