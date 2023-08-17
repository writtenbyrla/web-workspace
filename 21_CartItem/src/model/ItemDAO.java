package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate {
	
	private static ItemDAO dao = new ItemDAO();
	
	private ItemDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}
	
	public static ItemDAO getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<Item> itemList = new ArrayList<>(); 
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Item item = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			itemList.add(item);
		}
	
		closeAll(rs, ps, conn);
		
		return itemList;
		
		
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM WHERE ITEM_ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, itemId);
		ResultSet rs = ps.executeQuery();
		
		Item item = null;
		if(rs.next()) {
			//item = new Item(rs.getInt("itemId"), rs.getString("itemName"), rs.getInt("price"), rs.getString("description"), rs.getString("picture_url"), rs.getInt("count"));
			item = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
		}
		closeAll(rs,ps,conn);
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "UPDATE ITEM SET COUNT = COUNT+1 WHERE ITEM_ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, itemId);
		
		int row = ps.executeUpdate();
		boolean result = false;
		
		if(row>0) result = true;
		
		closeAll(ps, conn);
		
		return result;
	}
	
	
}
