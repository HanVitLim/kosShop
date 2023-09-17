package a.b.c.com.kos.rboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.rboard.vo.KosRboardVO;

@Repository
public class KosRboardDAOImpl implements KosRboardDAO {
	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<KosRboardVO> kosRboardSelectAll(KosRboardVO krvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosRboardSelectAll", krvo);
	}

	@Override
	public int kosRboardInsert(KosRboardVO krvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kosRboardInsert", krvo);
	}

	@Override
	public int kosRboardDelete(KosRboardVO krvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosRboardDelete", krvo);
	}

}
