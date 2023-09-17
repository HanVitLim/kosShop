package a.b.c.com.common.chabun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.board.vo.KosBoardVO;
import a.b.c.com.kos.cart.vo.KoscartVO;
import a.b.c.com.kos.like.vo.KosBoardlikeVO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.kos.order.vo.KosOrderVO;
import a.b.c.com.kos.product.vo.KosProductVO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;

@Repository
public class KosChabunDAOImpl implements KosChabunDAO {
	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public KosMemberVO getKosMemberChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getKosMemberChabun");
	}

	@Override
	public KosBoardVO getKosBoardChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getKosBoardChabun");
	}

	@Override
	public KosRboardVO getKosRboardChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getKosRboardChabun");
	}

	@Override
	public KosBoardlikeVO getKosBoardlikeChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getKosBoardlikeChabun");
	}

	@Override
	public KosProductVO getKosProductChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getKosProductChabun");
	}

	@Override
	public KoscartVO getKosCartChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getKosCartChabun");
	}

	@Override
	public KosOrderVO getKosOrderChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getKosOrderChabun");
	}

}
