package com.dailyfashion.dao;

import com.dailyfashion.model.Item;

public class ItemDaoImpl implements ItemDao {

	@Override
	public int createItem(Item item) {
		System.out.println(this.getClass().getSimpleName()+" >> Creating Item");
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
