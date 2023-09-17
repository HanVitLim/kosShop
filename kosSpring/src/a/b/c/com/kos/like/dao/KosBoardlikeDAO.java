package a.b.c.com.kos.like.dao;

import java.util.List;

import a.b.c.com.kos.like.vo.KosBoardlikeVO;

public interface KosBoardlikeDAO {
	
	List<KosBoardlikeVO> kosBoardLikeSelect(KosBoardlikeVO klvo);
	int kosBoardLikeInsert(KosBoardlikeVO klvo);
	int kosBoardLikeUpdate(KosBoardlikeVO klvo);
	List<KosBoardlikeVO> kosBoardLikeSelectAll(KosBoardlikeVO klvo);
	int kosBoardLikeUpdate2(KosBoardlikeVO klvo);
	
}
