package a.b.c.com.kos.product.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.product.vo.KosProductVO;

@Repository
public class KosProductDAOImpl implements KosProductDAO {

	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int kosProductInsert(KosProductVO kpvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kosProductInsert", kpvo);
	}

	@Override
	public List<KosProductVO> kosProductSelectAll(KosProductVO kpvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosProductSelectAll", kpvo);
	}

	@Override
	public List<KosProductVO> kosProductSelect(KosProductVO kpvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosProductSelect", kpvo);
	}

}
