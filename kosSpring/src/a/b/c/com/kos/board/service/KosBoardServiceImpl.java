package a.b.c.com.kos.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.board.dao.KosBoardDAO;
import a.b.c.com.kos.board.vo.KosBoardVO;

@Service
@Transactional
public class KosBoardServiceImpl implements KosBoardService {

	@Autowired(required = false)
	private KosBoardDAO kosBoardDAO;

	@Override
	public int kosBoardInsert(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return kosBoardDAO.kosBoardInsert(kbvo);
	}

	@Override
	public List<KosBoardVO> kosBoardSelectAll(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return kosBoardDAO.kosBoardSelectAll(kbvo);
	}

	@Override
	public int kosBoardBhit(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return kosBoardDAO.kosBoardBhit(kbvo);
	}

	@Override
	public List<KosBoardVO> kosBoardSelectContents(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return kosBoardDAO.kosBoardSelectContents(kbvo);
	}

	@Override
	public List<KosBoardVO> kosBoardPwCheck(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return kosBoardDAO.kosBoardPwCheck(kbvo);
	}

	@Override
	public int kosBoardUpdate(KosBoardVO kbvo) {
		// TODO Auto-generated method stub
		return kosBoardDAO.kosBoardUpdate(kbvo);
	}


}
