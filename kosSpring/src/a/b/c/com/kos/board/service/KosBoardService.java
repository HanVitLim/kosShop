package a.b.c.com.kos.board.service;

import java.util.List;

import a.b.c.com.kos.board.vo.KosBoardVO;

public interface KosBoardService {
	
	
	int kosBoardInsert(KosBoardVO kbvo);
	List<KosBoardVO> kosBoardSelectAll(KosBoardVO kbvo);
	int kosBoardBhit(KosBoardVO kbvo);
	List<KosBoardVO>kosBoardSelectContents(KosBoardVO kbvo);
	List<KosBoardVO>kosBoardPwCheck(KosBoardVO kbvo);
	int kosBoardUpdate(KosBoardVO kbvo);

}
