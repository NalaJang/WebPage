package hotelController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ShopCartDao;
import hotelDto.CartVo;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/shopCartList.do")
public class ShopCartListController implements Controller{

	private ShopCartDao cartDao;
	
	public ShopCartListController setCartDao(ShopCartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

//		HotelMemberVo memberVo = (HotelMemberVo)model.get("memberVo");
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo.getEmail() == null) {
			
			return "/hotel/login.jsp";
		} else {
			ArrayList<CartVo> cartList = (ArrayList<CartVo>) cartDao.cartList(memberVo.getEmail());
			model.put("cartList", cartList);
			
			return "/hotel/shopCart.jsp";
		}
	}


}
