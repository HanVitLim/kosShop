package a.b.c.com.kos.like.service;

import java.util.List;

import a.b.c.com.kos.like.vo.KosBoardlikeVO;

public interface KosBoardlikeService {

	List<KosBoardlikeVO> kosBoardLikeSelect(KosBoardlikeVO klvo);
	int kosBoardLikeInsert(KosBoardlikeVO klvo);
	int kosBoardLikeUpdate(KosBoardlikeVO klvo);
	List<KosBoardlikeVO> kosBoardLikeSelectAll(KosBoardlikeVO klvo);
	int kosBoardLikeUpdate2(KosBoardlikeVO klvo);
}
