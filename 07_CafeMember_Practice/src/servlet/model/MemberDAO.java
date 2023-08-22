package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate {

	private static MemberDAO dao = new MemberDAO();
	
	
	public MemberDAO(){
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return dao;
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
		// TODO Auto-generated method stub
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void register(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER(NAME, AGE, ADDR) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());
		
		ps.executeUpdate();
		
		ps.close();
	}

	@Override
	public MemberVO search(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
