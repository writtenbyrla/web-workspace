package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberVO;

public class MemberDAO implements MemberDAOTemplate{
	
	// 싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록 
	/*
	 * DAO를 반복적으로 생성하고 해제하는 것은 비효율적
	 * 객체지향적 설계! 싱글톤 패턴은 객체지향적 설계 원칙을 준수 -> 중앙에서 처리!
	 * 주의할 점은 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	 * */
	private static MemberDAO dao = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}
	
	public static MemberDAO getInstance() {
		return dao;
	}

//	public MemberDAO() {
//		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
//		} catch (ClassNotFoundException e) {}
//
//	}
	
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
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER(ID, PASSWORD, NAME, ADDRESS) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}

	@Override
	public MemberVO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER WHERE id=? and password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		MemberVO vo = null;
		if(rs.next()) {
			vo = new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address") );
		}
		
		closeAll(rs, ps, conn);
		
		return vo;
	}
	
	
	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		MemberVO vo = null;
		if(rs.next()) {
			vo = new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address") );
		}
		closeAll(rs,ps,conn);
		return vo;
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<MemberVO> memberList = new ArrayList<>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			MemberVO vo = new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address"));
			memberList.add(vo);
		}
		
		closeAll(rs, ps, conn);
		
		return memberList;
	}
	
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "UPDATE MEMBER SET PASSWORD = ?, NAME = ?, ADDRESS = ? WHERE ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getPassword());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getId());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
		
	}
	

	@Override
	public MemberVO idExist(String id) throws SQLException {
		Connection conn = getConnection();
		
		MemberVO vo = null;
		String query = "SELECT * FROM MEMBER WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo = new MemberVO(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getString("address"));
		}
		closeAll(rs, ps, conn);
		return vo;
	}
	
	
	public static void main(String[] args) {
//		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO("user1", "user1", "지동", "우리집");

		
		try {
//			dao.registerMember(dto);
			vo = dao.login("user1", "user1");
			System.out.println("name : " + vo.getName());
			System.out.println("address : " + vo.getAddress());
		} catch (SQLException e) {}
		
	}


}
