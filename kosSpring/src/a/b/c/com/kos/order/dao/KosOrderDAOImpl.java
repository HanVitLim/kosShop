package a.b.c.com.kos.order.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.order.vo.KosOrderVO;

@Repository
public class KosOrderDAOImpl implements KosOrderDAO {

	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int kosOrderInsert(KosOrderVO kovo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kosOrderInsert", kovo);
	}

}
