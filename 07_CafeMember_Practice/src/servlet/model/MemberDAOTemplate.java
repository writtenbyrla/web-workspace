package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAOTemplate {
	
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	void registerMember(MemberVO vo) throws SQLException;
	MemberVO searchMember(MemberVO vo) throws SQLException;
	ArrayList<MemberVO> showAllMember() throws SQLException;
}
