package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.newOrderDao;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopOrderDirect.do")
public class ShopOrderDirectController implements Controller, DataBinding{

	private newOrderDao orderDao;
	public ShopOrderDirectController setOrderDao(newOrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			return "/hotel/login.jsp";
		
		} else {
//			int oseq = (Integer)model.get("oseq");
			int pseq = (Integer)model.get("pseq");
			int quantity = (Integer)model.get("quantity");
			
			orderDao.addOrder_direct(memberVo.getEmail());
			
													//oseq 받아오기
			orderDao.newOrder_detail_direct(orderDao.getOseq(memberVo.getEmail()), pseq, quantity);

			return "redirect:../hotel/shopOrderList2.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"pseq", Integer.class, "quantity", Integer.class};
	}

}
