package a.b.c.com.common.chabun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.common.chabun.dao.KosChabunDAO;
import a.b.c.com.kos.board.vo.KosBoardVO;
import a.b.c.com.kos.cart.vo.KoscartVO;
import a.b.c.com.kos.like.vo.KosBoardlikeVO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.kos.order.vo.KosOrderVO;
import a.b.c.com.kos.product.vo.KosProductVO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;
@Service
@Transactional
public class KosChabunServiceImpl implements KosChabunService {
	
	@Autowired(required = false)
	private KosChabunDAO kosChabunDAO;
	
	@Override
	public KosMemberVO getKosMemberChabun() {
		// TODO Auto-generated method stub
		return kosChabunDAO.getKosMemberChabun();
	}

	@Override
	public KosBoardVO getKosBoardChabun() {
		// TODO Auto-generated method stub
		return kosChabunDAO.getKosBoardChabun();
	}

	@Override
	public KosRboardVO getKosRboardChabun() {
		// TODO Auto-generated method stub
		return kosChabunDAO.getKosRboardChabun();
	}

	@Override
	public KosBoardlikeVO getKosBoardlikeChabun() {
		// TODO Auto-generated method stub
		return kosChabunDAO.getKosBoardlikeChabun();
	}

	@Override
	public KosProductVO getKosProductChabun() {
		// TODO Auto-generated method stub
		return kosChabunDAO.getKosProductChabun();
	}

	@Override
	public KoscartVO getKosCartChabun() {
		// TODO Auto-generated method stub
		return kosChabunDAO.getKosCartChabun();
	}

	@Override
	public KosOrderVO getKosOrderChabun() {
		// TODO Auto-generated method stub
		return kosChabunDAO.getKosOrderChabun();
	}

}
