package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate{
	
	public MemberDAO() {
		// 1. 드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}
	
	
	@Override
	public Connection getConnection() throws SQLException {
		
		// 2. DB 연결
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
	public void insertMember(MemberVO vo) throws SQLException {
		// 3. Statement 객체 생성
		Connection conn = getConnection();
		
		// 4. 쿼리문 
		String query = "INSERT INTO CAFEMEMBER(NAME, AGE, ADDR) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());
		
		ps.executeUpdate();		
		
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM CAFEMEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<MemberVO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
		}
		closeAll(rs, ps, conn);
		return list;
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM CAFEMEMBER WHERE NAME = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		MemberVO vo = null;
		while(rs.next()) {
			vo = new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
			
		}
		closeAll(rs,ps,conn);
		
		return vo;
	}

}
