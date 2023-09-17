package a.b.c.com.kos.rboard.dao;

import java.util.List;

import a.b.c.com.kos.rboard.vo.KosRboardVO;

public interface KosRboardDAO {

	List<KosRboardVO> kosRboardSelectAll(KosRboardVO krvo);
	int kosRboardInsert(KosRboardVO krvo);
	int kosRboardDelete(KosRboardVO krvo);
	
}
