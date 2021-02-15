package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.ShopCartDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopCartInsert.do")
public class ShopCartInsertController implements Controller, DataBinding{
	
	private ShopCartDao cartDao;
	public ShopCartInsertController setCartDao(ShopCartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			
			return "/hotel/login.jsp";
			
		} else {
			int pseq = (Integer)model.get("pseq");
			int quantity = (Integer)model.get("quantity");
			
			cartDao.cartInsert(memberVo.getEmail(), pseq, quantity);			
			
			return "redirect:../hotel/shopProductDetail.do?pseq=" + pseq;
		}		
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"pseq", Integer.class, "quantity", Integer.class};
	}

}
