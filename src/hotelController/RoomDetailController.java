package hotelController;

import java.util.Map;

import hotelDao.HotelRoomDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/roomDetail.do")
public class RoomDetailController implements Controller, DataBinding {
	private HotelRoomDao roomDao;

	public RoomDetailController setRoomDao(HotelRoomDao roomDao) {
		this.roomDao = roomDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String kind = (String)model.get("kind");
		model.put("roomDetail", roomDao.room_detail(kind));
		
		return "/hotel/room.jsp";	//*****
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"kind", String.class};
	}
}
