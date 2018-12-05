package com.dailyfashion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dailyfashion.model.Item;

public class ItemDaoImpl implements ItemDao {

	private DbMetaData dbMetaData;

	private static final String TABLE_NAME = "DF_ITEM";

	private static final String CREATE_ITEM_TABLE_SQL = "CREATE TABLE " + TABLE_NAME
			+ "(ID VARCHAR(50), NAME VARCHAR(50), DESCRIPTION VARCHAR(100), PRICE DECIMAL, QUANTITY NUMBER, IMAGE_URL VARCHAR(100))";

	private static final String INSERT_ITEM = "INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?, ?, ?)";

	private static final String SELECT_ITEMS = "SELECT * FROM " + TABLE_NAME;

	private static final String SELECT_ITEM = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";

	private static final String DELETE_ITEM = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";

	private static final String UPDATE_ITEM = "UPDATE " + TABLE_NAME
			+ " SET NAME = ?, DESCRIPTION = ?, PRICE = ?, QUANTITY = ?, IMAGE_URL = ? WHERE ID = ?";

	public ItemDaoImpl() {
		dbMetaData = new DbMetaData();
	}

	@Override
	public int createItem(Item item) {
		System.out.println(this.getClass().getSimpleName() + " >> Creating Item");
		try (Connection con = DbUtil.getDatabaseConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_ITEM);) {
			pstmt.setString(1, item.getId());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getDescription());
			pstmt.setDouble(4, item.getPrice());
			pstmt.setInt(5, item.getQuantity());
			pstmt.setString(6, item.getImageUrl());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Item readItem(String itemId) {
		try (Connection con = DbUtil.getDatabaseConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_ITEM)) {
			pstmt.setString(1, itemId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getString(1));
				item.setName(rs.getString(2));
				item.setDescription(rs.getString(3));
				item.setPrice(rs.getDouble(4));
				item.setQuantity(rs.getInt(5));
				item.setImageUrl(rs.getString(6));
				return item;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateItem(Item item) {
		try (Connection con = DbUtil.getDatabaseConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_ITEM);) {
			pstmt.setString(6, item.getId());
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getDescription());
			pstmt.setDouble(3, item.getPrice());
			pstmt.setInt(4, item.getQuantity());
			pstmt.setString(5, item.getImageUrl());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteItem(String itemId) {
		try (Connection con = DbUtil.getDatabaseConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_ITEM)) {
			pstmt.setString(1, itemId);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	@Override
	public List<Item> getItems() {
		try (Connection con = DbUtil.getDatabaseConnection(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(SELECT_ITEMS);
			List<Item> items = new ArrayList<>();
			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getString(1));
				item.setName(rs.getString(2));
				item.setDescription(rs.getString(3));
				item.setPrice(rs.getDouble(4));
				item.setQuantity(rs.getInt(5));
				item.setImageUrl(rs.getString(6));
				items.add(item);
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

}
