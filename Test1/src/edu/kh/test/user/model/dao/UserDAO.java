package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {

	public static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		return dao;
	}
	
	public UserDAO () {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("drivername");
		} catch (ClassNotFoundException e) {}
	}
	
	
	Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("connection");
		return conn;
	}


	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	public UserDTO searchUser(int userNo) throws SQLException {
		Connection conn = getConnection();
	
		String query = "SELECT USER_NO, USER_ID, USER_NAME, USER_AGE FROM TB_USER WHERE USER_NO = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, userNo);
		
		ResultSet rs = ps.executeQuery();
		
		UserDTO dto = null;
		while(rs.next()) {
			dto = new UserDTO(userNo, rs.getString("userId"), rs.getString("userName"), rs.getInt("userAge"));
		}
		
		
		closeAll(rs, ps, conn);
		return dto;
	
	}
}
