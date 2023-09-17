package a.b.c.com.kos.mem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.mem.vo.KosMemberVO;
@Repository
public class KosMemberDAOImpl implements KosMemberDAO {
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;

	@Override
	public int kosMemberInsert(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kosMemberInsert", kvo);
	}

	@Override
	public List<KosMemberVO> Idcheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Idcheck", kvo);
	}

	@Override
	public List<KosMemberVO> kosMemberSelectAll(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosMemberSelectAll",kvo);
	}

	@Override
	public List<KosMemberVO> kosMemberSelect(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosMemberSelect" , kvo);
	}

	@Override
	public int kosMemberUpdate(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosMemberUpdate", kvo);
	}

}
