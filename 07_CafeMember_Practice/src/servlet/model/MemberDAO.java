package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate{
	
	public static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.DRIVER_NAME);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		rs.close();
		
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
	public MemberVO searchMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		String query = "";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		
		ResultSet rs = ps.executeQuery();
		
		MemberVO vo1 = null;
		while(rs.next()) {	
			vo1 = new MemberVO(rs.getString(""), rs.getInt(""), rs.getString(""));
		}
		
		closeAll(rs, ps, conn);
		
		return vo1;
		
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		String query = "";
		PreparedStatement ps = conn.prepareStatement(query);
	
		ArrayList<MemberVO> list = new ArrayList<>();
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new MemberVO(rs.getString(""), rs.getInt(""), rs.getString("")));
		}
		return list;
		
	}

	
	
	



	

}
