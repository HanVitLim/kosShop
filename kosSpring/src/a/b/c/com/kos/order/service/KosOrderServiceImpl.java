package a.b.c.com.kos.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.order.dao.KosOrderDAO;
import a.b.c.com.kos.order.vo.KosOrderVO;

@Service
@Transactional
public class KosOrderServiceImpl implements KosOrderService {

	@Autowired(required = false)
	private KosOrderDAO kosOrderDAO;
	
	@Override
	public int kosOrderInsert(KosOrderVO kovo) {
		// TODO Auto-generated method stub
		return kosOrderDAO.kosOrderInsert(kovo);
	}

}
