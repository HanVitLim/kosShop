package a.b.c.com.kos.mem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.mem.dao.KosMemberDAO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
@Service
@Transactional
public class KosMemberServiceImpl implements KosMemberService {

	
	@Autowired(required = false)
	private KosMemberDAO kosMemberDAO;
	
	@Override
	public int kosMemberInsert(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosMemberDAO.kosMemberInsert(kvo);
	}

	@Override
	public List<KosMemberVO> Idcheck(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosMemberDAO.Idcheck(kvo);
	}

	@Override
	public List<KosMemberVO> kosMemberSelectAll(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosMemberDAO.kosMemberSelectAll(kvo);
	}

	@Override
	public List<KosMemberVO> kosMemberSelect(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosMemberDAO.kosMemberSelect(kvo);
	}

	@Override
	public int kosMemberUpdate(KosMemberVO kvo) {
		// TODO Auto-generated method stub
		return kosMemberDAO.kosMemberUpdate(kvo);
	}

}
