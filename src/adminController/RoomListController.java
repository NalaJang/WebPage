package adminController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelRoomDao;
import hotelDto.HotelWorkerVo;
import hotelDto.RoomInfoVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/roomList.do")
public class RoomListController implements Controller{

	private HotelRoomDao roomDao;
	public RoomListController setRoomDao(HotelRoomDao roomDao) {
		this.roomDao = roomDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			return "/hotel/login.jsp";
		} else {
			
			ArrayList<RoomInfoVo> roomList = roomDao.roomList();
			model.put("roomList", roomList);
			
			return "/hotel/adminRoomList.jsp";
		}
	}
	
}
