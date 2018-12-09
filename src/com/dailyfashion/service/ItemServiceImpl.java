package com.dailyfashion.service;

import java.util.List;

import com.dailyfashion.dao.ItemDao;
import com.dailyfashion.dao.ItemDaoImpl;
import com.dailyfashion.model.Item;

public class ItemServiceImpl implements ItemService {

	ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public int createItem(Item item) {
		System.out.println(this.getClass().getSimpleName() + " >> Creating Item");
		return itemDao.createItem(item);
	}

	@Override
	public Item readItem(String itemId) {
		return itemDao.readItem(itemId);
	}

	@Override
	public int updateItem(Item item) {
		return itemDao.updateItem(item);
	}

	@Override
	public int deleteItem(String itemId) {
		return itemDao.deleteItem(itemId);
	}

	@Override
	public void createItemTable() {
		itemDao.createItemTable();
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

}
