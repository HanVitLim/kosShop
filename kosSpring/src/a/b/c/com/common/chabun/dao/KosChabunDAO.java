package a.b.c.com.common.chabun.dao;

import a.b.c.com.kos.board.vo.KosBoardVO;
import a.b.c.com.kos.cart.vo.KoscartVO;
import a.b.c.com.kos.like.vo.KosBoardlikeVO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.kos.order.vo.KosOrderVO;
import a.b.c.com.kos.product.vo.KosProductVO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;

public interface KosChabunDAO {

	public KosMemberVO getKosMemberChabun();
	public KosBoardVO getKosBoardChabun();
	public KosRboardVO getKosRboardChabun();
	public KosBoardlikeVO getKosBoardlikeChabun();
	public KosProductVO getKosProductChabun();
	public KoscartVO getKosCartChabun();
	public KosOrderVO getKosOrderChabun();
}
