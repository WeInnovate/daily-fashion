package com.dailyfashion.service;

import java.util.List;

import com.dailyfashion.model.Item;

public interface ItemService {
	void createItemTable();

	int createItem(Item item);

	Item readItem(String itemId);

	int updateItem(Item item);

	int deleteItem(String itemId);

	List<Item> getItems();
}
