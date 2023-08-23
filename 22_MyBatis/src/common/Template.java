package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		String resource = "/mybatis-config.xml";
		
		InputStream stream;
		try {
			stream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(stream);
			
			sqlSession = factory.openSession(false);
		} catch (IOException e) {}
		
		return sqlSession;
	}
}
