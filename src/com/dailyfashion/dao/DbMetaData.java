package com.dailyfashion.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbMetaData {

	public boolean isTableExists(String tableName) {
		try (Connection con = DbUtil.getDatabaseConnection();) {
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getTables(null, null, "%", null);
			while (rs.next()) {
				if (tableName.equalsIgnoreCase(rs.getString(3))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
