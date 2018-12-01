package com.dailyfashion.service;

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
		System.out.println(this.getClass().getSimpleName()+" >> Creating Item");
		itemDao.createItem(item);
		return 0;
	}

	@Override
	public Item readItem(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(String itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
