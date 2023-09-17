package a.b.c.com.kos.cart.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.cart.vo.KoscartVO;


@Repository
public class KoscartDAOImpl implements KoscartDAO {
	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int koscartInsert(KoscartVO kcvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("koscartInsert", kcvo);
	}

	@Override
	public List<KoscartVO> koscartSelectAll(KoscartVO kcvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("koscartSelectAll", kcvo);
	}

	@Override
	public int koscartDelete(KoscartVO kcvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("koscartDelete", kcvo);
	}

	@Override
	public int kosmoCartDeleteArray(ArrayList<KoscartVO> aList) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosmoCartDeleteArray", aList);
	}

	@Override
	public List<KoscartVO> koscartorderSelectAll(ArrayList<KoscartVO> aList) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("koscartorderSelectAll", aList);
	}

}
