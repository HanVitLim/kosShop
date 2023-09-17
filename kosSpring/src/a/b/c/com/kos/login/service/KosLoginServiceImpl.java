package a.b.c.com.kos.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.login.dao.KosLoginDAO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
@Service
@Transactional
public class KosLoginServiceImpl implements KosLoginService {

	@Autowired(required = false)
	private KosLoginDAO kosLoginDAO;
	
	
	@Override
	public List<KosMemberVO> kosLoginCheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosLoginDAO.kosLoginCheck(kvo);
	}
	
	@Override
	public int kakaoInsert(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosLoginDAO.kakaoInsert(kvo);
	}

	@Override
	public List<KosMemberVO> kakaoLogin(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosLoginDAO.kakaoLogin(kvo);
	}

}
