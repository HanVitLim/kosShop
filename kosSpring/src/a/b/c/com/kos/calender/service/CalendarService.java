package a.b.c.com.kos.calender.service;

import java.util.List;

import a.b.c.com.kos.calender.vo.CalendarVO;

public interface CalendarService {

	public int calendarInsert(CalendarVO cvo);
	public List<CalendarVO> calendarSelectAll(CalendarVO cvo);

}
