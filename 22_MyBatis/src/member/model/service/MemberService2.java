package member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import member.model.dao.MemberDAO;
import member.model.vo.MemberVO;

public class MemberService2 {
	
	public int Register(MemberVO vo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = MemberDAO.getInstance().registerMember(sqlSession, vo);
		if(result>0) sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
