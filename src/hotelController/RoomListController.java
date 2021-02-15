package hotelController;

import java.util.Map;

import hotelDao.HotelRoomDao;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/room.do")
public class RoomListController implements Controller{
	
	private HotelRoomDao roomDao;
	public RoomListController setRoomDao(HotelRoomDao roomDao) {
		this.roomDao = roomDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("roomList", roomDao.roomList());
		return "/hotel/room.jsp";
	}

}
