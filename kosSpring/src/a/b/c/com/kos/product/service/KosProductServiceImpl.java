package a.b.c.com.kos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.product.dao.KosProductDAO;
import a.b.c.com.kos.product.vo.KosProductVO;

@Service
@Transactional
public class KosProductServiceImpl implements KosProductService {

	
	@Autowired(required = false)
	private KosProductDAO kosProductDAO;
	
	@Override
	public int kosProductInsert(KosProductVO kpvo) {
		// TODO Auto-generated method stub
		return kosProductDAO.kosProductInsert(kpvo);
	}

	@Override
	public List<KosProductVO> kosProductSelectAll(KosProductVO kpvo) {
		// TODO Auto-generated method stub
		return kosProductDAO.kosProductSelectAll(kpvo);
	}

	@Override
	public List<KosProductVO> kosProductSelect(KosProductVO kpvo) {
		// TODO Auto-generated method stub
		return kosProductDAO.kosProductSelect(kpvo);
	}

}
