package adminController;

import java.util.Map;

import hotelDao.HotelRoomDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/roomDelete.do")
public class RoomInfoDeleteController implements Controller, DataBinding{

	private HotelRoomDao roomDao;
	public RoomInfoDeleteController setRoomDao(HotelRoomDao roomDao) {
		this.roomDao = roomDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int rseq = (Integer)model.get("rseq");
		
		roomDao.delete(rseq);
		
		return "redirect:../hotel/roomList.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"rseq", Integer.class};
	}

}
