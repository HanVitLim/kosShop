package a.b.c.com.kos.cart.service;

import java.util.ArrayList;
import java.util.List;

import a.b.c.com.kos.cart.vo.KoscartVO;

public interface KoscartService {

	int koscartInsert(KoscartVO kcvo);
	List<KoscartVO> koscartSelectAll(KoscartVO kcvo);
	int koscartDelete(KoscartVO kcvo);
	int kosmoCartDeleteArray(ArrayList<KoscartVO> aList);
	List<KoscartVO> koscartorderSelectAll(ArrayList<KoscartVO> aList);

}
