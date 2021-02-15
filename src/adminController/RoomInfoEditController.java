package adminController;

import java.util.Map;

import hotelDao.HotelRoomDao;
import hotelDto.RoomInfoVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/roomInfoEdit.do")
public class RoomInfoEditController implements Controller, DataBinding{

	private HotelRoomDao roomDao;
	public RoomInfoEditController setRoomDao(HotelRoomDao roomDao) {
		this.roomDao = roomDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		RoomInfoVo roomVo = (RoomInfoVo) model.get("roomVo");
		int rseq = (Integer)model.get("rseq");
		
		if(roomVo.getRseq() == 0) {
			
			model.put("roomVo", roomDao.selectOne(rseq));

			return "/hotel/adminRoomInfoEdit.jsp";

		} else {
			
			roomDao.update(roomVo);

			return "redirect:../hotel/roomList.do";
		}
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"roomVo", RoomInfoVo.class, "rseq", Integer.class};
	}

}
