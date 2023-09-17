package a.b.c.com.kos.like.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.like.vo.KosBoardlikeVO;
@Repository
public class KosBoardlikeDAOImpl implements KosBoardlikeDAO {

	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<KosBoardlikeVO> kosBoardLikeSelect(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosBoardLikeSelect", klvo);
	}


	@Override
	public int kosBoardLikeInsert(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kosBoardLikeInsert", klvo);
	}


	@Override
	public int kosBoardLikeUpdate(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosBoardLikeUpdate", klvo);
	}


	@Override
	public List<KosBoardlikeVO> kosBoardLikeSelectAll(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kosBoardLikeSelectAll", klvo);
	}


	@Override
	public int kosBoardLikeUpdate2(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("kosBoardLikeUpdate2", klvo);
	}

}
