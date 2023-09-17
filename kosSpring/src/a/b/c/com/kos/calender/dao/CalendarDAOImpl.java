package a.b.c.com.kos.calender.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kos.calender.vo.CalendarVO;

@Repository
public class CalendarDAOImpl implements CalendarDAO {

	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int calendarInsert(CalendarVO cvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("calendarInsert", cvo);
	}

	@Override
	public List<CalendarVO> calendarSelectAll(CalendarVO cvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("calendarSelectAll", cvo);
	}

}
