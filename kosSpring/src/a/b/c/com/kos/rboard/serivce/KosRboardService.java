package a.b.c.com.kos.rboard.serivce;

import java.util.List;

import a.b.c.com.kos.rboard.vo.KosRboardVO;

public interface KosRboardService {

	List<KosRboardVO> kosRboardSelectAll(KosRboardVO krvo);
	int kosRboardInsert(KosRboardVO krvo);
	int kosRboardDelete(KosRboardVO krvo);

}
