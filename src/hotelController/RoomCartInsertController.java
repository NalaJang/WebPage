package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ShopRoomCartDao;
import hotelDto.HotelMemberVo;
import hotelDto.RoomCartVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/roomCartInsert.do")
public class RoomCartInsertController implements Controller, DataBinding{

	private ShopRoomCartDao roomCartDao;
	public RoomCartInsertController setCartDao(ShopRoomCartDao roomCartDao) {
		this.roomCartDao = roomCartDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		RoomCartVo roomCart = (RoomCartVo)model.get("roomCart");
		
		if(memberVo == null) {
			
			return "/hotel/login.jsp";
			
		} else {
			
			String kind = (String)model.get("kind");
			
			roomCartDao.roomCartInsert(roomCart, memberVo.getEmail());			
			
			return "redirect:../hotel/roomDetail.do?kind=" + kind;
		}
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"roomCart", RoomCartVo.class, "kind", String.class};
	}
}
