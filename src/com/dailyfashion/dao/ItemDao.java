package com.dailyfashion.dao;

import com.dailyfashion.model.Item;

public interface ItemDao {
	
	int createItem(Item item);

	Item readItem(String itemId);

	int updateItem(Item item);

	int deleteItem(String itemId);
}
