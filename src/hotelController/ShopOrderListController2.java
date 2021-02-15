package hotelController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.newOrderDao;
import hotelDto.HotelMemberVo;
import hotelDto.OrderVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/shopOrderList2.do")
public class ShopOrderListController2 implements Controller{
	
	private newOrderDao orderDao;
	public ShopOrderListController2 setOrderDao(newOrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		int orderTotal = 0;

		if(memberVo == null) {
			return "/hotel/login.jsp";
			
		} else {
			
			ArrayList<OrderVo> orderList = orderDao.orderList(memberVo.getEmail());
			
			for(OrderVo orderVo : orderList) {
				orderTotal += orderVo.getPrice2() * orderVo.getQuantity();
			}
			
			model.put("orderList", orderList);
			model.put("orderTotal", orderTotal);
			
			return "/hotel/shopOrder.jsp";
		}
	}

}
