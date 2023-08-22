package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate{
	
	public static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public MemberDAO () {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USERNAME, ServerInfo.PASSWORD);
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
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.executeUpdate();
		closeAll(ps, conn);
	}

	@Override
	public MemberVO searchMember(String name) throws SQLException {
		Connection conn = getConnection();
		
		String query = "";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, name);
		MemberVO vo2 = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo2 = new MemberVO(rs.getString(""), rs.getInt(""), rs.getString(""));
		}
		closeAll(rs,ps,conn);
		return vo2;
	}



	

}
