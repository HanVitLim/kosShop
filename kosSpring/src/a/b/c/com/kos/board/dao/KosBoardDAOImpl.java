package a.b.c.com.kos.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.board.vo.KosBoardVO;
@Repository
public class KosBoardDAOImpl implements KosBoardDAO {

	@Autowired(required = false)
	private SqlSessionTemplate sqlSession; 
	
	@Override
	public int kosBoardInsert(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kosBoardInsert", kbvo);
	}

	@Override
	public List<KosBoardVO> kosBoardSelectAll(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosBoardSelectAll", kbvo);
	}

	@Override
	public int kosBoardBhit(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosBoardBhit", kbvo);
	}

	@Override
	public List<KosBoardVO> kosBoardSelectContents(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosBoardSelectContents", kbvo);
	}

	@Override
	public List<KosBoardVO> kosBoardPwCheck(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosBoardPwCheck", kbvo);
	}

	@Override
	public int kosBoardUpdate(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosBoardUpdate", kbvo);
	}

}
