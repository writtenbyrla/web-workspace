package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAOTemplate {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	public ArrayList<Item> getAllItem() throws SQLException; 
	public Item getItem(int itemId) throws SQLException; 
	public boolean updateRecordCount(int itemId) throws SQLException;
	
}
