package hotelController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ShopRoomCartDao;
import hotelDto.HotelMemberVo;
import hotelDto.RoomCartVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/shopRoomCartList.do")
public class RoomCartListController implements Controller{

	private ShopRoomCartDao roomCartDao;
	
	public RoomCartListController setCartDao(ShopRoomCartDao roomCartDao) {
		this.roomCartDao = roomCartDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo.getEmail() == null) {
			
			return "/hotel/login.jsp";
			
		} else {
			ArrayList<RoomCartVo> roomCartList = roomCartDao.roomCartList(memberVo.getEmail());
			model.put("roomCartList", roomCartList);
			
			return "/hotel/shopRoomCart.jsp";
		}
	}


}
