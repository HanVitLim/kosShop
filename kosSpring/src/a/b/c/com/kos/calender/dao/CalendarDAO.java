package a.b.c.com.kos.calender.dao;

import java.util.List;

import a.b.c.com.kos.calender.vo.CalendarVO;

public interface CalendarDAO {

	public int calendarInsert(CalendarVO cvo);
	public List<CalendarVO> calendarSelectAll(CalendarVO cvo);

	
}
