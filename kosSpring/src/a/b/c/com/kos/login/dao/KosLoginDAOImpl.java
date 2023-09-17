package a.b.c.com.kos.login.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.mem.vo.KosMemberVO;

@Repository
public class KosLoginDAOImpl implements KosLoginDAO {

	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<KosMemberVO> kosLoginCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosLoginCheck",kvo);
	}

	@Override
	public int kakaoInsert(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kakaoInsert", kvo);
	}

	@Override
	public List<KosMemberVO> kakaoLogin(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kakaoLogin", kvo);
	}

}
