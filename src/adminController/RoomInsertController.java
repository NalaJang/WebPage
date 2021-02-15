package adminController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.HotelRoomDao;
import hotelDto.HotelWorkerVo;
import hotelDto.RoomInfoVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/roomInsert.do")
public class RoomInsertController implements Controller, DataBinding{
	
	private HotelRoomDao roomDao;
	public RoomInsertController setRoomDao(HotelRoomDao roomDao) {
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
			
			RoomInfoVo room = (RoomInfoVo)model.get("room");
			
			roomDao.insert(room);
			
			return "redirect:../hotel/roomList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"room", RoomInfoVo.class};
	}

}
