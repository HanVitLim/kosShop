package a.b.c.com.kos.calender.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kos.calender.dao.CalendarDAO;
import a.b.c.com.kos.calender.vo.CalendarVO;

@Service
@Transactional
public class CalendarServiceImpl implements CalendarService {

	@Autowired(required = false)
	private CalendarDAO calendarDAO;
	
	@Override
	public int calendarInsert(CalendarVO cvo) {
		// TODO Auto-generated method stub
		return calendarDAO.calendarInsert(cvo);
	}

	@Override
	public List<CalendarVO> calendarSelectAll(CalendarVO cvo) {
		// TODO Auto-generated method stub
		return calendarDAO.calendarSelectAll(cvo);
	}

}
