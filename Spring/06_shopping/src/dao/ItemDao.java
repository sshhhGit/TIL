package dao;

import java.util.List;

import logic.ItemDTO;

public interface ItemDao {
	public List<ItemDTO> findAll(); //추상메서드
}
