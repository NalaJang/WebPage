package adminController;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.newOrderDao;
import hotelDto.HotelWorkerVo;
import hotelDto.OrderVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/admin_orderList.do")
public class OrderListController implements Controller{

	private newOrderDao orderDao;
	public OrderListController setOrderDao(newOrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelWorkerVo workerVo = (HotelWorkerVo)session.getAttribute("hotelWorker");
		
		if(workerVo == null) {
			return "redirect:../hotel/loginForm.do";
		} else {
			
			ArrayList<OrderVo> orderListAll = orderDao.orderListAll();
			model.put("orderList", orderListAll);
			
			return "/hotel/adminOrderList.jsp";
		}
	}

}
