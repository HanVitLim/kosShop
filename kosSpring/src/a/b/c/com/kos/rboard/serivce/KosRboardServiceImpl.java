package a.b.c.com.kos.rboard.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.rboard.dao.KosRboardDAO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;
@Service
@Transactional
public class KosRboardServiceImpl implements KosRboardService {

	@Autowired(required = false)
	private KosRboardDAO kosRboardDAO;

		
	@Override
	public List<KosRboardVO> kosRboardSelectAll(KosRboardVO krvo) {
		// TODO Auto-generated method stub
		return kosRboardDAO.kosRboardSelectAll(krvo);
	}


	@Override
	public int kosRboardInsert(KosRboardVO krvo) {
		// TODO Auto-generated method stub
		return kosRboardDAO.kosRboardInsert(krvo);
	}


	@Override
	public int kosRboardDelete(KosRboardVO krvo) {
		// TODO Auto-generated method stub
		return kosRboardDAO.kosRboardDelete(krvo);
	}

}
