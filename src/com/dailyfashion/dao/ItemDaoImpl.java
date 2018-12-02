package com.dailyfashion.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.dailyfashion.model.Item;

public class ItemDaoImpl implements ItemDao {

	private DbMetaData dbMetaData;

	private static final String TABLE_NAME = "DF_ITEM";

	private static final String CREATE_ITEM_TABLE_SQL = "CREATE TABLE " + TABLE_NAME
			+ "(ID VARCHAR(50), NAME VARCHAR(50), DESCRIPTION VARCHAR(100), PRICE DECIMAL, QUANTITY NUMBER, IMAGE_URL VARCHAR(100))";

	public ItemDaoImpl() {
		dbMetaData = new DbMetaData();
	}

	@Override
	public int createItem(Item item) {
		System.out.println(this.getClass().getSimpleName() + " >> Creating Item");
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

	@Override
	public void createItemTable() {
		if (!dbMetaData.isTableExists(TABLE_NAME)) {
			System.out.println(this.getClass().getSimpleName() + ">> Creating table: " + TABLE_NAME);
			try (Connection con = DbUtil.getDatabaseConnection(); Statement stmt = con.createStatement();) {
				stmt.execute(CREATE_ITEM_TABLE_SQL);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(this.getClass().getSimpleName() + "<< " + TABLE_NAME + " table already exists");
		}
	}

}
