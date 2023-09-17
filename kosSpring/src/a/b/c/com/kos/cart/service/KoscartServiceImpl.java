package a.b.c.com.kos.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.cart.dao.KoscartDAO;
import a.b.c.com.kos.cart.vo.KoscartVO;

@Service
@Transactional
public class KoscartServiceImpl implements KoscartService {
	
	@Autowired(required = false)
	private KoscartDAO koscartDAO;
	
	
	@Override
	public int koscartInsert(KoscartVO kcvo) {
		// TODO Auto-generated method stub
		return koscartDAO.koscartInsert(kcvo);
	}


	@Override
	public List<KoscartVO> koscartSelectAll(KoscartVO kcvo) {
		// TODO Auto-generated method stub
		return koscartDAO.koscartSelectAll(kcvo);
	}


	@Override
	public int koscartDelete(KoscartVO kcvo) {
		// TODO Auto-generated method stub
		return koscartDAO.koscartDelete(kcvo);
	}


	@Override
	public int kosmoCartDeleteArray(ArrayList<KoscartVO> aList) {
		// TODO Auto-generated method stub
		return koscartDAO.kosmoCartDeleteArray(aList);
	}


	@Override
	public List<KoscartVO> koscartorderSelectAll(ArrayList<KoscartVO> aList) {
		// TODO Auto-generated method stub
		return koscartDAO.koscartorderSelectAll(aList);
	}

}
