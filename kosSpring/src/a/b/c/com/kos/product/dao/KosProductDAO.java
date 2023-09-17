package a.b.c.com.kos.product.dao;

import java.util.List;

import a.b.c.com.kos.product.vo.KosProductVO;

public interface KosProductDAO {

	int kosProductInsert(KosProductVO kpvo);
	List<KosProductVO> kosProductSelectAll(KosProductVO kpvo);
	List<KosProductVO> kosProductSelect(KosProductVO kpvo);
}
