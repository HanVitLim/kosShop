package a.b.c.com.kos.like.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.like.dao.KosBoardlikeDAO;
import a.b.c.com.kos.like.vo.KosBoardlikeVO;
@Service
@Transactional
public class KosBoardlikeServiceImpl implements KosBoardlikeService {

	
	@Autowired(required = false)
	private KosBoardlikeDAO kosBoardlikeDAO;
	
	
	@Override
	public List<KosBoardlikeVO> kosBoardLikeSelect(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return kosBoardlikeDAO.kosBoardLikeSelect(klvo);
	}


	@Override
	public int kosBoardLikeInsert(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return kosBoardlikeDAO.kosBoardLikeInsert(klvo);
	}


	@Override
	public int kosBoardLikeUpdate(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return kosBoardlikeDAO.kosBoardLikeUpdate(klvo);
	}


	@Override
	public List<KosBoardlikeVO> kosBoardLikeSelectAll(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return kosBoardlikeDAO.kosBoardLikeSelectAll(klvo);
	}


	@Override
	public int kosBoardLikeUpdate2(KosBoardlikeVO klvo) {
		// TODO Auto-generated method stub
		return kosBoardlikeDAO.kosBoardLikeUpdate2(klvo);
	}

}
