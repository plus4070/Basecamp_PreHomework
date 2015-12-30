<<<<<<< HEAD:Basecamp_PreHomework/src/main/java/basecamp/prehomework/common/dao/CommonDAO.java
package basecamp.prehomework.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Object insert(String queryId, Object params){
		return sqlSession.insert(queryId, params);
	}
	
	public Object edit(String queryId, Object params){
		return sqlSession.update(queryId, params);
	}
	
	public Object editCheck(String queryId, Object params){
		return sqlSession.selectOne(queryId, params);
	}
	
	public Object delete(String queryId, Object params){
		return sqlSession.delete(queryId, params);
	}
	
	public Object selectOne(String queryId){
		return sqlSession.selectOne(queryId);
	}
	
	public Object selectOne(String queryId, Object params){
		return sqlSession.selectOne(queryId, params);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		return sqlSession.selectList(queryId);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params){
		return sqlSession.selectList(queryId,params);
	}
}
=======
package basecamp.prehomework.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public Object insert(String queryId, Object params){
		return sqlSession.insert(queryId, params);
	}
	
	public Object edit(String queryId, Object params){
		return sqlSession.update(queryId, params);
	}
	
	public Object editCheck(String queryId, Object params){
		return sqlSession.selectOne(queryId, params);
	}
	
	public Object delete(String queryId, Object params){
		return sqlSession.delete(queryId, params);
	}
	
	public Object selectOne(String queryId){
		return sqlSession.selectOne(queryId);
	}
	
	public Object selectOne(String queryId, Object params){
		return sqlSession.selectOne(queryId, params);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		return sqlSession.selectList(queryId);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params){
		return sqlSession.selectList(queryId,params);
	}
}
>>>>>>> origin/savePoint1:src/main/java/basecamp/prehomework/common/dao/CommonDAO.java
