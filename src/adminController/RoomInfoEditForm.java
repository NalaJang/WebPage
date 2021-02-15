package adminController;

import java.util.Map;

import hotelDao.HotelRoomDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/roomInfoEditForm.do")
public class RoomInfoEditForm implements Controller, DataBinding{

	private HotelRoomDao roomDao;
	public RoomInfoEditForm setRoomDao(HotelRoomDao roomDao) {
		this.roomDao = roomDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int rseq = (Integer)model.get("rseq");
		
		model.put("roomVo", roomDao.selectOne(rseq));
		
		return "/hotel/adminRoomInfoEdit.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"rseq", Integer.class};
	}
	
}
